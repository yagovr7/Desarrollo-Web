<?php 
/**
 * Los ficheros anadir_json.php y eliminar_json.php, son prácticamente iguales a los de la 
 * aplicación anterior. El único cambio es que no redirigen.
 */
/*comprueba que el usuario haya abierto sesión*/
require_once 'sesiones_json.php';
if(!comprobar_sesion()) return;	
$cod = $_POST['cod'];
$unidades = $_POST['unidades'];
/*si existe el código restamos las unidades, con mínimo de 0*/
if(isset($_SESSION['carrito'][$cod])){		
	$_SESSION['carrito'][$cod] -= $unidades;
	if($_SESSION['carrito'][$cod] <= 0){
		unset($_SESSION['carrito'][$cod]);
	}
	
}

