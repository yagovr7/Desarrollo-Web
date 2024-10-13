-- 1.	Utilizando el comando IF. Crear un procedimiento ‘siDivisible’ que reciba 2 números y muestre sí el primero es divisible por el segundo.

DROP PROCEDURE IF EXISTS `siDivisible`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `siDivisible`( N1 INT, N2 INT )
BEGIN
	IF (N1 MOD N2) = 0 THEN
		SELECT concat(N1, ' es divisible por ', N2) as Resultado;
	ELSE
    	SELECT concat(N1, ' NO es divisible por ', N2) as Resultado;
     END IF;   
	
END