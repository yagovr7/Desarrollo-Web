/*Crear un procedimiento que acepte un numero de centro por parámetro y 
visualice los empleados que trabajan en él*/
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `empleadosPorCentroBIS`(N INT)
BEGIN

if n in (select numce from tcentr) != 0 then
	SELECT  N as NUMCE, TEMPLE.*
	FROM TEMPLE  
	WHERE NUMDE IN (SELECT NUMDE FROM TDEPTO 
					WHERE NUMCE = N);

else
 select concat('El Centro ', n, ' no existe') as datos;
 end if;


END