/*1.	Obtener el nombre y salario de los empleados cuyo salario se aproxima a 1864€.*/
SELECT NOMEM,SALAR FROM TEMPLE WHERE CEIL(SALAR) = 1864 OR FLOOR(SALAR)=1864;


/*2.	Obtener cuantos grados son 2,4 radianes con una precisión de 3 decimales*/
SELECT ROUND(DEGREES(2.4),3) AS GRADOS;

/*3.	Obtener cuantos radianes son 38º con una precisión de 3 decimales*/
SELECT ROUND(RADIANS(38),3) AS RADIANES;

/*4.	Obtener por orden alfabético para los empleados del departamento 110: nombre, salario mensual y
el salario diario que percibirían para los meses de Enero y Febrero del año actual.*/

SELECT NOMEM,SALAR,ROUND(SALAR/ DAY(LAST_DAY(CONCAT(YEAR(CURDATE()),'0101'))),2) AS ENERO , -- ROUND(SALAR/31,2) AS ENERO,
                   ROUND(SALAR/ DAY(LAST_DAY(CONCAT(YEAR(CURDATE()),'0201'))),2) AS FEBRERO
  FROM TEMPLE
  WHERE NUMDE = 110;

-- Ó
SELECT NOMEM,SALAR,ROUND(SALAR/ DAY(LAST_DAY(CONCAT(YEAR(CURDATE()),'0101'))),2) AS ENERO ,
                   ROUND(SALAR/ DAY(LAST_DAY(MAKEDATE(YEAR(CURRENT_DATE),32))),2) AS FEBRERO
FROM TEMPLE
WHERE NUMDE = 110;

/*5.	Obtener aleatoriamente 3 departamentos de la tabla departamentos.*/
SELECT * 
FROM TDEPTO 
ORDER BY RAND() 
LIMIT 3;

/*6.	Obtener el nombre y número de hijos de los empleados cuyo número de hijos
es mayor o igual al doble de número de hijos más bajo de los empleados que tienen más de 1 hijo.
Utilizar la función POWER.*/
SELECT NOMEM,NUMHI 
FROM TEMPLE 
WHERE NUMHI >= (SELECT MIN(POWER(NUMHI,2)) FROM TEMPLE WHERE NUMHI>1) ;

/*7.	Como se ha comentando anteriormente es política de la empresa festejar cada fin de semana los cumpleaños
de todos los empleados.  La secretaria nos ha pedido un informe por departamento de todos los cumpleaños que quedan
por celebrar, a partir del mes siguiente al actual, para presupuestar su coste.
Obtener número, nombre y número de cumpleaños que quedan por celebrar.Utilizar la función SIGN*/
SELECT TEMPLE.NUMDE,NOMDE, COUNT(*) AS 'NUMCUMPLE'
FROM TEMPLE INNER JOIN TDEPTO ON TEMPLE.NUMDE = TDEPTO.NUMDE
WHERE SIGN(MONTH(CURDATE())- MONTH(FECNA)) = -1 
GROUP BY TEMPLE.NUMDE;

-- Ó

SELECT TEMPLE.NUMDE,NOMDE, COUNT(*) AS 'NUMCUMPLE'
FROM TEMPLE INNER JOIN TDEPTO ON TEMPLE.NUMDE = TDEPTO.NUMDE
WHERE SIGN(MONTH(FECNA)- MONTH(CURRENT_DATE)) = 1 
GROUP BY TEMPLE.NUMDE;

-- Ó

SELECT TEMPLE.NUMDE,NOMDE, COUNT(*) AS 'NUMCUMPLE'
FROM TEMPLE INNER JOIN TDEPTO ON TEMPLE.NUMDE = TDEPTO.NUMDE
WHERE MONTH(FECNA) > MONTH(CURRENT_DATE) 
GROUP BY TEMPLE.NUMDE;


/*8.	Para celebrar los cumpleaños se destina una partida del 0,003 del presupuesto del departamento.
Mostrar en que departamentos ese presupuesto no es suficiente para cubrir los gastos.
Cada cumpleaños cuesta 300 euros.
Mostrar número, nombre y presupuesto del departamento.*/

SELECT T.NUMDE,TD.NOMDE,TD.PRESU, TRUNCATE(COUNT(*) * 300,0) AS PRESUCUMPLE, TRUNCATE(.003*TD.PRESU,0) AS PRESUDPTO  , 
COUNT(*) AS NUMCUMPLEAÑEROS
FROM TEMPLE T INNER JOIN TDEPTO TD ON T.NUMDE = TD.NUMDE
GROUP BY T.NUMDE
HAVING (COUNT(*)*300) > 0.003 * TD.PRESU;


/*9. Calcular el valor de X, aplicando la definición de logaritmo.

 X= log4 64*/
SELECT LOG(4,64) AS X;

/*X = log3 1/27*/
SELECT ROUND(LOG(3, 1/27)) AS X;


/* X = log2 2√2*/
SELECT LOG2(2 * SQRT(2)) AS X;

/*Logx 125 = -3*/

SELECT ROUND(POWER(125,1/-3),1) AS X;

/*Log2 (4x) = 3*/
SELECT POWER(2,3)/4 AS X;

/*10. Resolver la siguiente ecuación de 2º grado: 2x2 + 4x -6 = 0.*/
SELECT (-4 + SQRT(POW(4,2)- (4*2*-6))) / (2*2) AS X1;

SELECT (-4 - SQRT(POW(4,2)- (4*2*-6))) / (2*2) AS X2;