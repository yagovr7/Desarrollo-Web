
DROP PROCEDURE IF EXISTS CURSOR2_WHILE;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CURSOR2_WHILE`()
BEGIN

	DECLARE V_ID INT;
    DECLARE V_NOMBRE VARCHAR(45);
    
    declare v_ultima_fila INT DEFAULT 0;
    
    DECLARE C_ALUMNOS CURSOR FOR
    SELECT ID, NOMBRE
    FROM ALUMNOS
    WHERE ID <= 2; -- Devuelve las 2 primeras filas
    
    -- Declaración de un MANEJADOR DE ERROR
    declare continue handler for not found set v_ultima_fila = 1;
    
    
    OPEN C_ALUMNOS;
    ALUMNOS_CURSOR: WHILE(v_ultima_fila=0) DO
        FETCH C_ALUMNOS INTO V_ID, V_NOMBRE;
        
        if v_ultima_fila = 1 then
            leave alumnos_cursor;
        end if;
        
        SELECT V_ID, V_NOMBRE;
        
    END WHILE ALUMNOS_CURSOR;
    CLOSE C_ALUMNOS;

END