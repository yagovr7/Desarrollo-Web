CREATE DEFINER=`root`@`localhost` PROCEDURE `procedimiento1`()
BEGIN
	DECLARE i TINYINT UNSIGNED DEFAULT 1;
    DROP TABLE IF EXISTS alumnos;
	CREATE TABLE ALUMNOS(
    ID INT PRIMARY KEY,
    nombre VARCHAR(30));
    
    WHILE (i <= 5) DO
		INSERT INTO alumnos VALUES (i, CONCAT("alumno ", i));
        SET i = i + 1;
	END WHILE;
								
END