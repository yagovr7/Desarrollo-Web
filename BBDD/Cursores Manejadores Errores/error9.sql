DROP PROCEDURE IF EXISTS ERROR9;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ERROR9`()
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        SELECT 'Ocurrio un error. Fin del programa';
    
    DECLARE EXIT HANDLER FOR 1062
        SELECT 'Clave repetida. Codigo MySQL 1062';
        
    DECLARE EXIT HANDLER FOR SQLSTATE '23000'
        SELECT 'Ocurrio un error. SQLSTATE 23000';
        
    INSERT INTO ALUMNOS VALUES(1,'Mario A. Carrera');
    
        
END