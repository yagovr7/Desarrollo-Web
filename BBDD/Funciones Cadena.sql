
-- 1. Obtener el nombre de los empleados que tengan al menos 7 letras.
SELECT NOMEM 
FROM TEMPLE 
WHERE LENGTH(NOMEM)>=7;

-- 2. Obtener los nombres abreviados para los departamentos tomando sus primeras 9 letras, por orden alfabético.
SELECT NUMDE,SUBSTRING(NOMDE,1,9)AS NOMBRES 
FROM TDEPTO 
ORDER BY 2;

-- 3. Obtener los números de departamento y los 5 caracteres siguientes al de la posición duodécima de su
-- nombre, mostrándolos por orden de número de departamento.
SELECT NUMDE,SUBSTRING(NOMDE,13,5) AS NOMBRES 
FROM TDEPTO 
ORDER BY NUMDE;

-- 4. Obtener los números de departamento y los nombres de departamentos sólo para aquellos cuyo nombre
-- tenga más de 12 caracteres, los nombres se mostrarán a partir del carácter 12 los 5 siguientes, ordenar por
-- número de departamento.
SELECT NUMDE, SUBSTRING(NOMDE,13,5) AS NOMBRES 
FROM TDEPTO 
WHERE LENGTH(NOMDE)>12 
ORDER BY NUMDE;


-- 5. Obtener los 3 últimos caracteres de los nombres de departamento por orden alfabético.
SELECT DISTINCT SUBSTR(NOMDE,LENGTH(NOMDE)-2) AS NOMBRES 
FROM TDEPTO 
ORDER BY 1;

-- 6. Obtener los nombres de los empleados que no tienen comisión, clasificados de manera que aparezcan
-- primero aquellos cuyos nombres son más cortos.
SELECT LENGTH(NOMEM)AS MASCORTOS,NOMEM 
FROM TEMPLE 
WHERE COMIS IS NULL 
ORDER BY 1,2;

-- 7. Obtener por orden alfabético los nombres de los empleados suprimiendo las tres últimas letras de los
-- nombres, para los empleados cuyos nombres tengan más de 6 letras.
SELECT NOMEM,SUBSTRING(NOMEM,1,LENGTH(NOMEM)-3) AS NOMBRES 
FROM TEMPLE 
WHERE LENGTH(NOMEM)>6;

-- 8. Obtener en una sola columna el nombre de los empleados y el departamento al que pertenecen con el
-- siguiente formato: Nombre: CESAR Departamento: SECTOR INDUSTRIAL
SELECT CONCAT('Nombre: ',NOMEM,'----','Departamento: ',NOMDE)AS EMP_DETP 
FROM TEMPLE TE INNER JOIN TDEPTO TD 
WHERE TE.NUMDE=TD.NUMDE;

-- 9. Obtener el nombre en minúsculas de los empleados cuyo departamento al que pertenecen contenga la cadena
-- ‘sector’.
SELECT LOWER(NOMEM)AS nombres 
FROM TEMPLE TE INNER JOIN TDEPTO TD 
ON TE.NUMDE=TD.NUMDE AND
   LOCATE('SECTOR',NOMDE);

-- 10. Obtener el código ASCII de la 2ª letra de los nombres de los empleados. 
SELECT ORD(SUBSTRING(NOMEM,2,1)) AS ENASCII FROM TEMPLE;
