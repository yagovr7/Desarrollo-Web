/*1. CONSULTAS GENERALES*/

/*Consulta que nos devolvera la cantidad de graficas de la base de datos*/

SELECT count(*) as GraficasTotales FROM graficas;

/*CONSULTAS CON SUBSTRING*/
/*Con la funcion substring obtenemos las 3 primeras letras del modelo de la grafica*/

SELECT modelo as Modelo FROM graficas; /*Ejemplo de la columna*/
SELECT substring(modelo,1,3) as Modelo FROM graficas; /*Con funcion substring*/

/*CONSULTAS CON HAVING*/
/*Consulta que muestra las graficas agrupadas por el id y con condicion en el having de precio entre 100€ y 300€*/

SELECT * FROM graficas GROUP BY 1 HAVING precio BETWEEN 100 AND 300;

/* FUNCIONES MIN, MAX y AVG*/
/*Con las siguientes funciones vamos a obtener la grafica mas cara, la mas barata  y la de precio intermedio*/

SELECT marca, modelo, concat(max(precio),' €') as MaxPrecio FROM graficas;
SELECT marca, modelo, concat(min(precio),' €') as MinPrecio FROM graficas;
SELECT marca, modelo, concat(format(avg(precio),2),' €') as PrecioMedio FROM graficas;

/*Consultas que nos devolveran las graficas que tienen 12 o mas GB de VRAM*/
SELECT marca, modelo, concat(vram,' GB') as vram FROM graficas WHERE vram >= 12;

/*Graficas ordenadas por precio ascendente*/
SELECT * FROM graficas ORDER BY precio;

/*GROUP BY*/
/* Cantidad de graficas fabricadas por cada fabricante*/

SELECT F.nombre as Fabricante, count(G.id_grafica) as GraficasTotales
FROM fabricante F, graficas G
WHERE F.nombre like G.marca
GROUP BY G.marca;


/*2. CONSULTAS MULTITABLA*/

/*Consulta multitabla que nos muestra el fabricante y las graficas que ensambla*/

SELECT F.nombre as Fabricante, concat(G.marca,' ',G.modelo) as Grafica
FROM graficas G, fabricante F, ensambla E
WHERE E.id_fabricante = F.id_fabricante AND E.id_grafica = G.id_grafica
ORDER BY F.nombre;

/* Consulta que nos muestra las graficas que pertenecen a la tabla de servidor*/

SELECT G.marca as Marca, G.modelo as Modelo, S.funcion_servidor, S.produccion_audiovisual
FROM graficas G, servidor S
WHERE G.id_tipo = 3;

/*Consulta que nos muestra las graficas de un fabricante*/

SELECT P.nombre as Vendedor, G.marca, G.modelo
FROM vende V, graficas G, proveedores P
WHERE V.id_proveedor = 2 AND V.id_grafica = G.id_grafica AND V.id_proveedor = P.id_proveedor;


/*3. SUBCONSULTAS*/

/*Consulta con multitabla que muestra las graficas con chip grafico de la marca AMD*/
SELECT * FROM chip_grafico WHERE id_chip like 2; /*ID AMD*/

SELECT *
FROM graficas
WHERE id_chip IN (SELECT id_chip as AMD_ID 
					FROM chip_grafico 
					WHERE id_chip like 2);
                    
/*Suma de los precios de las graficas que no superan los 150€ y quee superan los 150€ con el chip de NVIDIA*/

SELECT C.nombre, concat(format(sum(precio),2),' €') as Total
FROM chip_grafico C, graficas G
WHERE C.id_chip like G.id_chip AND G.id_chip like 1 AND G.modelo IN (SELECT modelo 
																	FROM graficas 
																	WHERE precio <= 150.99);
                                                                    
SELECT C.nombre, concat(format(sum(precio),2),' €') as Total
FROM chip_grafico C, graficas G
WHERE C.id_chip like G.id_chip AND G.id_chip like 1 AND G.modelo IN (SELECT modelo 
																	FROM graficas 
																	WHERE precio >= 150.99);