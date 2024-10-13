-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------

/*4.	Utilizando el bucle REPEAT. Crear un procedimiento que muestre 
la suma de los números pares comprendidos entre 100-90 (100-98-96-94-92-90). */

DROP PROCEDURE IF EXISTS `bucleREPEAT_a`;
DROP PROCEDURE IF EXISTS `bucleREPEAT_b`;

DELIMITER $$ -- Comienzo del procedimiento

CREATE DEFINER=`root`@`localhost` PROCEDURE `bucleREPEAT_a`()
BEGIN
DECLARE i TINYINT UNSIGNED DEFAULT 102;
DECLARE suma INT DEFAULT 0;
	bucleREPEAT:REPEAT
		SET I = I - 2;	
		SET SUMA = SUMA + I;
		UNTIL I = 90
	END REPEAT bucleREPEAT;
	SELECT CONCAT("SUMA: ", suma) as SUMA;
END$$

DELIMITER ; -- Fin del procedimiento




DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `bucleREPEAT_b`()
BEGIN
DECLARE i TINYINT UNSIGNED DEFAULT 100;
DECLARE suma INT DEFAULT 0;
	bucleREPEAT:REPEAT
			
		SET SUMA = SUMA + I;
        SET I = I - 2;
		UNTIL I < 90
	END REPEAT bucleREPEAT;
	SELECT CONCAT("SUMA: ", suma) as SUMA;
END$$

DELIMITER ; 