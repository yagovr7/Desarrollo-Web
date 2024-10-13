CREATE DEFINER=`root`@`localhost` PROCEDURE `operacionesAritmeticasBIS`(IN N1 NUMERIC(5,2), N2 NUMERIC(5,2))
    DETERMINISTIC
BEGIN
-- SUMA
	SELECT CONCAT('La suma de: ', n1,  ' + ', n2 ,' es: ' , suma(n1,n2)) AS SUMA;

-- RESTA
	SELECT CONCAT('La resta de: ', n1,  ' - ', n2 ,' es: ' , resta(n1,n2)) AS RESTA;

    
-- PRODUCTO
   SELECT CONCAT('El producto de : ', n1,  ' * ', n2 ,' es: ' , producto(n1,n2)) AS PRODUCTO;
   
-- DIVISION

	IF N1 = 0 AND N2 = 0 THEN
		SELECT CONCAT('La division entre: ', n1,  ' y ', n2 ,' es: Resultado Indefinido') AS DIVISION;
	END IF;
	
	
	IF N1 != 0 AND N2 = 0 THEN
		SELECT CONCAT('La division entre: ', n1,  ' y ', n2 ,' es: No se puede dividir entre cero') AS DIVISION;
	END IF;
    
    IF N1 <> 0 AND N2 <> 0 THEN
	
	      SELECT CONCAT('La division entre: ', n1,  ' y ', n2 ,' es: ' , division(n1,n2)) AS DIVISION;
   	END IF;

END