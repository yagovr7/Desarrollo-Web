-- 1. Hallar cuántos departamentos hay y el presupuesto anual medio de ellos.
SELECT COUNT(*) AS NUMDEPTOS, FORMAT(AVG(PRESU),2) AS MEDIADPTOS
FROM TDEPTO;


-- 2. Para los departamentos 111 y 112, hallar la media de los años de servicio de sus empleados a día de hoy.

-- SOLUCION 1
SELECT FLOOR(AVG(YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE,FECIN))))) AS MEDIAANIOSSERVICIO
FROM TEMPLE
WHERE NUMDE = 111 OR NUMDE = 112;

-- SOLUCION 2
SELECT FLOOR(AVG(TIMESTAMPDIFF(YEAR,FECIN,CURDATE()))) AS MEDIAANIOSSERVICIO
FROM TEMPLE
WHERE NUMDE = 111 OR NUMDE = 112;


-- 3. Para los departamentos 111 y 112, hallar la media de los años de servicio de sus empleados el día 31.12.86.

-- SOLUCION 1
SELECT FLOOR(AVG(TIMESTAMPDIFF(YEAR,FECIN,'1986.12.31'))) AS MEDIANIOSSERVICIO
FROM TEMPLE
WHERE (NUMDE = 111 OR NUMDE = 112) AND
      FECIN <= '1986.12.31';

-- SOLUCION 2
SELECT FLOOR(AVG(YEAR(FROM_DAYS(DATEDIFF('1986.12.31',FECIN))))) AS MEDIANIOSSERVICIO
FROM TEMPLE
WHERE (NUMDE = 111 OR NUMDE = 112) AND
      FECIN <= '1986.12.31';
      
      
-- 4. Hallar por orden de número de empleado el nombre y salario total (salario más comisión) de los empleados 
-- cuyo salario total supera al salario mínimo en 1.800 euros.

-- SOLUCION 1
SELECT  NUMEM,NOMEM, coalesce(SALAR + COMIS,SALAR) AS 'SALARIO TOTAL', SALAR, COMIS
FROM TEMPLE
WHERE coalesce(SALAR + COMIS,SALAR) > (SELECT MIN(SALAR)+1800 FROM TEMPLE)
ORDER BY NUMEM;
      
      
-- SOLUCION 2
SELECT  NUMEM,NOMEM , (SALAR + COMIS) AS 'SALARIO TOTAL' , SALAR, COMIS
FROM TEMPLE
WHERE ((SALAR + COMIS) > (SELECT MIN(SALAR)+1800 FROM TEMPLE)) AND 
	  COMIS IS NOT NULL

UNION

SELECT  NUMEM,NOMEM , SALAR  AS 'SALARIO TOTAL' , SALAR, COMIS
FROM TEMPLE
WHERE (SALAR > (SELECT MIN(SALAR)+1800 FROM TEMPLE)) AND 
	  COMIS IS NULL
ORDER BY NUMEM;

-- -- SOLUCION 3
SELECT  T.NUMEM,T.NOMEM , T.TOTAL FROM (SELECT NUMEM,NOMEM, IF (COMIS IS NOT NULL, SALAR + COMIS, SALAR) AS TOTAL FROM TEMPLE) AS T
WHERE T.TOTAL > (SELECT MIN(SALAR)+1800 FROM TEMPLE)
ORDER BY T.NUMEM;

-- 5. Para los empleados que han ingresado en la empresa en los últimos 30 años, 
-- hallar la edad media en años cumplidos de la edad a la que ingresaron.

-- SOLUCION 1

 SELECT  FLOOR(AVG(TIMESTAMPDIFF(YEAR, FECNA, FECIN))) AS MEDIAANIOSSERVICIO 
 -- TIMESTAMPDIFF(YEAR,FECIN,CURDATE()) AS M, FECNA, FECIN, CURDATE()
 FROM TEMPLE
 WHERE  TIMESTAMPDIFF(YEAR,FECIN,CURDATE())>= 30;

 -- SOLUCION 2
 SELECT FLOOR(AVG(YEAR(FROM_DAYS(DATEDIFF(FECIN,FECNA))))) AS MEDIAANIOSSERVICIO
 FROM TEMPLE
 WHERE YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE,FECIN))) >= 30;
 
 
-- 6. Hallar la masa salarial anual (salario más comisión) de la empresa (se suponen 14 pagas anuales).
 
  -- SOLUCION PARCIAL
  
  	SELECT SUM((SALAR+COMIS)*14) AS 'SALARTOTAL'FROM TEMPLE  WHERE COMIS IS NOT NULL 
 
	UNION 
 
	SELECT SUM((SALAR)*14) AS 'SALARTOTAL' FROM TEMPLE  WHERE COMIS IS NULL ;
  
-- SOLUCION 1 - Tablas DERIVADAS   
    SELECT SUM(T.SALARTOTAL)
    FROM
		(SELECT SUM((SALAR+COMIS)*14) AS 'SALARTOTAL'FROM TEMPLE  WHERE COMIS IS NOT NULL 
 
		UNION 
 
		SELECT SUM((SALAR)*14) AS 'SALARTOTAL' FROM TEMPLE  WHERE COMIS IS NULL 
        ) AS T;
    
 
 -- SOLUCION 2 - Con coalesce
  SELECT SUM(coalesce(SALAR+COMIS,SALAR)*14)
  FROM TEMPLE;
  
 -- SOLUCION 3 - Con if
  SELECT SUM(IF(COMIS IS NOT NULL, SALAR + COMIS, SALAR) * 14) AS MASASALARIAL FROM TEMPLE;

-- 7. Hallar cuántos empleados han ingresado en el año 1978.
 SELECT COUNT(*) AS NUMEMPL1978 
 FROM TEMPLE WHERE 
 YEAR (FECIN) = 1978;

-- 8. Hallar el salario medio de los empleados cuyo salario no supera en más de 20% el salario mínimo de los empleados
-- que tienen algún hijo.
SELECT FORMAT(AVG(SALAR),2) AS MEDIASALAR
FROM TEMPLE
WHERE SALAR <= (SELECT (1.2*MIN(SALAR)) FROM TEMPLE WHERE NUMHI > 0);


-- 9. Hallar la diferencia entre el salario total (salario mas comision) más alto y el más bajo.
 
 -- SOLUCION 1
 SELECT MAX(TD.SALARTOTAL) - MIN(TD.SALARTOTAL) AS DIFSALAR
 FROM (SELECT SALAR+COMIS AS 'SALARTOTAL' FROM TEMPLE WHERE COMIS IS NOT NULL
		UNION
	   SELECT SALAR AS 'SALARTOTAL' FROM TEMPLE WHERE COMIS IS NULL) AS TD;

-- SOLUCION 2
 SELECT MAX(IF (COMIS IS NOT NULL, SALAR+COMIS,SALAR)) - MIN(IF (COMIS IS NOT NULL, SALAR+COMIS,SALAR)) AS DIFSALAR
 FROM TEMPLE;
 
 -- SOLUCION 3
 SELECT  MAX(coalesce(SALAR+COMIS,SALAR)) - MIN(coalesce(SALAR+COMIS,SALAR)) AS DIFSALAR
 FROM TEMPLE;
 

-- 10. Hallar la edad media en años cumplidos en el día de hoy de los empleados que tienen más de 2 hijos.

-- SOLUCION 1
 SELECT FLOOR(AVG(TIMESTAMPDIFF(YEAR,FECNA,CURDATE()))) MEDIANIOS
 FROM TEMPLE
 WHERE NUMHI > 2;

-- SOLUCION 2
 SELECT FLOOR(AVG(YEAR(FROM_DAYS(DATEDIFF(CURRENT_DATE,FECNA))))) MEDIANIOS
 FROM TEMPLE
 WHERE NUMHI > 2;
 

-- 11. Hallar el presupuesto medio de los departamentos cuyo presupuesto supera al presupuesto medio de los departamentos.
SELECT ROUND(AVG(PRESU),2) MEDIAPRESU
FROM TDEPTO
WHERE PRESU > (SELECT AVG(PRESU) FROM TDEPTO);


-- 12. Hallar el numero medio de hijos por empleado para todos los empleados  que no tienen más de 2 hijos.
 
 -- SOLUCION 1
 SELECT ROUND(AVG(NUMHI),2) HIJOSPOREMPLE
 FROM TEMPLE
 WHERE NUMHI BETWEEN 1 AND 2;
 
-- SOLUCION 2
 SELECT ROUND(AVG(NUMHI),2)
 FROM TEMPLE
 WHERE NUMHI >0 AND NUMHI < 3;


-- 13. Obtener, por orden alfabético, los nombres y salarios de los empleados que o bien ingresaron después de 1.1.1988 o bien antes y
-- además tienen un salario inferior al salario más bajo de los que ingresaron con posterioridad al 1.1.1988 incrementado en un 100%.

SELECT NOMEM, FECIN,SALAR FROM TEMPLE 
WHERE (FECIN > '1988.01.01') OR (FECIN < '1988.1.1' AND SALAR < (SELECT MIN(SALAR)*2 FROM TEMPLE WHERE FECIN > '1988.01.01'))
order by 2 ;
  
  
  
  
  
  
  