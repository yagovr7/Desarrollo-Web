DROP PROCEDURE IF EXISTS ERROR2;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ERROR2`(p_id INT, p_alumno VARCHAR(30))
    MODIFIES SQL DATA
BEGIN
    DECLARE CONTINUE HANDLER FOR 1062
    SELECT CONCAT ('Numero de matricula ', p_id, ' ya existente') AS 'Aviso de error';

    INSERT INTO ALUMNOS VALUES (P_ID, P_ALUMNO);
    
    SELECT 'Finish............';

END