CREATE DEFINER=`root`@`localhost` FUNCTION `bucleLOOP`() RETURNS varchar(50) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
DECLARE i TINYINT UNSIGNED DEFAULT 0;
DECLARE suma INT DEFAULT 0;
	bucleLOOP:LOOP
		
        SET I = I + 2;	
        
		IF I > 20 THEN
			LEAVE bucleLOOP;
		END IF;
        
		IF I = 10 THEN
			ITERATE bucleLOOP;
		END IF;
		
		SET SUMA = SUMA + I;
        
	END LOOP bucleLOOP;
	return CONCAT("SUMA: ", suma);

END