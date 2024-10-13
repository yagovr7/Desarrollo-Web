-- 1. Hallar por orden alfabético los nombres de los departamentos cuyo director es un director en funciones. 
SELECT nomde
FROM tdepto
WHERE tidir like "F";

-- 2. Obtener un listado de los empleados del departamento 121 incluyendo nombre de empleado, numero de empleado y
-- extensión telefónica, por orden alfabético. 
SELECT  numem, nomem, extel
FROM temple
WHERE numde like "121"
ORDER BY nomem;

-- 3. Obtener por orden creciente una relación de todos los números de extensiones telefónicas de los empleados. 
SELECT DISTINCT extel
FROM temple
ORDER BY extel;

-- 4. Hallar la comisión, nombre y salario de los empleados con más de tres hijos, ordenados por comisión y por orden
-- alfabético. 
SELECT  nomem, comis, salar
FROM temple
WHERE numhi >3
ORDER BY comis, nomem;

-- 5. Obtener salario y nombre de los empleados sin hijos por orden decreciente de salario y por orden alfabético. 
SELECT nomem, salar 
FROM temple
WHERE numhi like "0"
ORDER BY salar DESC, nomem;

-- 6. Obtener una relación por orden alfabético de los departamentos cuyo presupuesto es inferior a 300000 euros. El
-- nombre de los departamentos vendrá precedido de las palabras ‘departamento de’ 
SELECT concat('Departamento de ', nomde) as Departamentos, concat(presu, ' €') as Presupuesto
FROM tdepto
WHERE presu <300000
ORDER BY nomde;

-- 7. Llamemos presupuesto medio mensual de un departamento al resultado de dividir su presupuesto anual por 12.
-- Supongamos que se decide aumentar los presupuestos medios mensuales de todos los departamentos en un 10% a
-- partir del mes de octubre inclusive. Para los departamentos cuyo presupuesto mensual medio es superior a 3000€.
-- Mostrar por orden alfabético el nombre de departamento y su presupuesto anual total después del incremento.
-- Funciones útiles: FORMAT y CONCAT. 
SELECT numde, nomde, concat(FORMAT(presu/12)+((presu/12)*0.10)) as presupuestomediomensual
FROM tdepto
WHERE presu/12 >30000;

-- 8. Suponiendo que en los próximos tres años el coste de la vida va a aumentar un 6% anual y que se suben los salarios
-- en la misma proporción. Mostrar para los empleados con más de 4 hijos su nombre y su sueldo anual, actual (sin
-- incremento) y su sueldo para cada uno de los próximos tres años, clasificados por orden alfabético. 

SELECT nomem, salar as ACTUAL,
 (salar + salar*.06) as "AÑO-1",
 (salar + salar*.06)+(salar*.06) as "AÑO-2",
 (salar + salar*.06) +(salar*.06) +(salar*.06) as "AÑO-3"
 FROM temple
 WHERE numhi > 4
 ORDER BY nomem;
 
 -- 9. Hallar por orden alfabético los nombres de los empleados tales que si se les da una gratificación de 60 euros por
-- hijo, el total de la gratificación no supera a la decima parte del salario. 

SELECT nomem,numhi, salar as Salario, concat(60*numhi) as Gratificacion
FROM temple
WHERE 60*numhi < salar*.1
ORDER BY nomem;

-- 10. Para los empleados del departamento 112, mostrar el nombre y salario total de cada uno (salario mas comisión), por
-- orden de salario total decreciente y por orden alfabético dentro de salario total.

SELECT nomem, concat(salar+comis) as Total
FROM temple
WHERE numde like '112'
ORDER BY salar+comis DESC, nomem;
select*from temple;

-- 11. Mostrar por orden de numero de empleado el nombre y salario total (salario mas comisión) de los empleados cuyo
-- salario no supera los 1800 euros mensuales. 

SELECT numem, nomem, salar, concat(salar+comis) as Total 
FROM temple
WHERE salar < 1800 and comis is not null
ORDER BY numem;

-- 12. Obtener los números de los departamentos en los que haya algún empleado cuya comisión supere al 20% de su
-- salario

SELECT DISTINCT numde
FROM temple
WHERE comis > salar*.2 ;

-- 13. Mostrar por orden de numero de empleado el nombre y salario total (salario mas comisión) de los empleados cuyo
-- salario total supera el salario mínimo fijado en 650 euros.
 
 SELECT numem, nomem, concat(salar+comis) as Total
 FROM temple
 WHERE salar+comis > 650
 ORDER BY 1;
 
-- 14. Para los empleados que no tiene comisión obtener por orden alfabético el nombre y el cociente entre su salario y el
-- número de hijos. 

SELECT nomem, concat(salar/numhi) as Cociente
FROM temple
ORDER BY nomem;

-- 15. Se desea hacer un regalo de un 1% del salario a los empleados en el día de su onomástica. Mostrar por orden
-- alfabético el nombre y la cuantía de los regalos en euros para los que celebren su santo el día de San Honorio. 

SELECT nomem, concat(salar*.01,' €') as Regalo
FROM temple
WHERE nomem like 'Honori_';

-- 16. Obtener por orden alfabético los nombres y salarios de los empleados del departamento 111 que tienen comisión si
-- hay alguno de ellos cuya comisión supere el 40% de su salario. 

SELECT nomem, salar
FROM temple
WHERE numde like '111' AND comis > salar*.4
ORDER BY nomem;

-- 17. En la fiesta de Carnavales desea organizar un espectáculo para los hijos de los empleados, que se representara en
-- dos días diferentes. El primer día asistirán los empleados cuyo apellido empiece por las letras desde A hasta L,
-- ambas inclusive. El 2º día se cursaran invitaciones para el resto. A cada empleado se le asignaran tantas invitaciones
-- gratuitas como hijos tenga y dos más. Además, en la fiesta se entregara a cada empleado un obsequio por hijo.
-- Obtener una lista por orden alfabético de los nombres a quienes hay que invitar el primer día de la representación,
-- incluyendo también cuantas invitaciones corresponden a cada nombre y cuantos regalos hay que preparar para él. 

-- 18. Mostrar por orden alfabético los nombres de los departamentos que cumplan alguna de estas condiciones:
-- a. Tienen director en funciones.
-- b. Tienen director o en propiedad y su presupuesto anual excede de 300.000€.
-- c. No dependen de ningún departamento. 

SELECT nomde
FROM tdepto
WHERE tidir like 'F' or tidir like 'P' AND presu > 300000
ORDER BY nomde;


