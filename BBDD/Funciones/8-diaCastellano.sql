CREATE DEFINER=`root`@`localhost` FUNCTION `diaCastellano`(dI VARCHAR(15)) RETURNS varchar(20) CHARSET utf8mb4
    DETERMINISTIC
BEGIN

	IF dI LIKE 'MONDAY' THEN return 'Lunes'; END IF; 
	IF dI LIKE 'TUESDAY' THEN return 'Martes'; END IF; 
	IF dI LIKE 'WEDNESDAY' THEN return 'Miércoles'; END IF; 
	IF dI LIKE 'THURSDAY' THEN return 'Jueves'; END IF; 
	IF dI LIKE 'FRIDAY' THEN return 'Viernes'; END IF; 
	IF dI LIKE 'SATURDAY' THEN return 'Sábado'; END IF; 
	IF dI LIKE 'SUNDAY' THEN return 'Domingo'; END IF;
END