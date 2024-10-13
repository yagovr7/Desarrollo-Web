drop FUNCTION if exists siDivisible;

delimiter $$

CREATE DEFINER=`root`@`localhost` FUNCTION `siDivisible`(n1 int, n2 int) RETURNS varchar(100) 
deterministic
BEGIN
IF (N1 MOD N2) = 0 THEN
		return concat(N1, ' es divisible por ', N2);
ELSE
    	return concat(N1, ' NO es divisible por ', N2);
END IF;   
END