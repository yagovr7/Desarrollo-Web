DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `diaCastellano`(dI VARCHAR(15), OUT dC VARCHAR(15))
BEGIN
	IF dI LIKE 'MONDAY' THEN SET dC = 'Lunes'; END IF; 
	IF dI LIKE 'TUESDAY' THEN SET dC = 'Martes'; END IF; 
	IF dI LIKE 'WEDNESDAY' THEN SET dC = 'Miércoles'; END IF; 
	IF dI LIKE 'THURSDAY' THEN SET dC = 'Jueves'; END IF; 
	IF dI LIKE 'FRIDAY' THEN SET dC = 'Viernes'; END IF; 
	IF dI LIKE 'SATURDAY' THEN SET dC = 'Sábado'; END IF; 
	IF dI LIKE 'SUNDAY' THEN SET dC = 'Domingo'; END IF; 


END