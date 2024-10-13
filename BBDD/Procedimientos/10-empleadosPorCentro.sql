DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `empleadosPorCentro`(IN N INT )
BEGIN

if n in (select numce from tcentr) != 0 then

SELECT d.NUMCE, e.* 
 FROM TEMPLE E , TDEPTO D  
 WHERE 
  D.NUMDE = E.NUMDE AND
  D.NUMCE = N;
else
 select concat('El Centro ', n, ' no existe') as datos;
 end if;


END