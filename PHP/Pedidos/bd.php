<?php
/**
 * Sin cambios respecto a la primera iteración.
 */
function leer_config($nombre, $esquema){
	$config = new DOMDocument();
	$config->load($nombre);
	$res = $config->schemaValidate($esquema);
	if ($res===FALSE){ 
	   throw new InvalidArgumentException("Revise fichero de configuración");
	} 		
	$datos = simplexml_load_file($nombre);	
	$ip = $datos->xpath("//ip");
	$nombre = $datos->xpath("//nombre");
	$usu = $datos->xpath("//usuario");
	$clave = $datos->xpath("//clave");	
	$cad = sprintf("mysql:dbname=%s;host=%s", $nombre[0], $ip[0]);
	$resul = [];
	$resul[] = $cad;
	$resul[] = $usu[0];
	$resul[] = $clave[0];
	return $resul;
}
function comprobar_usuario($nombre, $clave){
	$res = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");
	$bd = new PDO($res[0], $res[1], $res[2]);
	$ins = "select codBibl, correo from bibliotecas where correo = '$nombre' 
			and clave = '$clave'";
	$resul = $bd->query($ins);	
	if($resul->rowCount() === 1){		
		return $resul->fetch();		
	}else{
		return FALSE;
	}
}
function cargar_categorias(){
	$res = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");
	$bd = new PDO($res[0], $res[1], $res[2]);
	$ins = "select codCat, nombre from categoria";
	$resul = $bd->query($ins);	
	if (!$resul) {
		$errorInfo = $bd->errorInfo();
        die("Error en la consulta SQL: " . $errorInfo[2]);
	}
	if ($resul->rowCount() === 0) {    
		return FALSE;
    }
	//si hay 1 o más
	return $resul;	
}
function cargar_categoria($codCat){
	$res = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");
	$bd = new PDO($res[0], $res[1], $res[2]);
	$ins = "select nombre, descripcion from categoria where codcat = $codCat";
	$resul = $bd->query($ins);	
	if (!$resul) {
		return FALSE;
	}
	if ($resul->rowCount() === 0) {    
		return FALSE;
    }	
	//si hay 1 o más
	return $resul->fetch();	
}
function cargar_productos_categoria($codCat){
	$res = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");
	$bd = new PDO($res[0], $res[1], $res[2]);	
	$sql = "select * from productos where CodCat  = $codCat";	
	$resul = $bd->query($sql);	
	if (!$resul) {
		return FALSE;
	}
	if ($resul->rowCount() === 0) {    
		return FALSE;
    }	
	//si hay 1 o más
	return $resul;			
}
// recibe un array de códigos de productos
// devuelve un cursor con los datos de esos productos
/**
 * Recibe como argumento un array de códigos de productos y devuelve un cursos con todas las columnas de estos. Si hay algún error con la BD,
 * devuelve FALSE. Esta función se usa al mostrar el carrito de la compra
 */
function cargar_productos($codigosProductos){
    // Lee la configuración desde el archivo XML
    $configuracion = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");

    // Intenta conectar a la base de datos
    try {
        $bd = new PDO($configuracion[0], $configuracion[1], $configuracion[2]);
        $bd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    } catch (PDOException $e) {
        // En caso de error, devuelve FALSE
        return FALSE;
    }

    // Construye la consulta con marcadores de posición
    $placeholders = implode(',', array_fill(0, count($codigosProductos), '?'));

    $ins = "SELECT * FROM productos WHERE CodProd IN ($placeholders)";

    try {
        // Prepara la consulta
        $stmt = $bd->prepare($ins);

        // Vincula los valores al statement
        foreach ($codigosProductos as $key => $value) {
            $stmt->bindValue(($key+1), $value, PDO::PARAM_INT); // Nota: PDO utiliza un índice basado en 1
        }

        // Ejecuta la consulta
        $stmt->execute();

        // Retorna los resultados como un conjunto de filas asociativas
        return $stmt->fetchAll(PDO::FETCH_ASSOC);

    } catch (PDOException $e) {
        // En caso de error en la ejecución de la consulta, devuelve FALSE
        return FALSE;
    }
}

/*function cargar_productos($codigosProductos){
	$res = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");
	$bd = new PDO($res[0], $res[1], $res[2]);
	$texto_in = implode(",", $codigosProductos);
	$ins = "select * from productos where codProd in ($texto_in)";
	$resul = $bd->query($ins);	
	if (!$resul) {
		return FALSE;
	}
	return $resul;	
}*/
function insertar_pedido($carrito, $codRes) {
    $res = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");
    $bd = new PDO($res[0], $res[1], $res[2]);
    $bd->beginTransaction();
    $hora = date("Y-m-d H:i:s", time());

    // Insertar el pedido usando una declaración preparada
    $sql = "INSERT INTO pedidos (Fecha, Enviado, bibliotecas) VALUES (:fecha, 0, :codRes)";
    $stmtPedido = $bd->prepare($sql);
    $stmtPedido->bindParam(':fecha', $hora, PDO::PARAM_STR);
    $stmtPedido->bindParam(':codRes', $codRes, PDO::PARAM_INT);
    $stmtPedido->execute();

    // Obtener el ID del último pedido insertado
    $idPedido = $bd->lastInsertId();

    // Insertar las filas en pedidosproductos usando una declaración preparada
    $sqlProductos = "INSERT INTO pedidosproductos (CodPed, CodProd, Unidades) VALUES (:idPedido, :codProd, :unidades)";
    $stmtProductos = $bd->prepare($sqlProductos);

    foreach ($carrito as $codProd => $unidades) {
        // Verificar la existencia del producto
        $stmtCheckProducto = $bd->prepare("SELECT COUNT(*) FROM productos WHERE CodProd = :codProd");
        $stmtCheckProducto->bindParam(':codProd', $codProd, PDO::PARAM_INT);
        $stmtCheckProducto->execute();

        if ($stmtCheckProducto->fetchColumn() > 0) {
            // Producto existe, continuar con la inserción
            $stmtProductos->bindParam(':idPedido', $idPedido, PDO::PARAM_INT);
            $stmtProductos->bindParam(':codProd', $codProd, PDO::PARAM_INT);
            $stmtProductos->bindParam(':unidades', $unidades, PDO::PARAM_INT);
            $stmtProductos->execute();

            if ($stmtProductos->rowCount() === 0) {
                // Si no se insertó ninguna fila, hacer rollback y retornar FALSE
                $bd->rollback();
                return FALSE;
            }
        } else {
            // Producto no existe, hacer rollback y retornar FALSE
            $bd->rollback();
            return FALSE;
        }
    }

    // Commit solo si todas las inserciones fueron exitosas
    $bd->commit();
    return $idPedido;
}


/*function insertar_pedido($carrito, $codRes){
	$res = leer_config(dirname(__FILE__)."/configuracion.xml", dirname(__FILE__)."/configuracion.xsd");
	$bd = new PDO($res[0], $res[1], $res[2]);
	$bd->beginTransaction();	
	$hora = date("Y-m-d H:i:s", time());
	// insertar el pedido
	$sql = "insert into pedidos(fecha, enviado, restaurante) 
			values('$hora',0, $codRes)";
	$resul = $bd->query($sql);	
	if (!$resul) {
		return FALSE;
	}
	// coger el id del nuevo pedido para las filas detalle
	$pedido = $bd->lastInsertId();
	// insertar las filas en pedidoproductos
	foreach($carrito as $codProd=>$unidades){
		$sql = "insert into pedidosproductos(Pedido, Producto, Unidades) 
		             values( $pedido, $codProd, $unidades)";			
		 $resul = $bd->query($sql);	
		if (!$resul) {
			$bd->rollback();
			return FALSE;
		}
	}
	$bd->commit();
	return $pedido;
}*/

