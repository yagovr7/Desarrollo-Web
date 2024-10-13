<?php 
/**
 * El fichero productos_json.php devuelve los datos de los productos de una 
 * categoría en formato JSON. El código de la categoría se pasa en la URL. 
 */
	require_once 'bd.php';
	/*comprueba que el usuario haya abierto sesión o devuelve*/
	require 'sesiones_json.php';
	if(!comprobar_sesion()) return;	
	$productos_array = [];
	$productos = cargar_productos_categoria($_GET['categoria']);			
	$cat_json = json_encode(iterator_to_array($productos), true);	
	echo $cat_json;