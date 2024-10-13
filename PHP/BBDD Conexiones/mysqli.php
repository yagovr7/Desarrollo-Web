<?php
//Establecer conexion
$conProyecto = new mysqli('localhost', 'usuario', 'contraseña', 'base de datos');

//Errores al conectar
$conProyecto = new mysqli('localhost', 'gestor', 'secreto', 'proyecto');
$error = $conProyecto->connect_errno;
if ($error != null) {
     echo "<p>Error $error conectando a la base de datos: $conProyecto->connect_error</p>";
     die();
}

//Cambiar base de datos una vez establecida la conexion
$conProyecto->select_db('otra_bd');

//Cerrar conexion
$conProyecto->close();

//Consultas
$conProyecto = new mysqli('localhost', 'root', 'root', 'proyecto');
$error = $conProyecto->connect_errno;
if ($error == null) {
    $resultado = $conProyecto->query('SELECT producto, unidades FROM stocks WHERE unidades<2');

    $stock = $resultado->fetch_object();

    while ($stock != null) {

            echo "<p>Producto $stock->producto: $stock->unidades unidades.</p>";

            $stock = $resultado->fetch_object();

    }
    $conProyecto->close(); //cerramos la conexion
}

//$stmt devuelve booleano podemos usarlo para controlar errores
$stmt=$conProyecto->stmt_init();
$cod=1;
$consulta="select nombre from productos where id=?";
if(!($stmt->prepare($consulta))){
    echo "Se ha producido un error: " . $conProyecto->error();
    die();
}
$stmt->bind_param('i', $cod);
if(!$stmt->execute()){
     //error
}

//Consultas preparadas
//Carácter.	Tipo del parámetro.
//i.	Número entero.
//i.	Número real (doble precisión).
//s.	Cadena de texto.
//b.	Contenido en formato binario (BLOB).
$stmt = $conProyecto->stmt_init();
$stmt->prepare('INSERT INTO familias (cod, nombre) VALUES (?, ?)');
$cod_producto = "TABLET";
$nombre_producto = "Tablet PC";
$stmt->bind_param('ss', $cod_producto, $nombre_producto);
$stmt->execute();
$stmt->close();
$conProyecto->close();

//o

$stmt = $conProyecto->stmt_init();
$stmt->prepare('SELECT producto, unidades FROM stocks WHERE unidades<2');
$stmt->execute();
$stmt->bind_result($producto, $unidades);
while($stmt->fetch()) {
    echo "<p>Producto $producto: $unidades unidades.</p>";
}
$stmt->close();
$conProyecto->close();

/*
El método "query()" tiene un parámetro opcional que afecta a cómo se obtienen 
internamente los resultados, pero no a la forma de utilizarlos posteriormente. 
En la opción por defecto, MYSQLI_STORE_RESULT, los resultados se recuperan todos 
juntos de la base de datos y se almacenan de forma local. Si cambiamos esta opción 
por el valor MYSQLI_USE_RESULT, los datos se van recuperando del servidor según se 
vayan necesitando.
*/

$resultado = $conProyecto->query('SELECT producto, unidades FROM stock', MYSQLI_USE_RESULT);

/*
Es importante tener en cuenta que los resultados obtenidos se almacenarán en memoria 
mientras los estés usando. Cuando ya no los necesites, los puedes liberar con el método 
free de la clase mysqli_result (o con la función mysqli_free_result):
*/

$resultado->free();

//Comit si se a relizado la operacion
$conProyecto->query('DELETE FROM stock WHERE unidades=0');  // Inicia una transacción

$conProyecto->query('UPDATE stock SET unidades=3 WHERE producto="STYLUSSX515W"');

$conProyecto->commit();

/*
fetch_array (función mysqli_fetch_array). Obtiene un registro completo del conjunto de resultados 
y lo almacena en un array. Por defecto el array contiene tanto claves numéricas como asociativas. 
Por ejemplo, para acceder al primer campo devuelto, podemos utilizar como clave el número 0 o su 
nombre indistintamente.
$resultado = $conProyecto->query('SELECT producto, unidades FROM stocks WHERE unidades<2');

$stock = $resultado->fetch_array();  // Obtenemos el primer registro

$producto = $stock['producto'];  // O también $stock[0];

$unidades = $stock['unidades'];  // O también $stock[1];

echo "<p>Producto $producto: $unidades unidades.</p>";
Este comportamiento por defecto se puede modificar utilizando un parámetro opcional, que puede 
tomar los siguientes valores:

MYSQLI_NUM. Devuelve un array con claves numéricas.
MYSQLI_ASSOC. Devuelve un array asociativo.
MYSQLI_BOTH. Es el comportamiento por defecto, en el que devuelve un array con claves numéricas y 
asociativas.
fetch_assoc (función mysqli_fetch_assoc). Idéntico a fetch_array pasando como parámetro MYSQLI_ASSOC.
fetch_row (función mysqli_fetch_row). Idéntico a fetch_array pasando como parámetro MYSQLI_NUM.
fetch_object (función mysqli_fetch_object). Similar a los métodos anteriores, pero devuelve un objeto 
en lugar de un array. Las propiedades del objeto devuelto se corresponden con cada uno de los campos 
del registro.
*/