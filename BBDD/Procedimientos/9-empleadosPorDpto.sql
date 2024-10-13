-- Crear un procedimiento 'ejercicio2_1' que reciba un número de departamento por parámetro 
-- y visualice los empleados que trabajen en él.*/
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `empleadosPorDpto`(IN N INT)
BEGIN
SELECT * FROM TEMPLE WHERE NUMDE = N;
END