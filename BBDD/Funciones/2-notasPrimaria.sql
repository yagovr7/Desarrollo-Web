CREATE DEFINER=`root`@`localhost` FUNCTION `notasPrimaria`(nota DECIMAL(4,2), nombre VARCHAR(50)) RETURNS varchar(200) CHARSET utf8mb4
    READS SQL DATA
BEGIN
DECLARE notaLetra VARCHAR(100);

CASE 
	WHEN NOTA BETWEEN 1.0 AND 4.9 THEN
		SET notaLetra = 'Insuficiente';
	WHEN NOTA BETWEEN 5.0 AND 5.9 THEN
		SET notaLetra = 'Suficiente';
	WHEN NOTA BETWEEN 6.0 AND 6.9 THEN
		SET notaLetra = 'Bien';
	WHEN NOTA BETWEEN 7.0 AND 8.9 THEN
		SET notaLetra = 'Notable';
	WHEN NOTA BETWEEN 9.0 AND 10 THEN
		SET notaLetra = 'Sobresaliente';
	ELSE
		SET notaLetra = 'Nota incorrecta, debe introducir una nota 1 y 10';
	END CASE;
		
     IF (NOTA <1 OR NOTA > 10) THEN
		return notaLetra;
	 ELSE
		RETURN CONCAT(NOMBRE, ' tiene un ',notaLetra);    
	 END IF;
       

END