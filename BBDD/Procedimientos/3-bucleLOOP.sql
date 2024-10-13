-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------

/*3.	Utilizando el bucle LOOP. Crear un procedimiento que muestre la suma de los números pares comprendidos entre 1-20 
excepto el 10 (2-4-6-8-12-14-16-18-20). */

DROP PROCEDURE IF EXISTS `bucleLOOP`;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `bucleLOOP`()
BEGIN
	
	DECLARE i TINYINT UNSIGNED DEFAULT 0;
	DECLARE suma INT DEFAULT 0;
	bucleLOOP:LOOP
		SET I = I + 2;	
		IF I = 10 THEN
			ITERATE bucleLOOP;
		END IF;
		IF I > 20 THEN
			LEAVE bucleLOOP;
		END IF;
		SET SUMA = SUMA + I;
	END LOOP bucleLOOP;
	SELECT CONCAT("SUMA: ", suma) as SUMA;

END