DROP PROCEDURE IF EXISTS ERROR5;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ERROR5`(IN I INT, in N VARCHAR(30))
BEGIN
DECLARE V_RESULTADO VARCHAR(40);

CALL ERROR4(I,N, v_resultado);-- Llamada al procedimiento ERROR4

IF V_RESULTADO = 'CORRECTO' THEN
    SELECT 'Alumno dado de alta' AS 'Insercion de alumnos';
ELSE
    SELECT V_RESULTADO AS 'Aviso de error';
END IF;
END