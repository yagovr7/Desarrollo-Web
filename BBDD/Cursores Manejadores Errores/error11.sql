DROP PROCEDURE IF EXISTS ERROR11;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ERROR11`()
BEGIN
   DECLARE EXIT HANDLER FOR 1062
        SELECT 'Clave repetida. Codigo MySQL 1062';
 
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
         SELECT 'Ocurrio un error. Fin del programa';
    
    BEGIN    
        INSERT INTO ALUMNOS VALUES(NULL,'Mario A. Carrera');
    END;
    
END