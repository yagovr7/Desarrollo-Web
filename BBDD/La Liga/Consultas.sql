
-- ------------------------FILTROS-ORDER BY

-- 1.1.	Mostrar todos los datos de los jugadores del equipo 3 ordenados por apellido.

  SELECT * 
  FROM JUGADORES 
  WHERE IDEQUIPO = 3 
  ORDER BY APELLIDO;

-- 1.2.	Mostrar nombre, apellido e idJugador de los jugadores que juegan cómo ‘pivot ordenados por su identificador.

  SELECT NOMBRE, APELLIDO, IDJUGADOR 
  FROM JUGADORES 
  WHERE PUESTO LIKE 'PIVOT' 
  ORDER BY IDJUGADOR;

-- 1.3.	Mostrar nombre y apellido de los jugadores que midan más de 2 metros y ganen menos de 100000 euros.

  SELECT NOMBRE, APELLIDO -- , altura, salario
  FROM JUGADORES 
  WHERE ALTURA > 2.00 AND SALARIO < 100000;

-- 1.4.	Mostrar todos los datos de los partidos jugados en febrero.

  SELECT * FROM PARTIDOS WHERE FECHA LIKE   '____-02%';

  SELECT * FROM PARTIDOS WHERE MONTH(FECHA) = 2;


-- 1.5.	Mostrar todos de los jugadores de los equipos 1 y 2 que ganen más de 80000 euros.

  SELECT * 
  FROM JUGADORES 
  WHERE (IDEQUIPO BETWEEN 1 AND 2) AND SALARIO > 80000;
  
  
-- 1.6.	Mostrar todos los datos de los equipos cuya web termine en ‘.com’ o ‘.net’ 
  
  SELECT * 
  FROM EQUIPOS 
  WHERE WEBOFICIAL LIKE '%.NET' OR 
        WEBOFICIAL LIKE '%.com';


-- ------------------------FUNCIONES DE RESUMEN-GROUP BY-HAVING
 
 -- 1.7.	Número de partidos jugados en febrero. 
  
   SELECT COUNT(*) 'PARTIDOS FEBRERO' 
   FROM PARTIDOS 
   WHERE FECHA LIKE   '____-02%';

 -- Ó
  
   SELECT COUNT(*) 'PARTIDOS FEBRERO' 
   FROM PARTIDOS 
   WHERE MONTH(FECHA) = 2 ;
  
  
-- 1.8.	Id de equipo y suma de las alturas de sus jugadores.

  SELECT IDEQUIPO, SUM(ALTURA) AS sumAltJu 
  FROM JUGADORES 
  GROUP BY IDEQUIPO;

-- 1.9.	Id de equipo y salario total de cada equipo para equipos con más de 2 jugadores.

  SELECT IDEQUIPO, SUM(SALARIO) -- , count(*)
  FROM JUGADORES 
  GROUP BY IDEQUIPO 
  HAVING COUNT(*) > 2;

-- 1.10.	Número de ciudades distintas en la tabla de equipos.

  SELECT COUNT(DISTINCT CIUDAD) as numCiudades
  FROM EQUIPOS;

  -- 1.11.	Nombre y apellidos de los capitanes de los equipos.

  SELECT NOMBRE, APELLIDO -- ,idEquipo
  FROM JUGADORES 
  GROUP BY IDCAPITAN;
  
  -- ------------------------SUBCONSULTAS-ALL-ANY-EXISTS

-- 1.12.	Mostrar todos los datos del jugador más alto.
  
  SELECT * 
  FROM JUGADORES 
  WHERE ALTURA = (SELECT MAX(ALTURA) FROM JUGADORES);

-- 1.13.	Suma de alturas de los jugadores del CAI y Madrid.

 SELECT SUM(ALTURA) 'TOTAL ALTURAS' 
 FROM JUGADORES 
 WHERE IDEQUIPO IN
					(SELECT IDEQUIPO 
                     FROM EQUIPOS 
                     WHERE (NOMBREEQUIPO LIKE '%CAI%') OR 
                           (NOMBREEQUIPO LIKE '%MADRID%'));



-- 1.14.	Datos de equipos que hayan jugado algún partido en casa contra el Valencia.


  SELECT * 
  FROM EQUIPOS
  WHERE IDEQUIPO IN 
				(SELECT ELOCAL 
                 FROM PARTIDOS
				 WHERE EVISITANTE = 
									(SELECT IDEQUIPO 
                                     FROM EQUIPOS  
                                     WHERE NOMBREEQUIPO LIKE '%VALENCIA%'));


-- 1.15.	Nombre de los jugadores que midan más que todos los del Caja Laboral.

  SELECT NOMBRE,ALTURA 
  FROM JUGADORES
  WHERE ALTURA > ALL 
				(SELECT ALTURA 
                 FROM JUGADORES
				 WHERE IDEQUIPO IN 
                               (SELECT IDEQUIPO 
                                FROM EQUIPOS 
                                WHERE NOMBREEQUIPO like 'CAJA LABORAL'));


-- 1.16.	Nombre de los jugadores mejor y peor pagados.


 SELECT NOMBRE, SALARIO 
 FROM JUGADORES 
 WHERE SALARIO IN (SELECT MAX(SALARIO) 
                   FROM JUGADORES) OR 
	   SALARIO IN (SELECT MIN(SALARIO) 
				   FROM JUGADORES);
                   
                   
-- 1.17. Datos de los partidos jugados por equipos que contengan en su web la cadena 'basket'. 

  SELECT * from partidos where elocal     in (SELECT idequipo FROM EQUIPOS WHERE WEBOFICIAL LIKE '%basket%') OR
							   eVisitante in (SELECT idequipo FROM EQUIPOS WHERE WEBOFICIAL LIKE '%basket%');

 
 -- ------------------------CONSULTAS MULTITABLA 
  
 -- 1.18.	Para cada jugador, mostrar su nombre, nombre de equipo y puesto en el que juega.

 SELECT J.NOMBRE, E.NOMBREEQUIPO, J.PUESTO 
 FROM JUGADORES J, EQUIPOS E 
 WHERE J.IDEQUIPO =E.IDEQUIPO; 
                   

-- 1.19.	Para cada equipo, mostrar todos los datos del equipo y número de partidos que han jugado como locales.

SELECT E.*,COUNT(*) AS 'NUMPARTIDOSLOCAL' 
FROM EQUIPOS E, PARTIDOS P 
WHERE E.IDEQUIPO = P.ELOCAL 
GROUP BY P.ELOCAL;


-- 1.20.	Mostrar todos los datos de los equipos con 3 o más jugadores.

SELECT  E.* -- ,COUNT(*)AS 'NUMJUGADORES' 
FROM JUGADORES J, EQUIPOS E 
WHERE J.IDEQUIPO = E.IDEQUIPO 
GROUP BY J.IDEQUIPO 
HAVING COUNT(*) >=3;

-- 1.21.	Mostrar todos los datos de los equipos junto con el salario del jugador que más cobra del equipo.

SELECT E.*, MAX(J.SALARIO) MAXSALARIO 
FROM JUGADORES J, EQUIPOS E 
WHERE J.IDEQUIPO = E.IDEQUIPO 
GROUP BY J.IDEQUIPO;

-- 1.22.	Nombre de los equipos que jugaron en el partido con resultado igual a 90-91.

SELECT E1.*,E2.* 
FROM PARTIDOS P, EQUIPOS E1, EQUIPOS E2 
WHERE RESULTADO like '90-91' AND 
      E1.IDEQUIPO = P.ELOCAL AND 
      E2.IDEQUIPO = P.EVISITANTE;
      
 -- Con subconsulta
 select nombreEquipo from
 equipos 
 where idEquipo  in (select elocal -- , evisitante
					FROM PARTIDOS 
					WHERE resultado LIKE '90-91') or
	   idEquipo in (select evisitante
					FROM PARTIDOS 
					WHERE resultado LIKE '90-91');
      
      
-- 1.23.	Para cada equipo, mostrar su nombre y nombre de su capitán.      

SELECT J1.IDJUGADOR, J1.NOMBRE,J1.APELLIDO, E.NOMBREEQUIPO 
FROM JUGADORES J1, EQUIPOS E
WHERE J1.IDJUGADOR IN (SELECT J2.IDCAPITAN 
					   FROM jugadores j2 
                       WHERE  J2.IDEQUIPO = E.IDEQUIPO);



-- 1.24.	Mostrar todos los datos de todos los jugadores menos los de los equipos uno, dos y tres.

SELECT * 
FROM JUGADORES 
WHERE IDEQUIPO NOT IN (1,2,3);

-- 1.25.	Listado de partidos ordenados por equipo local y fecha.

 SELECT * 
 FROM PARTIDOS 
 ORDER BY ELOCAL, FECHA;

-- 1.26.	Datos del último partido, incluyendo el nombre de los equipos y jugadores.
SELECT P.*, E.nombreEquipo,J.nombre  
FROM PARTIDOS P, JUGADORES J, EQUIPOS E 
WHERE
  (P.ELOCAL     = E.IDEQUIPO OR
   P.EVISITANTE = E.IDEQUIPO) AND
   J.IDEQUIPO   = E.IDEQUIPO AND
   P.FECHA      = (SELECT MAX(P1.FECHA) FROM PARTIDOS P1);
   -- P.FECHA      = (SELECT P1.FECHA FROM PARTIDOS P1 order by 1 desc limit 1);

                             
                                    
-- 1.27.	Datos de los equipos que no han jugado ningún partido como visitantes.

SELECT * FROM EQUIPOS
WHERE IDEQUIPO NOT IN (SELECT eVisitante FROM PARTIDOS);



 




