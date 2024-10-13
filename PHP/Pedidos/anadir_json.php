<?php 
/**
 * Los ficheros anadir_json.php y eliminar_json.php, son prácticamente iguales a los de la 
 * aplicación anterior. El único cambio es que no redirigen.
 */

require 'sesiones_json.php';
if(!comprobar_sesion()) return ;	
$cod = $_POST['cod'];
$unidades = (int)$_POST['unidades'];
/*si existe el código sumamos las unidades*/
if(isset($_SESSION['carrito'][$cod])){
	$_SESSION['carrito'][$cod] += $unidades;
}else{
	$_SESSION['carrito'][$cod] = $unidades;		
}