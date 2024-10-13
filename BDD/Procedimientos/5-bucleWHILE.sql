-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
/*5.	Utilizando el bucle WHILE. Crear un procedimiento que muestre 
la suma de los 100 primerosnúmeros naturales (1-2............99-100). */

DROP PROCEDURE IF EXISTS `bucleWHILE`;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `bucleWHILE`()
BEGIN
DECLARE i TINYINT UNSIGNED DEFAULT 0;
DECLARE suma INT DEFAULT 0;
	bucleWHILE:WHILE i < 100 DO
		SET I = I + 1;	
		SET SUMA = SUMA + I;
	END WHILE bucleWHILE;
	SELECT CONCAT("SUMA: ", suma) as SUMA;
END