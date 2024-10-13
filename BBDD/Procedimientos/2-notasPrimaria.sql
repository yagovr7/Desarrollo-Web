
/*2.	Utilizando el comando CASE. Crear un procedimiento ‘notasPrimaria’ que reciba dos parámetros: 
a.	Número (nota de un alumno).
b.	Nombre (nombre del alumno).
El procedimiento deberá mostrar un mensaje con el siguiente formato y según el siguiente baremo:
Entre 9 y 10 = Sobresaliente
Entre 7 y 8   = Notable
6 = Bien
5 = Suficiente
4-1 = Insuficiente
NOTA: Tener en cuenta que el usuario puede introducir una nota que no sea un valor entre 1-10, en ese caso el procedimiento deberá mostrar el siguiente mensaje: ‘Nota incorrecta, debe introducir una nota entre 1 y 10’.
Ejemplo, suponemos que introducimos la nota 8,5 para Laura Pérez, el procedimiento mostrará: ‘La nota de Laura Pérez es NOTABLE’.*/

DROP PROCEDURE IF EXISTS `notasPrimaria`;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `notasPrimaria`(nota DECIMAL(3,1), nombre VARCHAR(50))
BEGIN

DECLARE notaLetra VARCHAR(100);

CASE 
	WHEN NOTA BETWEEN 1.0 AND 4.9 THEN
		SET notaLetra = upper('Insuficiente');
	WHEN NOTA BETWEEN 5.0 AND 5.9 THEN
		SET notaLetra = upper('Suficiente');
	WHEN NOTA BETWEEN 6.0 AND 6.9 THEN
		SET notaLetra = upper('Bien');
	WHEN NOTA BETWEEN 7.0 AND 8.9 THEN
		SET notaLetra = upper('Notable');
	WHEN NOTA BETWEEN 9.0 AND 10.0 THEN
		SET notaLetra = upper('Sobresaliente');
	ELSE
		SET notaLetra = 'Nota INCORRECTA, debe introducir una nota entre 1 y 10. Se admiten decimales';
	END CASE;
		
     IF (NOTA < 1 OR NOTA > 10) THEN
		SELECT notaLetra as Nota;
	 ELSE
		SELECT CONCAT (NOMBRE, ' tiene un ',notaLetra) as Nota;    
	 END IF;
       
END