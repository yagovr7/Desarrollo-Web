CREATE DEFINER=`root`@`localhost` FUNCTION `fechaLarga`(f date) RETURNS varchar(250) CHARSET utf8
BEGIN

RETURN CONCAT(diaCastellano(dayname(f)), ', ', DAY(F), ' de ', mesCastellano(month(f)), ' de ', YEAR(F));
END