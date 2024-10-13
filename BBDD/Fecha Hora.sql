/*1.Modificar la fecha de ingreso de Valeriana empleado número 430
poniendo el día de hoy.*/
UPDATE TEMPLE SET FECIN = CURDATE() 
WHERE NUMEM = 430;

/*2. Obtener los nombres y fechas de nacimiento de los empleados del departamento 100,
en el formato aa-mm-dd,del más mayor al más joven.*/
SELECT NOMEM, DATE_FORMAT(FECNA, '%y-%m-%d') as FECNA 
FROM TEMPLE 
WHERE NUMDE = 100
order by 2 desc;

/*3. Para los empleados que ingresaron durante el año 1988, después del mes de mayo,
obtener su nombre y cuántos días llevaban trabajando en la empresa a primeros de año,
por orden alfabético.*/
SELECT NOMEM,DATEDIFF(CONCAT(YEAR(CURDATE()),'01','01'),FECIN) AS DIASTRABAJANDO 
FROM TEMPLE
WHERE FECIN BETWEEN '1988-06-01' AND '1988-12-31' 
ORDER BY 1 ;

/*4. Obtener por orden alfabético los nombres de los empleados que ingresaron en los primeros noventa días del año 
1988.*/
SELECT NOMEM 
FROM TEMPLE 
WHERE FECIN BETWEEN'1988-01-01'AND ADDDATE('1988-01-01', INTERVAL 90 DAY) 
ORDER BY 1;

/*5. Obtener, por orden alfabético, los nombres y fechas de nacimiento de los empleados que cumplen años 
en el mes de noviembre.*/
SELECT NOMEM, FECNA 
FROM TEMPLE 
WHERE MONTH(FECNA) = 11 
ORDER BY 1;

-- ó

SELECT NOMEM, FECNA 
FROM TEMPLE 
WHERE MONTHNAME(FECNA) = 'NOVEMBER' 
ORDER BY 1;


/*6. Obtener, por orden alfabético, los nombres y fechas de nacimiento de los empleados
que cumplen años en el día de hoy. Suponed que la sentencia se ha ejecutado el 21.10.1989. (Modificar el reloj).*/
SELECT NOMEM,FECNA 
FROM TEMPLE 
WHERE MONTH(FECNA) = MONTH(CURDATE()) AND 
	  DAY(FECNA) = DAY(CURDATE())
ORDER BY 1;

/*7. Obtener, por orden alfabético, los nombres de los empleados que cumplen
24 años de trabajo en la empresa en el año actual. Suponed que la sentencia
se ha ejecutado cualquier día del año 1988. (Modificar el reloj).*/
SELECT NOMEM
FROM TEMPLE 
WHERE YEAR(DATE_ADD(FECIN,INTERVAL 24 YEAR)) = YEAR(CURDATE())
ORDER BY 1;

-- Las dos siguientes consultas NO funcionan si el mes y día de ingreso son posteriores al mes y día actual

SELECT NOMEM 
FROM TEMPLE 
WHERE YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE, FECIN))) = 24
ORDER BY 1;

--

SELECT NOMEM -- , TIMESTAMPDIFF(YEAR, FECIN,CURRENT_DATE)
FROM TEMPLE 
WHERE TIMESTAMPDIFF(YEAR, FECIN,CURRENT_DATE) = 24
ORDER BY 1;

/*8. Obtener, por orden alfabético, los empleados que en el día de hoy tienen
24 años cumplidos en la empresa.Suponed que la sentencia se ha ejecutado el 30 de Junio 1988. (Modificar el reloj).*/
SELECT NOMEM
FROM TEMPLE 
WHERE YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE, FECIN))) = 24;

-- Ó

SELECT NOMEM
FROM TEMPLE 
WHERE TIMESTAMPDIFF(YEAR, FECIN,CURRENT_DATE) = 24;



/*9. Obtener los nombres y sueldos de los empleados que hayan empezado a trabajar
en la empresa el año 1988 o después, por orden alfabético.*/
SELECT NOMEM, SALAR 
FROM TEMPLE 
WHERE FECIN > '1987.12.31' 
ORDER BY 1;


/*10. Obtener por orden alfabético los nombres de los empleados que empezaron a trabajar en la empresa en el año 1988.*/
SELECT NOMEM 
FROM  TEMPLE 
WHERE FECIN 
BETWEEN '1988.01.01'AND'1988.12.31' 
ORDER BY 1;

-- ó
SELECT NOMEM 
FROM  TEMPLE 
WHERE YEAR(FECIN) = '1988' 
ORDER BY 1;


/*11. Obtener por orden alfabético los nombres de los empleados que han ingresado el 1.1.1988 o en el día de hoy.*/

SELECT NOMEM 
FROM TEMPLE 
WHERE FECIN ='1988.01.01'OR FECIN = CURDATE() 
ORDER BY 1;

-- Mostrará a Valeriana (Consulta 1)

/*12. Obtener por orden alfabético los nombres de los empleados que ingresaron en la empresa en la 
semana 6 del año 1988.*/
SELECT NOMEM ,fecin
FROM TEMPLE 
WHERE YEAR(FECIN)='1988' AND 
	  WEEK(FECIN,1) = 6 ORDER BY 1;
      
      
SELECT NOMEM 
FROM TEMPLE 
WHERE YEAR(FECIN)='1988' AND 
	  WEEK(FECIN,3) = 6 ORDER BY 1;
      
SELECT NOMEM 
FROM TEMPLE 
WHERE YEAR(FECIN)='1988' AND 
	  WEEK(FECIN,5) = 6 ORDER BY 1;
      
      
SELECT NOMEM 
FROM TEMPLE 
WHERE YEAR(FECIN)='1988' AND 
	  WEEK(FECIN,7) = 6 ORDER BY 1;


/*13. Obtener por orden alfabético los nombres y salarios de los empleados que o bien ingresaron después del
1.1.1988 o bien antes y además tienen un salario inferior al salario más bajo de los que ingresaron con
posterioridad al 1.1.1988 incrementado en un 100%.*/

SELECT NOMEM ,FECIN, SALAR 
FROM TEMPLE
WHERE (FECIN > '1988/12/31') OR 
      (FECIN < '1988/01/01' AND SALAR <  (SELECT MIN(SALAR)* 2 FROM TEMPLE WHERE FECIN > '1988-01-01')) 
ORDER BY 1;


/*14. Supongamos que según el convenio laboral de la empresa, para los empleados con más de un año de servicio
el número de días de vacaciones anuales expresado en días laborables es de 20 incrementados en uno más
por cada tres años de servicio cumplidos en el año anterior. Para los empleados que este año cumplen 45 o
más años de edad y tienen más de un año de servicio, hallar por orden alfabético el nombre y número de días
de vacaciones anuales le corresponde a cada uno.*/


SELECT NOMEM, FECIN, TRUNCATE(TIMESTAMPDIFF(YEAR, FECIN,CURDATE())/3 + 20,0) 
AS VACACIONES 
FROM TEMPLE WHERE
	YEAR(SUBDATE(CURDATE(),INTERVAL YEAR(FECNA) YEAR)) >= 45
	AND YEAR(FROM_DAYS(DATEDIFF(CURDATE(), FECIN))) >= 1  
ORDER BY 1;



/*15. Se desea analizar un plan de jubilación anticipada para los empleados con 60 años cumplidos en el que se
ofrece una paga adicional extra de jubilación equivalente al salario actual de un mes por cada año de servicio
cumplido. Hallar una lista por orden alfabético de los empleados que este año cumplen 60 años o más
indicando para cada uno la cuantía de esta paga extra.*/

SELECT NOMEM, TIMESTAMPDIFF(YEAR, FECIN, CURDATE()) * SALAR AS PAGAEXTRA
FROM TEMPLE
WHERE TIMESTAMPDIFF(YEAR, FECNA, CURDATE()) >= 60
ORDER BY 1;



/*16. Es política de la empresa festejar cada fin de mes, los cumpleaños de todos los empleados que cumplen ese
mes. Mostrar los nombres y fecha de nacimiento en formato (21 de Mayo de 2011) de los empleados que
cumplen años en el mes de mayo.*/
SELECT NOMEM, CONCAT(DAY(FECNA),' de ',MONTHNAME(FECNA), ' de ', YEAR(FECNA)) AS CUMPLE 
FROM TEMPLE 
WHERE MONTH(FECNA) = 5;

-- Ó

SELECT NOMEM, DATE_FORMAT(FECNA,'%e %M %Y')  AS ' CUMPLE'
FROM TEMPLE WHERE MONTH(FECNA) = 5;


/*17. Para los empleados de los departamentos 111 y 112 hallar por orden alfabético: nombre, edad actual y edad
cuando ingresaron en la empresa.*/

SELECT NOMEM, FECNA, FECIN, TIMESTAMPDIFF(YEAR, FECNA, CURDATE()) AS 'EDAD ACTUAL', 
							TIMESTAMPDIFF(YEAR, FECNA, FECIN) AS 'EDAD INGRESO'
FROM TEMPLE 
WHERE NUMDE=111 OR NUMDE=112 
ORDER BY 1;


/*18. Para los empleados de los departamentos 110 y 111 hallar por orden alfabético: nombre y tiempo que lleva
en la empresa expresado en años, meses y dias.*/
SELECT NOMEM,DATE_FORMAT(FROM_DAYS(DATEDIFF(CURDATE(),FECIN)),'%y AÑOS %c MESES %e DIAS') AS ANTIGUEDAD
FROM TEMPLE 
WHERE NUMDE=110 OR NUMDE=111 
ORDER BY 1;


/*19. Para la consulta anterior mostrar todo en una cadena. Por ejemplo:”Luis tiene una antigüedad 12 años 3
meses y 20 días”.*/
SELECT CONCAT(NOMEM ,' tiene una antigüedad de ',DATE_FORMAT(FROM_DAYS(DATEDIFF(CURDATE(),FECIN)),'%y años  %c meses y %e dias')) AS ANTIGUEDAD
FROM TEMPLE 
WHERE NUMDE=110 OR NUMDE=111 
ORDER BY 1;

/*20. Para los empleados de los departamentos 110 y 112 mostrar su nombre, mes y día de cumpleaños, por
orden creciente de éstos.*/
SELECT NOMEM,MONTHNAME(FECNA) 'MES CUMPLE',DAY(FECNA) 'DIA CUMPLE' 
FROM TEMPLE 
WHERE NUMDE=110 OR NUMDE=112 
ORDER BY 1;

/*21. Todos los empleados tienen un periodo de 6 meses después de su ingreso antes de firmar su contrato de
empleo definitivo. Hallar para los empleados que este año cumplen menos de 40 años de edad, por orden
alfabético: nombre y fecha de firma de su contrato definitivo.*/

SELECT NOMEM,FECIN,ADDDATE(FECIN, INTERVAL 6 MONTH) AS CONTRATO -- , FECNA ,  YEAR(CURDATE()) - YEAR(FECNA)
FROM TEMPLE 
WHERE YEAR(CURDATE()) - YEAR(FECNA) < 40 
ORDER BY 1;


/*22. Claudia y Horacio tras un volcánico y fugaz noviazgo, han decidido unirse eternamente en matrimonio. La
boda se celebrará dentro de 2 días y tomarán 20 días de vacaciones para el viaje de novios. La empresa le
entregará a cada uno como regalo de boda un 1% de su salario actual por cada año de servicio. Hallar la
fecha de la boda, la fecha en que se incorporarán al trabajo después del viaje de novios y el regalo de boda
correspondiente a cada uno de ellos.*/

SELECT NOMEM,FECIN,SALAR,ADDDATE(CURDATE(), INTERVAL 2 DAY)  AS  BODA,
			             ADDDATE(CURDATE(), INTERVAL 20 DAY) AS VACACIONES,
                         TIMESTAMPDIFF(YEAR, FECIN, CURDATE()) * (.01 * SALAR) AS 'REGALO BODA',
                         TIMESTAMPDIFF(YEAR, FECIN, CURDATE()) AÑOS_Trabajados 
FROM TEMPLE 
WHERE NOMEM LIKE 'Claudia' OR NOMEM LIKE 'Horacio';



