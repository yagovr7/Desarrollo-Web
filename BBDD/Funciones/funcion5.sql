USE KADOO;

DROP FUNCTION IF EXISTS FUNCION5;

DELIMITER $$

CREATE DEFINER=`root`@`localhost` FUNCTION `FUNCION5`(P_DPTO INT) RETURNS int(11)
BEGIN
    DECLARE V_NUM_TOTAL INT;
    SELECT COUNT(*) 
    INTO V_NUM_TOTAL
    FROM TEMPLE
    WHERE NUMDE = P_DPTO;
    
    RETURN V_NUM_TOTAL;
END