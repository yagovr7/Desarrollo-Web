DROP PROCEDURE IF EXISTS CURSOR2;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cursor2`()
BEGIN
    DECLARE V_ID INT;
    DECLARE V_NOMBRE VARCHAR(45);
    
    declare v_ultima_fila INT DEFAULT 0;
    
    DECLARE C_ALUMNOS CURSOR FOR
    SELECT ID, NOMBRE
    FROM ALUMNOS
    WHERE ID <= 2; -- Devuelve las 2 primeras filas
    
    -- Declaracion de un MANEJADOR DE ERROR 
    -- para controlar el error que se produce cuando se accede a una fila sin datos(última)
    declare continue handler for not found set v_ultima_fila = 1;
    
    
    OPEN C_ALUMNOS;
    ALUMNOS_CURSOR: LOOP
        FETCH C_ALUMNOS INTO V_ID, V_NOMBRE;
        
        if v_ultima_fila = 1 then
            leave alumnos_cursor;
        end if;
        
	SELECT V_ID, V_NOMBRE;
    END LOOP ALUMNOS_CURSOR;
    CLOSE C_ALUMNOS;
END