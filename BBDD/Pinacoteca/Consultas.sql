-- 1._ Mostrar nombre de los pintores españoles y el nombre de su maestro, solo para aquellos que han tenido maestro.
SELECT Npintor
FROM pintor
WHERE PaisPintor like 'España' AND NPintorMaestro IS NOT NULL;

-- 2._ Mostrar el nombre del cuadro y superficie de los 5 cuadros más grandes.
SELECT Ncuadro, concat(Alto*Ancho) as Superficie
FROM cuadro
WHERE concat(Alto*Ancho) IS NOT NULL
ORDER BY concat(Alto*Ancho);

-- 3._ Crear una tabla llamada ‘PintoresEspañoles’ con los campos npintor, fnac, ffall. Establecer la clave primaria. 
create table PintoresEspañoles(
npintor VARCHAR (30),
fnac date,
ffall date);

-- 4._ Añadir una columna a la tabla PintoresEspañoles, que se llame “Pais”, y que tenga por defecto el valor “España”.

alter table PintoresEspañoles add pais varchar(15) default 'España';


-- 5._ Mostrar para todos los cuadros, el nombre del cuadro, nombre del pintor, nombre de la pinacoteca donde se encuentra ubicado y superficie del cuadro. Ordenar por nombre de pintor. Fragmento del resultado.

SELECT Ncuadro, NPintor, NPinacoteca, concat(alto*ancho, ' cm') AS Superficie
FROM cuadro
WHERE concat(alto*ancho, ' cm') IS NOT NULL
ORDER BY NPintor;


-- 6._ Mostrar el nombre de cada pintor con el número total de sus cuadros sólo para aquellos pintores que tengan 2 o más obras pintadas con cualquier técnica basada en el óleo, ordenados por el número de cuadros.
SELECT NPintor, count(NPintor) as Total
FROM cuadro
WHERE (NPintor IS NOT NULL)  AND (tecnica like '%Oleo%')
GROUP BY NPintor
HAVING count(NPintor)>=2;


-- 7._ Mostrar el nombre de la escuela y el nombre del país al que pertenece dicha escuela para aquellos pintores que han utilizado cualquier técnica basada en el óleo.

SELECT DISTINCTrow E.NEscuela, E.Pais
FROM CUADRO C, escuela E
WHERE C.tecnica IS NOT NULL and C.tecnica like '%Oleo%';

                                
                                   
-- 8._ Mostrar el nombre de los pintores que no tienen obras publicadas en las pinacotecas de Madrid.
SELECT distinct NPintor, NPinacoteca
FROM CUADRO
WHERE NPinacoteca in (SELECT NPinacoteca
						FROM pinacoteca
                        WHERE Ciudad not like '%Madrid%');
