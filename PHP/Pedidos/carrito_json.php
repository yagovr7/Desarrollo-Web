<?php 	
/**
 * Para obtener los productos del carrito se usa carrito_json.php. Devuelve un array 
 * JSON con los datos de los productos presentes en el carrito y las unidades pedidas. 
 * Es muy parecido a carrito.php de la iteración anterior.
 */
	require 'sesiones_json.php';
	require_once 'bd.php';	
	if(!comprobar_sesion()) return;		
	$productos = cargar_productos(array_keys($_SESSION['carrito']));
	// hay que añadir las unidades
	//$productos = iterator_to_array($productos);
	foreach($productos as &$producto){
		$cod = $producto['CodProd'];
		$producto['unidades'] = $_SESSION['carrito'][$cod];	
	}
	echo json_encode($productos, true);

