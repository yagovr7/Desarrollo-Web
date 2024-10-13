DROP PROCEDURE IF EXISTS ERROR13;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ERROR13`(p_id INT, p_alumnos VARCHAR(30), 
							OUT p_error_num INT, OUT p_error_text VARCHAR(100))
BEGIN

DECLARE clave_repetida_error CONDITION FOR 1062;
DECLARE CONTINUE HANDLER FOR clave_repetida_error
BEGIN
	SET p_error_num = 1062;
	SET p_error_text = 'Clave duplicada';
END;

DECLARE CONTINUE HANDLER FOR 1048
BEGIN
	SET p_error_num = 1048;
	SET p_error_text = 'Clave nula';
END;

DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
BEGIN
	SET p_error_num = -1;
	SET p_error_text = 'Ocurrio un error';
END;



SET p_error_num = 0;
INSERT INTO ALUMNOS VALUES(p_id,p_alumnos);
-- select 'Alta correcta';
IF (p_error_num = 0 ) THEN
	SET p_error_text = 'Alta de alumnos realizada correctamente';
END IF;
END