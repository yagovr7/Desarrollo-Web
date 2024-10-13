<?php
	/**
	 * El fichero procesar_pedido.php también es muy parecido al de la primera versión.
	 * En lugar de devolver un mensaje, devuelve las cadenas TRUE o FALSE según se 
	 * haya podido insertar el o no. 
	 */
	/*comprueba que el usuario haya abierto sesión o redirige*/
	//require 'correo.php';	
	require_once 'bd.php';
	/*comprueba que el usuario haya abierto sesión o devuelve*/
	require 'sesiones_json.php';
	if(!comprobar_sesion()) return;	
	$resul = insertar_pedido($_SESSION['carrito'], $_SESSION['usuario']['codBibl']);
	if($resul === FALSE){
		echo "FALSE";			
	}else{
		$correo = $_SESSION['usuario']['correo'];
		//$conf = enviar_correos($_SESSION['carrito'], $resul, $correo);							
		echo "TRUE";
		//vaciar carrito	
		$_SESSION['carrito'] = [];
	}		
	