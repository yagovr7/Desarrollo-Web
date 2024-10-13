DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `mesCastellano`(mI INT, OUT mC VARCHAR(20))
BEGIN
	CASE mI
		WHEN 1 THEN SET mC = 'Enero';
		WHEN 2 THEN SET mC = 'Febrero';
		WHEN 3 THEN SET mC = 'Marzo';
		WHEN 4 THEN SET mC = 'Abril';
		WHEN 5 THEN SET mC = 'Mayo';
		WHEN 6 THEN SET mC = 'Junio';
		WHEN 7 THEN SET mC = 'Julio';
		WHEN 8 THEN SET mC = 'Agosto';
		WHEN 9 THEN SET mC = 'Septiembre';
		WHEN 10 THEN SET mC = 'Octubre';
		WHEN 11 THEN SET mC = 'Noviembre';
		WHEN 12 THEN SET mC = 'Diciembre';
 END CASE;
END