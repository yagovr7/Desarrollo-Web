
DROP PROCEDURE IF EXISTS `operacionesAritmeticas_a`;
DROP PROCEDURE IF EXISTS `operacionesAritmeticas_b`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `operacionesAritmeticas_a`(  IN N1 NUMERIC(5,2), N2 NUMERIC(5,2))
BEGIN

-- SUMA
	SELECT CONCAT('La suma de: ', n1,  ' + ', n2 ,' es: ' , n1+n2) AS SUMA;

-- RESTA
	SELECT CONCAT('La resta de: ', n1,  ' - ', n2 ,' es: ' , n1-n2) AS RESTA;

    
-- PRODUCTO
   SELECT CONCAT('El producto de : ', n1,  ' * ', n2 ,' es: ' , n1*n2) AS PRODUCTO;
   
-- DIVISION

	IF N2 = 0 THEN
		SELECT CONCAT('La division entre: ', n1,  ' y ', n2 ,' es: INDETERMINADA ') AS DIVISION;
	ELSE
		
        SELECT CONCAT('La division entre: ', n1,  ' y ', n2 ,' es: ' , n1/n2) AS DIVISION;
   	END IF;
    
    
END $$

DELIMITER ;



