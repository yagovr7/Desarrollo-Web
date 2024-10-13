-- 1. Para los departamentos en los que hay algún empleado cuyo salario sea mayor de 2.400€ al mes, 
-- hallar el número de empleados y la suma de sus salarios, comisiones y número de hijos.

SELECT NUMDE, COUNT(NUMEM) NUMEMPLE, SUM(SALAR) SUMSALAR, SUM(COMIS) SUMCOMIS, SUM(NUMHI) AS SUMNUMHIJOS
FROM TEMPLE
WHERE NUMDE IN (SELECT DISTINCT NUMDE FROM TEMPLE WHERE SALAR > 2400)
GROUP BY NUMDE
ORDER BY NUMDE;

-- Recordar que la función SUM descarta los valores NULL.


-- 2. Para los departamentos en los que la antigüedad media de sus empleados supere a la antigüedad media de la empresa, 
-- hallar el salario mínimo, el salario medio y el salario máximo.

SELECT NUMDE, MIN(SALAR) AS MINIMO, FORMAT(AVG(SALAR),2) AS MEDIA, MAX(SALAR) MAXIMO
FROM TEMPLE
GROUP BY NUMDE
HAVING AVG(DATEDIFF(CURRENT_DATE,FECIN)) >
  (SELECT AVG(DATEDIFF(CURRENT_DATE,FECIN)) FROM TEMPLE)
ORDER BY NUMDE;

-- Ó

SELECT NUMDE, MIN(SALAR) AS MINIMO, FORMAT(AVG(SALAR),2) AS MEDIA, MAX(SALAR) MAXIMO
FROM TEMPLE
GROUP BY NUMDE
HAVING AVG(TIMESTAMPDIFF(YEAR,FECIN,CURDATE())) > (SELECT AVG(TIMESTAMPDIFF(YEAR, FECIN,CURDATE())) FROM TEMPLE)
ORDER BY NUMDE;

-- 3. Para los departamentos en los que haya algún empleado que cumpla a lo largo del año 50 años de antigüedad y 
-- tales que la media de hijos por cada uno de estos empleados sea superior a 1,
-- hallar el salario medio de estos empleados.

SELECT NUMDE, FORMAT(AVG(SALAR),2) AS MEDIASALAR
FROM TEMPLE
WHERE YEAR(CURRENT_DATE) - YEAR(FECIN) >= 50
GROUP BY NUMDE
HAVING AVG(NUMHI) > 1
ORDER BY NUMDE;

-- En este caso tenemos en cuenta los empleados que tengan a dia de hoy 50 años de antigüedad

SELECT NUMDE, FORMAT(AVG(SALAR),2) AS MEDIASALAR
FROM TEMPLE
WHERE TIMESTAMPDIFF(YEAR, FECIN,CURDATE()) >= 50
-- YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE,FECIN))) >= 50
      
GROUP BY NUMDE
HAVING AVG(NUMHI) > 1
ORDER BY NUMDE;



-- 4. Agrupando por número de hijos, hallar la media entre el salario total  y el total de hijos 
-- y la media entre la comisión total y el total hijo.
SELECT NUMHI, SUM(SALAR) / SUM(NUMHI) AS 'SALAR/HIJOS', SUM(COMIS)/SUM(NUMHI) 'COMIS/HIJOS'
FROM TEMPLE
WHERE NUMHI > 0  and COMIS IS NOT NULL
GROUP BY NUMHI

union

SELECT NUMHI,  SUM(SALAR)/SUM(NUMHI) AS 'SALAR/HIJOS', SUM(COMIS)/SUM(NUMHI) 'COMIS/HIJOS'
FROM TEMPLE
WHERE NUMHI > 0 AND COMIS IS NULL
GROUP BY NUMHI

ORDER BY NUMHI;

-- 5. Para los departamentos en los que algún empleado tiene comisión, hallar cuantos empleados hay de media por cada extensión telefónica.
-- con WHERE
SELECT NUMDE, COUNT(*)/COUNT(DISTINCT EXTEL) AS 'EMPLEADOS/EXTEL'
FROM TEMPLE

WHERE NUMDE IN (SELECT DISTINCT NUMDE
                 FROM TEMPLE
                 WHERE COMIS IS NOT NULL) AND (TRUNCATE (COUNT(*)/COUNT(DISTINCT EXTEL),2) > 1.0)
GROUP BY NUMDE
ORDER BY NUMDE;

-- con HAVING
SELECT NUMDE, TRUNCATE(COUNT(*)/COUNT(DISTINCT EXTEL),2) AS 'EMPLEADOS'
FROM TEMPLE
GROUP BY NUMDE
HAVING NUMDE IN (SELECT DISTINCT NUMDE
                 FROM TEMPLE
                 WHERE COMIS IS NOT NULL)  AND (TRUNCATE (COUNT(*)/COUNT(DISTINCT EXTEL),2) > 1.0)
ORDER BY NUMDE;

-- Incorrecta, pq no tiene en cuenta para calcular la media los empleados con comisión nula.
SELECT NUMDE, COUNT(*)/ COUNT(DISTINCT EXTEL) AS 'EMPLEADOS_EXTEL'
FROM TEMPLE
WHERE COMIS IS NOT NULL
GROUP BY NUMDE
ORDER BY NUMDE;



-- 6. Para los departamentos cuyo salario medio supera al salario medio de la empresa, hallar cuantas extensiones telefónicas tienen.

SELECT NUMDE, COUNT(DISTINCT EXTEL) AS NUMEXTEL
FROM TEMPLE
GROUP BY NUMDE
HAVING AVG(SALAR) > (SELECT AVG(SALAR) FROM TEMPLE);


-- 7. Hallar el máximo valor de la suma de los salarios por departamentos.

SELECT E.NUMDE,  D.NOMDE, SUM(E.SALAR) SUMSALAR
FROM TEMPLE E,TDEPTO D
WHERE E.NUMDE = D.NUMDE
GROUP BY NUMDE
HAVING SUM(SALAR) >= ALL (SELECT SUM(SALAR)
                          FROM TEMPLE
                          GROUP BY NUMDE);

-- Con tablas derivadas

SELECT D.NOMDE, E.NUMDE,SUM(E.SALAR) AS S
FROM TEMPLE E,TDEPTO D
WHERE E.NUMDE = D.NUMDE
GROUP BY NUMDE
HAVING SUM(SALAR) =(
					SELECT MAX(T.S) AS MAXSALAR
					FROM (SELECT SUM(SALAR) AS S
						  FROM TEMPLE
						  GROUP BY NUMDE) AS T);


-- 8. Para los departamentos cuyo director lo sea en funciones, hallar el número de empleados y la suma de sus salarios, 
-- comisiones y número de hijos.

-- SUBORDINADA
SELECT NUMDE, COUNT(*) TMPLEADOS, SUM(SALAR) TSALARIO, SUM(COMIS) TCOMIS, SUM(NUMHI) THIJOS
FROM TEMPLE
WHERE NUMDE IN (SELECT NUMDE
                FROM TDEPTO
                WHERE TIDIR = 'F')  AND COMIS IS NOT NULL
GROUP BY NUMDE

UNION

SELECT NUMDE, COUNT(*) TMPLEADOS, SUM(SALAR) TSALARIO, SUM(COMIS) TCOMIS, SUM(NUMHI) THIJOS
FROM TEMPLE
WHERE NUMDE IN (SELECT NUMDE
                FROM TDEPTO
                WHERE TIDIR = 'F') AND COMIS IS NULL
GROUP BY NUMDE
ORDER BY NUMDE;


-- JOIN
SELECT TE.NUMDE, COUNT(*) TMPLEADOS, SUM(TE.SALAR) TSALARIO, SUM(TE.COMIS) TCOMIS, SUM(TE.NUMHI) THIJOS
FROM TEMPLE TE, TDEPTO TD
WHERE TE.NUMDE = TD.NUMDE
AND TD.TIDIR = 'F' AND COMIS IS NOT NULL
GROUP BY TD.NUMDE

UNION

SELECT TE.NUMDE, COUNT(*) TMPLEADOS, SUM(TE.SALAR) TSALARIO, SUM(TE.COMIS) TCOMIS, SUM(TE.NUMHI) THIJOS
FROM TEMPLE TE, TDEPTO TD
WHERE TE.NUMDE = TD.NUMDE
AND TD.TIDIR = 'F' AND COMIS IS NULL
GROUP BY TD.NUMDE

ORDER BY TE.NUMDE;

-- 9. Hallar el salario medio de los empleados para aquellos departamentos en la calle Alcalá en los que haya algún empleado, a día de hoy, que tenga 10 ó más años de antigüedad 
-- y la media de hijos por departamento sea superior a 1.

SELECT E.NUMDE, AVG(SALAR) MEDIASALAR
FROM TEMPLE E, TDEPTO D, TCENTR C
WHERE E.NUMDE = D.NUMDE AND
      D.NUMCE = C.NUMCE AND
      C.SENAS LIKE '%Alcala%'  AND
       -- TIMESTAMPDIFF(YEAR, FECIN, CURDATE())
	  YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE,FECIN))) >=10
GROUP BY E.NUMDE
HAVING AVG(NUMHI) > 1
ORDER BY E.NUMDE;

-- 10. Para los departamentos cuyo presupuesto anual supera los 300.000€, hallar cuántos empleados hay de media 
-- por cada extensión telefónica.

-- Subconsulta
SELECT NUMDE, COUNT(NUMEM)/COUNT(DISTINCT EXTEL) 'EMPLE/EXTEL'
FROM TEMPLE
GROUP BY NUMDE
HAVING NUMDE IN (SELECT DISTINCT NUMDE FROM TDEPTO WHERE PRESU > 300000);

-- JOIN
SELECT E.NUMDE, COUNT(*)/COUNT(DISTINCT EXTEL) 'EMPLE/EXTEL'
FROM TEMPLE E, TDEPTO D
WHERE E.NUMDE = D.NUMDE AND
      PRESU > 300000
GROUP BY E.NUMDE
ORDER BY E.NUMDE;


-- 11. Para los departamentos que no sean de dirección ni de sectores, listar número de departamento y sus extensiones telefónicas,
-- por orden creciente de departamento y dentro de este por número de extensión creciente.

-- JOIN
SELECT E.NUMDE,D.NOMDE, E.EXTEL
FROM TEMPLE E, TDEPTO D
WHERE E.NUMDE = D.NUMDE AND
      NOMDE NOT LIKE '%DIRECC%' AND
      NOMDE NOT LIKE '%SECTOR%'
ORDER BY E.NUMDE, EXTEL;

-- Subconsulta
SELECT E.NUMDE, D.NOMDE, E.EXTEL
FROM TEMPLE E, TDEPTO D
WHERE E.NUMDE IN (select numde from tdepto where nomde NOT LIKE '%DIRECC%' AND
												nomde NOT LIKE '%SECTOR%') AND
	  E.NUMDE = D.NUMDE
ORDER BY E.NUMDE, EXTEL;


-- 12. Insertar un nuevo departamento con los siguientes datos:
 INSERT INTO TDEPTO VALUES (150,20,NULL,'P',166000.00,NULL,'RRHH');

-- 13.	Mostrar para cada departamento el nombre del departamento y el nombre de su director incluidos los que no tienen director.

SELECT D.NUMDE, E.NOMEM
FROM TEMPLE E RIGHT JOIN TDEPTO D
ON E.NUMEM = D.DIREC
ORDER BY 1;

-- 14. Insertar un nuevo empleado con los siguientes datos:

INSERT INTO TEMPLE VALUES (600,NULL,780,'1990.12.21', CURRENT_DATE, 1200,NULL,1,'SARA');

 -- 15.	Mostrar para TODOS los empleados, su nombre y el nombre del departamento al que pertenece. 
 -- No se mostrarán los departamentos que no tengan asignados empleados, sí los hay.
SELECT E.NOMEM, D.NOMDE
FROM TEMPLE E LEFT JOIN TDEPTO D
ON E.NUMDE = D.NUMDE
ORDER BY 1;

 -- 16. Mostrar para TODOS los empleados, su nombre y el nombre del departamento al que pertenece.
 -- Se mostrarán TODOS los departamentos aunque no tengan asignados empleados.

SELECT D.NOMDE, E.NOMEM
FROM TEMPLE E LEFT JOIN TDEPTO D
ON E.NUMDE = D.NUMDE
UNION
SELECT D.NOMDE, E.NOMEM
FROM TEMPLE E RIGHT JOIN TDEPTO D
ON E.NUMDE = D.NUMDE
ORDER BY 1;


-- 17. Obtener, por orden alfabético, todos los datos de los centros de trabajo en los que hay algún departamento cuyo director lo sea en funciones.
SELECT C.*
FROM TCENTR C, TDEPTO D
WHERE C.NUMCE = D.NUMCE AND
	  TIDIR = 'F'
ORDER BY C.NOMCE;

/*18. Para cada empleado que es director, hallar por orden alfabético su nombre y la suma de los salarios de los empleados que están 
directamente a su cargo es decir, los departamentos que dirige.*/

SELECT D.NUMDE, E2.NOMEM AS director, TIDIR, SUM(E1.SALAR) AS TSALAR
FROM TEMPLE E1, TDEPTO D, TEMPLE E2
WHERE E1.NUMDE = D.NUMDE AND
      D.DIREC = E2.NUMEM
GROUP BY DIREC  , TIDIR -- agrupando por 2 campos
ORDER BY 3,2;

-- con UNION
SELECT D.NUMDE, E2.NOMEM, TIDIR, SUM(E1.SALAR) AS TSALAR
FROM TEMPLE E1, TDEPTO D, TEMPLE E2
WHERE E1.NUMDE = D.NUMDE AND
      D.DIREC = E2.NUMEM AND
      TIDIR LIKE 'P'
GROUP BY DIREC

UNION

SELECT D.NUMDE, E2.NOMEM, TIDIR, SUM(E1.SALAR) AS TSALAR
FROM TEMPLE E1, TDEPTO D, TEMPLE E2
WHERE E1.NUMDE = D.NUMDE AND
      D.DIREC = E2.NUMEM AND
      TIDIR LIKE 'F'
GROUP BY DIREC
ORDER BY 1,2;



-- 20. Hallar el salario medio y la edad media en años de los empleados que tiene comisión y los que no tienen comisión.

SELECT 'CON COMISION', CURRENT_DATE HOY, AVG(SALAR) MEDIASALAR, AVG(timestampdiff(YEAR,FECNA,current_date())) MEDIAEDAD
FROM TEMPLE
WHERE COMIS IS NOT NULL
UNION
SELECT 'SIN COMISION', CURRENT_DATE HOY, AVG(SALAR) MEDIASALAR, AVG(timestampdiff(YEAR,FECNA,current_date())) MEDIAEDAD
FROM TEMPLE
WHERE COMIS IS NULL;

-- Ó

SELECT 'CON COMISION', CURRENT_DATE HOY, AVG(SALAR) MEDIASALAR, AVG(YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE,FECNA)))) MEDIAEDAD
FROM TEMPLE
WHERE COMIS IS NOT NULL
UNION
SELECT 'SIN COMISION', CURRENT_DATE HOY, AVG(SALAR) MEDIASALAR, AVG(YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE,FECNA)))) MEDIAEDAD
FROM TEMPLE
WHERE COMIS IS NULL;




/*20.  Para los empleados que trabajan en la calle Atocha y su salario supera al salario medio de su departamento,
obtener por orden alfabético su nombre y su salario total (salario mas comisión).*/

SELECT E.NOMEM, COALESCE(SALAR+COMIS,SALAR) SALARTOTAL
FROM TEMPLE E, TDEPTO D, TCENTR C
WHERE E.NUMDE = D.NUMDE AND
      D.NUMCE = C.NUMCE AND
      SENAS LIKE '%Atocha%' AND
      SALAR > (SELECT AVG(SALAR)
                FROM TEMPLE
                WHERE NUMDE = E.NUMDE)
 ORDER BY 1;
 
-- Ó

SELECT E.NOMEM, IF(COMIS IS NOT NULL,SALAR+COMIS,SALAR) SALARTOTAL
FROM TEMPLE E, TDEPTO D, TCENTR C
WHERE E.NUMDE = D.NUMDE AND
      D.NUMCE = C.NUMCE AND
      SENAS LIKE '%Atocha%' AND
      SALAR > (SELECT AVG(SALAR)
                FROM TEMPLE
                WHERE NUMDE = E.NUMDE)
 ORDER BY 1;
 
 -- con UNION
 
SELECT E.NOMEM, SALAR+COMIS AS 'SALARTOTAL'
FROM TEMPLE E, TDEPTO D, TCENTR C
WHERE COMIS IS NOT NULL AND
	  E.NUMDE = D.NUMDE AND
      D.NUMCE = C.NUMCE AND
      SENAS LIKE '%Atocha%' AND
      SALAR > (SELECT AVG(SALAR)
                FROM TEMPLE
                WHERE NUMDE = E.NUMDE)
                
 UNION
 
 SELECT E.NOMEM, SALAR AS 'SALARTOTAL'
 FROM TEMPLE E, TDEPTO D, TCENTR C
 WHERE COMIS IS  NULL AND
	  E.NUMDE = D.NUMDE AND
      D.NUMCE = C.NUMCE AND
      SENAS LIKE '%Atocha%' AND
      SALAR > (SELECT AVG(SALAR)
                FROM TEMPLE
                WHERE NUMDE = E.NUMDE)
 
 ORDER BY 1;
 




