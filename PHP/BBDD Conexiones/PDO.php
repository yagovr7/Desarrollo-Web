<?php
//Crear conexion
$host = "localhost";
$db = "proyecto";
$user = "root";
$pass = "root";
$dsn = "mysql:host=$host;dbname=$db";

// o

$dsn = "mysql:host=$host;dbname=$db;charset=utf8mb4";
$conProyecto=new PDO($dsn, $user, $pass);

//Información del estado de la conexión
$version = $conProyecto->getAttribute(PDO::ATTR_SERVER_VERSION);
echo "Versión: $version";

//Y si quieres por ejemplo que te devuelva todos los nombres de columnas en mayúsculas
$version = $conProyecto->setAttribute(PDO::ATTR_CASE, PDO::CASE_UPPER);
echo "Versión: $version";

//Errores
/*
ERRMODE_SILENT: El modo por defecto, no muestra errores (se recomienda en entornos en producción).
ERRMODE_WARNING: Además de establecer el código de error, emitirá un mensaje E_WARNING, es el modo 
empleado para depurar o hacer pruebas para ver errores sin interrumpir el flujo de la aplicación.
ERRMODE_EXCEPTION: Además de establecer el código de error, lanzará una PDOException que podemos 
capturar en un bloque try catch(). Lo veremos en el apartado 4.1.
*/
$conProyecto->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

//Consultas
/*
En el caso de las consultas de acción, como INSERT, DELETE o UPDATE, el método exec devuelve 
el número de registros afectados.
*/
$registros = $conProyecto->exec('DELETE FROM stocks WHERE unidades=0');
echo "<p>Se han borrado $registros registros.</p>";

// otro ejemplo
$conProyecto->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);
$resultado = $conProyecto->query("SELECT producto, unidades FROM stock");

//Mas de errores
$ok = true;
$conProyecto->beginTransaction();
if(!$conProyecto->exec('DELETE …')) $ok = false;
if(!$conProyecto->exec('UPDATE …')) $ok = false;

if ($ok) $conProyecto->commit();  // Si todo fue bien confirma los cambios

else $dwes->rollback();

//Recorrer
/*
PDO::FETCH_ASSOC. Devuelve solo un array asociativo.
PDO::FETCH_NUM. Devuelve solo un array con claves numéricas.
PDO::FETCH_BOTH. Devuelve un array con claves numéricas y asociativas. Es el comportamiento por defecto.
PDO::FETCH_OBJ. Devuelve un objeto cuyas propiedades se corresponden con los campos del registro.
*/
$conProyecto = new PDO(". . .");
$resultado = $conProyecto->query("SELECT producto, unidades FROM stocks");
while ($registro = $resultado->fetch()) {
    echo "Producto ".$registro['producto'].": ".$registro['unidades']."<br />";
}
// o
$conProyecto = new PDO(". . .");
$resultado = $conProyecto->query("SELECT producto, unidades FROM stocks");
while ($registro = $resultado->fetch(PDO::FETCH_OBJ)) {
   echo "Producto ".$registro->producto.": ".$registro->unidades."<br />";
}
// o
$conProyecto = new PDO(". . .");
$resultado = $conProyecto->query("SELECT producto, unidades FROM stocks");
$resultado->bindColumn(1, $producto);
$resultado->bindColumn(2, $unidades);
while ($registro = $resultado->fetch(PDO::FETCH_OBJ)) {
    echo "Producto ".$producto.": ".$unidades."<br />";
}
// o
$resultado = $stmt->fetchAll(PDO::FETCH_ASSOC);
foreach ($resultado as $row){
    echo $row["nombre"]." ".$row["apellido"];
}

//Consultas preparadas
$conProyecto = new PDO(". . .");
$stmt = $conProyecto->prepare('INSERT INTO familia (cod, nombre) VALUES (?, ?)');
// o
$stmt = $conProyecto->prepare('INSERT INTO familia (cod, nombre) VALUES (:cod, :nombre)');

$cod_producto = "TABLET";
$nombre_producto = "Tablet PC";
//$consulta->bindParam(1, $cod_producto);
//$consulta->bindParam(2, $nombre_producto);
//Si utilizas parámetros con nombre, debes indicar ese nombre en la llamada a bindParam.
//$consulta->bindParam(":cod", $cod_producto);
//$consulta->bindParam(":nombre", $nombre_producto);
$stmt->execute();

//También existe otra forma de pasar valores a los parámetros. Hay un método lazy, que funciona 
//pasando los valores mediante un array, al método execute().

$nombre="Monitores";
$codigo="MONI";
$stmt = $conProyecto->prepare('INSERT INTO familia (cod, nombre) VALUES (:cod, :nombre)');
$stmt->execute([ ':cod'=>$codigo, ':nombre'=>$nombre]);


//Manejo de excepciones
$host = "localhost";
$db = "proyecto";
$user = "gestor";
$pass = "1234";
$dsn = "mysql:host=$host;dbname=$db"; 
try {
    $conProyecto = new PDO($dsn, $user, $pass);
    $conProyecto->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $ex) {
            die("Error en la conexion, mensaje de error:  " . $ex->getMessage());
}
//Captura la excepción que lanza PDO debido a que la contraseña era "secreto" y no "1234". El bloque catch muestra el siguiente mensaje:
//Error en la conexion, mensaje de error: SQLSTATE[HY000] [1045] Access denied for user 'gestor'@'localhost' (using password: YES)
//Cerrar conexion
$conProyecto = null;