/*Realizar un procedimiento que acepte un número de departamento por parámetro y
devuelva mediante dos parámetros de tipo OUT su numero de director (DIRECTOR) y su presupuesto
(PRESUPUESTO)*/
DELIMITER $$
-- Utilizando INTO
CREATE DEFINER=`root`@`localhost` PROCEDURE `dirpresuPorDpto`(IN N INT, OUT DIRECTOR INT, OUT PRESUPUESTO DECIMAL(12,2))
BEGIN

if n in (select numde from tdepto) != 0 then
 	SELECT DIREC, PRESU INTO DIRECTOR, PRESUPUESTO FROM TDEPTO D WHERE NUMDE = N;
else
	SET DIRECTOR = 0, PRESUPUESTO = 0;
end if;

END