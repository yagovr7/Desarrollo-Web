CREATE DEFINER=`root`@`localhost` PROCEDURE `procedimiento2`()
BEGIN
	declare v_id INT;
    declare v_nombre VARCHAR(30);
    
    SELECT id, nombre
    INTO v_id, v_nombre
    FROM alumnos
    WHERE id = 100;
    SELECT v_id, v_nombre;

END