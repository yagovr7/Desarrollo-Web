DROP PROCEDURE IF EXISTS ERROR7;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ERROR7BIS`(P_ID INT, P_ALUMNO VARCHAR(30))
    MODIFIES SQL DATA
BEGIN
    DECLARE V_CLAVE_REPETIDA TINYINT DEFAULT 0;
   BEGIN -- Bloque INTERNO
        DECLARE CONTINUE HANDLER FOR 1062 SET V_CLAVE_REPETIDA = 1;
       
       INSERT INTO ALUMNOS VALUES (P_ID,P_ALUMNO);
        
    END;
    
    IF V_CLAVE_REPETIDA = 1 THEN
        SELECT CONCAT('Numero de matricula: ',p_id, ' ya existente') AS 'Aviso de error';
	ELSE
		SELECT CONCAT('Alumno dado de alta: ', p_alumno, ' con matricula numero ',p_id) AS 'Insercion de alumnos';
    END IF;

END