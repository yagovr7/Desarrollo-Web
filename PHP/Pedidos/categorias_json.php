<?php	
/**
 * El fichero categorias_json.php devuelve los datos de la tabla de categorías en 
 * formato JSON. Utiliza la función cargar_categorias (), la misma que en la anterior 
 * iteración. La función json_enconde () un array a formato JSON. 
 * Como cargar_categorias () devuelve un cursor, se utiliza iterator_to_array() 
 * para convertirlo.
 */
	require_once 'sesiones_json.php';
	require_once 'bd.php';	
	if(!comprobar_sesion())return;
		$categorias = cargar_categorias();
		$cat_json = json_encode(iterator_to_array($categorias), true);	
		echo $cat_json;
	
	
