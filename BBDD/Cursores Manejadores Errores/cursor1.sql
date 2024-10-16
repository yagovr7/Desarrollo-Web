DROP PROCEDURE IF EXISTS CURSOR1;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cursor1`()
BEGIN
    DECLARE V_ID INT;
    DECLARE V_NOMBRE VARCHAR(45);
    
    DECLARE C_ALUMNOS CURSOR FOR
    SELECT ID, NOMBRE
    FROM ALUMNOS
    WHERE ID <= 2; -- Devuelve las 2 primeras filas
    
    OPEN C_ALUMNOS;
    ALUMNOS_CURSOR: LOOP
        FETCH C_ALUMNOS INTO V_ID, V_NOMBRE;
        SELECT V_ID, V_NOMBRE;
    END LOOP ALUMNOS_CURSOR;
    CLOSE C_ALUMNOS;
        
        
END