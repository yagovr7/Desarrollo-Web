use kadoo;
drop procedure if exists CURSOR4;

DELIMITER $$
CREATE PROCEDURE `CURSOR4`()
BEGIN
	DECLARE v_numce INT; 
    DECLARE v_nomce VARCHAR (25);
    DECLARE v_nomde VARCHAR (20);
    DECLARE v_ultima_fila INT DEFAULT 0; -- inicializamos a 0 la variable de control para salir de los bucles 
    DECLARE v_total_departamentos INT; -- contador de departamentos.
	
    -- Declaración del cursor de centros
    -- Con este cursor creamos las posiciones 
    -- que tendrá tantas como resultados tenga el select
	DECLARE C_CENTROS CURSOR FOR
		SELECT NUMCE, NOMCE 
        FROM TCENTR
        ORDER BY NUMCE;
        
	-- Declaración del cursor de departamentos
	-- Con este cursor creamos las posiciones 
	-- que tendrá tantas como resultados tenga el select
	DECLARE C_DEPARTAMENTOS CURSOR FOR
		SELECT NOMDE
		FROM TDEPTO
		WHERE NUMCE = v_numce;
        
	-- Declaración del cursor para departamentos. Lo qu hace es poner 
    -- la variable de control a 1 para salir del bucle
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_ultima_fila = 1;
	OPEN C_CENTROS; -- apertura de cursor
		CENTROS_CURSOR: LOOP
			FETCH C_CENTROS INTO v_numce, v_nomce;
            IF v_ultima_fila = 1 THEN
				LEAVE CENTROS_CURSOR;
			END IF;
            SELECT CONCAT('Centro: ', v_numce, '-', v_nomce) AS 'CENTRO';
            SET v_total_departamentos = 0;
            -- Apertura del segundo cursor
				OPEN C_DEPARTAMENTOS;
					DEPARTAMETOS_CURSOR: LOOP
						FETCH C_DEPARTAMENTOS INTO v_nomde;
                        IF v_ultima_fila = 1 THEN
							LEAVE DEPARTAMETOS_CURSOR;
						END IF;
                        SELECT CONCAT('Departamento: ', v_nomde) AS 'Departamento';
                        set v_total_departamentos = v_total_departamentos + 1;
                    END LOOP DEPARTAMETOS_CURSOR;
				CLOSE C_DEPARTAMENTOS;
				SELECT v_total_departamentos AS 'Total departamentos del centro';
                SET v_ultima_fila = 0;
		END LOOP CENTROS_CURSOR;
	CLOSE C_CENTROS;
END