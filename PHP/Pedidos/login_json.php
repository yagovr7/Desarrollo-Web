<?php
require_once 'bd.php';
/*En esta versión de la aplicación los ficheros del servidor son más sencillos 
porque no hay que ocuparse de la salida. Del login se encarga login_json.php. Es
 parecido al fichero de login original, pero solo tiene la parte de procesamiento. 
 El formulario está en página principal (y única). Además, no redirige. Si hay error, 
 devuelve la cadena FALSE; y si no crea las variables de sesión, devuelve la cadena TRUE.*/
if ($_SERVER["REQUEST_METHOD"] == "POST") {  
	$usu = comprobar_usuario($_POST['usuario'], $_POST['clave']);
	if($usu===FALSE){
		echo "FALSE";
		header("Location: bd.php");
	}else{
		session_start();
		// $usu tiene campos correo y codRes, correo 
		$_SESSION['usuario'] = $usu;
		$_SESSION['carrito'] = [];
		echo "TRUE";
		
	}	
}