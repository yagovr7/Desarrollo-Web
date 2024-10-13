
-- +++++++++++++++++++++++++++++  FUNCIONES +++++++++++++++++++++++++++++++++++

-- •	La función realiza la conversión de pesetas a euros.
SELECT FUNCION1(1000) AS CONVERSOR;

-- •	La función realiza la conversión de pesetas a euros y viceversa.
SELECT FUNCION2(2,1000) AS CONVERSOR;

-- •	La función 2 puede mejorarse dejando un solo RETURN 
SELECT FUNCION3(1,1000) AS CONVERSOR;

-- •	Llamando a la función anterior desde dentro de un procedimiento:
SET @P=1000;
CALL F1(@P);
SELECT @P;

-- Sobre la BD Kadoo
-- •	Si se desea obtener el número de directores por tipo:
SELECT FUNCION4(TIDIR) AS 'Tipo de Dirección' , COUNT(*) AS NUMERO
FROM TDEPTO
GROUP BY TIDIR;


-- •	Si se desea obtener el número de empleados de un departamento que se le pasa como argumento:

SELECT FUNCION5(100) AS NUMEMPLEADOS;

-- •	La función 5 anterior más simplificada:

SELECT FUNCION6(100) AS NUMEMPLEADOS;

-- •	Para  obtener  el  nombre  de  un  empleado  cuyo  número  de  empleado 
-- se pasa  como parámetro (devuelve nulo si este no existe) puede emplearse la siguiente función:
 SELECT FUNCION7(111) AS Empleado;
 
 

 
 
 
 
 
 
 