USE KADOO;

DROP FUNCTION IF EXISTS FUNCION6;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `FUNCION6`(P_DPTO INT) RETURNS int(11)
    READS SQL DATA
BEGIN
        RETURN (SELECT COUNT(*) FROM TEMPLE WHERE NUMDE = P_DPTO);
    
    
END