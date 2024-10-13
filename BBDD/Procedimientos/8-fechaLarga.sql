DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `fechaLarga`( F DATE)
BEGIN
	DECLARE D, M VARCHAR(20);
	CALL diaCastellano(DAYNAME(F),D);
	CALL mesCastellano(MONTH(F),M);
	

	SELECT CONCAT(D, ', ', DAY(F), ' de ', M, ' de ', YEAR(F)) AS FECHALARGA;
END