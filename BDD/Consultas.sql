-- SOLUCIONES CONSULTAS 1

-- Función coalesce(expr, expr1, expr2), función que retorna el primer valor NO NULO de la lista de argumentos que recibe.

/*1. Hallar por orden alfabético los nombres de los departamentos cuyo director es un director en funciones.*/
 SELECT NOMDE 
 FROM TDEPTO 
 WHERE TIDIR = 'F' 
 ORDER BY 1;

/*2. Obtener un listado de los empleados del departamento 121 incluyendo nombre de empleado, numero de empleado y
extensión telefónica, por orden alfabético.*/

 SELECT NUMEM, NOMEM,EXTEL 
 FROM TEMPLE 
 WHERE NUMDE = 121 
 ORDER BY 2;

/*3. Obtener por orden creciente una relación de todos los números de extensiones telefónicas de los empleados.*/
 SELECT DISTINCT EXTEL 
 FROM TEMPLE 
 ORDER BY 1 DESC;

/*4. Hallar la comisión, nombre y salario de los empleados con más de tres hijos, ordenados por comisión y por orden alfabético.*/

 SELECT NOMEM, COMIS, SALAR 
 FROM TEMPLE 
 WHERE NUMHI > 3 
 ORDER BY 2,1;

/*5. Obtener salario y nombre de los empleados sin hijos por orden decreciente de salario y
por orden alfabético.*/

 SELECT NOMEM, SALAR 
 FROM TEMPLE 
 WHERE NUMHI = 0 
 ORDER BY 2 DESC ,1;

/*6. Obtener una relación por orden alfabético de los departamentos cuyo presupuesto es inferior a 300000 euros.
El nombre de los departamentos vendrá precedido de las palabras ‘departamento de’*/

 SELECT CONCAT('Departamento de: ',NOMDE) as Departamento
 FROM TDEPTO 
 WHERE PRESU < 300000;


/*7. Llamemos presupuesto medio mensual de un departamento al resultado de dividir su presupuesto anual por 12. 
Supongamos que se decide aumentar los presupuestos medios mensuales de todos los departamentos en un 10% a partir del mes de octubre inclusive. 
Para los departamentos cuyo presupuesto mensual medio es superior a 3000€. 
Mostrar por orden alfabético el nombre de departamento y su presupuesto anual total después del intercambio. 
Funciones útiles: FORMAT y CONCAT.*/

SELECT NUMDE,NOMDE , concat(FORMAT(PRESU + 3 * (PRESU/12) * 0.1,0),'€') AS PRESUTOTAL
FROM TDEPTO
WHERE PRESU/12 > 3000
ORDER BY NOMDE;


/*8. Suponiendo que en los próximos tres años el coste de la vida va a aumentar un 6% anual y que se suben
los salarios en la misma proporción.
Mostrar para los empleados con más de 4 hijos su nombre y su sueldo anual,
 actual (sin incremento) y su sueldo para cada uno de los próximos tres años, clasificados por orden alfabético.*/

SELECT NOMEM,
  SALAR 'ACTUAL',
  SALAR * 1.06 AS 'AÑO-1',
  SALAR * 1.06*1.06 AS 'AÑO-2',
  SALAR * 1.06*1.06*1.06 AS 'AÑO-3'
FROM TEMPLE
WHERE NUMHI > 4
ORDER BY NOMEM;


SELECT NOMEM,
  SALAR 'ACTUAL',
  FORMAT(SALAR * 1.06,2) AS 'AÑO-1',
  FORMAT(SALAR * POWER(1.06,2),2) AS 'AÑO-2',
  FORMAT(SALAR * POWER(1.06,3),2) AS 'AÑO-3'
FROM TEMPLE
WHERE NUMHI > 4
ORDER BY NOMEM;


/*9. Mostrar por orden alfabético los nombres de los empleados tales que si se les da una gratificación
de 60 euros por hijo, el total de la gratificación no supera a la decima parte del salario.*/

SELECT NOMEM FROM TEMPLE
WHERE NUMHI*60 < SALAR*.1
ORDER BY 1;

/*10. Para los empleados del departamento 112, mostrar el nombre y salario total de cada uno
(salario mas comisión), por orden de salario total decreciente y por orden alfabético dentro de salario total.*/


-- SOLUCION 1

SELECT NOMEM ,coalesce(SALAR+COMIS,SALAR) AS 'TOTAL',  SALAR, COMIS
FROM TEMPLE
WHERE NUMDE=112
ORDER BY TOTAL DESC, 1; 


-- SOLUCION 2
SELECT NOMEM, SALAR+COMIS AS 'TOTAL'
FROM TEMPLE
WHERE NUMDE=112 AND COMIS IS NOT NULL

UNION

SELECT NOMEM, SALAR AS 'TOTAL'
FROM TEMPLE
WHERE NUMDE=112 AND COMIS IS NULL
ORDER BY TOTAL DESC, 1;



/*11. Mostrar por orden de numero de empleado el nombre y salario total (salario mas comisión) de los empleados
cuyo salario no supera los 1800 euros mensuales.*/

-- SOLUCION 1

SELECT NUMEM, NOMEM ,coalesce(SALAR+COMIS,SALAR) AS 'TOTAL' , SALAR, COMIS
FROM TEMPLE
WHERE SALAR <=1800
ORDER BY NUMEM; 


-- SOLUCION 2
SELECT NUMEM, NOMEM, SALAR+COMIS TOTAL
FROM TEMPLE
WHERE SALAR <=1800 AND COMIS IS NOT NULL

UNION

SELECT NUMEM, NOMEM, SALAR TOTAL
FROM TEMPLE
WHERE SALAR <=1800 AND COMIS IS NULL
ORDER BY NUMEM;


-- 12. Obtener los números de los departamentos en los que haya algún empleado cuya comisión supere al 20% de su salario.

 SELECT DISTINCT NUMDE 
 FROM TEMPLE 
 WHERE COMIS > .2 * SALAR 
 ORDER BY 1;

-- 13. Mostrar por orden de numero de empleado el nombre y salario total (salario mas comisión)
-- de los empleados cuyo salario total supera el salario mínimo en 650 euros.

-- SOLUCION 1
SELECT DISTINCT NUMDE, NOMEM, coalesce(SALAR+COMIS,SALAR) AS 'TOTAL', SALAR, COMIS
FROM TEMPLE 
WHERE coalesce(SALAR+COMIS,SALAR) > (SELECT MIN(SALAR)+650 FROM TEMPLE) 
ORDER BY NUMDE;
 

-- SOLUCION 2

SELECT DISTINCT NUMDE, NOMEM, SALAR+COMIS FROM TEMPLE WHERE COMIS IS NOT NULL AND SALAR + COMIS > (SELECT MIN(SALAR)+650 FROM TEMPLE)
 UNION
SELECT DISTINCT NUMDE, NOMEM, SALAR       FROM TEMPLE WHERE COMIS IS NULL     AND SALAR  > (SELECT MIN(SALAR)+650 FROM TEMPLE)
ORDER BY NUMDE;


-- 14. Para los empleados que no tiene comisión obtener por orden alfabético el nombre y el cociente entre su salario y el número de hijos.

-- SOLUCION 1

SELECT NOMEM, FORMAT(coalesce(SALAR/NUMHI,SALAR),2) AS SalarporHijo
FROM TEMPLE
WHERE COMIS IS NULL
ORDER BY NOMEM;

-- SOLUCION 2

SELECT NOMEM, FORMAT(SALAR/NUMHI,2) AS SalarporHijo
FROM TEMPLE
WHERE COMIS IS NULL AND NUMHI > 0

UNION

SELECT NOMEM, FORMAT(SALAR,2)
FROM TEMPLE
WHERE COMIS IS NULL AND NUMHI = 0

ORDER BY NOMEM;


/*15. Se desea hacer un regalo de un 1% del salario a los empleados en el día de su onomástica.
Mostrar por orden alfabético el nombre y la cuantía de los regalos en euros para los que celebren su santo el día de San Honorio.*/

-- SOLUCION 1
 SELECT NOMEM, SALAR * .1 as regalo
 FROM TEMPLE
 WHERE NOMEM LIKE 'HONORI_' 
 ORDER BY NOMEM;
 
 -- SOLUCION 2
 SELECT NOMEM, SALAR * .1 as regalo
 FROM TEMPLE
 WHERE NOMEM LIKE 'HONORIA'OR  NOMEM LIKE 'HONORIO'
 ORDER BY NOMEM;


-- 16. Obtener por orden alfabético los nombres y salarios de los empleados del departamento 111 que tienen comisión 
-- y su comisión supera el 40% de su salario.

-- SOLUCION 1
SELECT NOMEM, SALAR
FROM TEMPLE
WHERE NUMDE = 111 AND
COMIS IS NOT NULL AND
EXISTS (SELECT *
        FROM TEMPLE
        WHERE NUMDE = 111 AND
        COMIS IS NOT NULL AND
        COMIS > .15 * SALAR);

-- SOLUCION 2
SELECT NOMEM, SALAR,COMIS
        FROM TEMPLE
        WHERE NUMDE = 111 AND
        COMIS IS NOT NULL AND
        COMIS > .4 * SALAR;


-- 17. En la fiesta de Reyes Magos se desea organizar un espectáculo para los hijos de los empleados, que se representara en dos días diferentes.
-- El primer día asistirán los empleados cuyo apellido empiece por las letras desde A hasta L, ambas inclusive.
-- El 2º día se cursaran invitaciones para el resto. A cada empleado se le asignaran tantas invitaciones gratuitas como hijos tenga y dos más.
-- Además, en la fiesta se entregara a cada empleado un obsequio por hijo. Obtener una lista por orden alfabético de los nombres a quienes hay que invitar
-- el primer día de la representación, incluyendo también cuantas invitaciones corresponden a cada nombre y cuantos regalos hay que preparar para él.

SELECT NOMEM, NUMHI + 2 AS INVITACIONES, NUMHI AS NUMREGALOS
FROM TEMPLE
WHERE NOMEM BETWEEN 'A' AND 'M'
ORDER BY NOMEM;


-- 18. Mostrar por orden alfabético los nombres de los departamentos que cumplan alguna de estas condiciones:
-- Tienen director en funciones.
-- Tienen director o en propiedad y su presupuesto anual excede de 300000
-- No dependen de ningún departamento.

SELECT NOMDE
FROM TDEPTO
WHERE (TIDIR = 'F') OR
      (TIDIR = 'P' AND PRESU > 300000) OR
      (DEPDE IS NULL)
ORDER BY NOMDE;