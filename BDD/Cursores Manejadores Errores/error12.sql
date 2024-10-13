DROP PROCEDURE IF EXISTS ERROR12;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ERROR12`()
BEGIN
   DECLARE EXIT HANDLER FOR 1062
        SELECT 'Clave repetida. Codigo MySQL 1062';
 
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
         SELECT 'Ocurrio un error. Fin del programa'
            AS 'Aviso de error';
    
    BEGIN 
        DECLARE EXIT HANDLER FOR 1062
        SELECT 'Bloque interno. Clave repetida. Codigo MySQL 1062';
 
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
         SELECT 'Bloque interno. Ocurrio un error. Fin del programa'
            AS 'Aviso de error';
        INSERT INTO ALUMNOS VALUES(NULL,'Mario A. Carrera');
    END;
    
END