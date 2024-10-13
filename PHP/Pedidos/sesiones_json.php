<?php
/**
 * Hay cambios en el control de acceso, que antes se basaba en una redirección. 
 * Ahora, la función comprobar_sesion () devuelve TRUE O FALSE según haya sesión abierta o no.

 */
function comprobar_sesion(){
	session_start();
	if(!isset($_SESSION['usuario'])){	
		return false;
	}else return true;		
}
