/*Sentencia DML para insertar los datos en las tablas*/

/*Datos para la tabla chip_grafico*/

INSERT INTO chip_grafico VALUES 
(1,'NVIDIA','Santa Clara, California, Estados Unidos'),
(2,'AMD','Santa Clara, California, Estados Unidos');
                                
/*Datos para la tabla fabricantes*/

INSERT INTO fabricante VALUES 
(1,'MSI','Zhonghe District, Taiwán'),
(2,'GIGABYTE','Distrito Xindian, Nuevo Taipéi, Taiwán'),
(3,'ASUS','Taipéi, Taiwán'),
(4,'SAPPHIRE','Sha Tin New Town, Hong Kong (China)'),
(5,'PNY','Parsippany, Nueva Jersey (Estados Unidos)'),
(6,'ZOTAC','18-24 Shan Mei Street, Hong Kong, China'),
(7,'EVGA','Brea, California (Estados Unidos)');
                                
/*Datos para tipo_grafica*/
INSERT INTO tipo_grafica VALUES
(1,'Multimedia'),
(2,'Aplicaciones 3D'),
(3,'Servidor');
                                
/*Datos para la tabla graficas*/

INSERT INTO graficas VALUES 
(1,'MSI','GT 1030 AERO ITX',2,1430,'DDR4',1,109.78,1,1,1),
(2,'MSI','GTX 1650 SUPER',4,1740,'GDDR6',1,255.46,2,1,2),
(3,'MSI','RTX 2060 VEENTUS',12,1680,'GDDR6',2,439.90,2,1,2),
(4,'MSI','RTX 3050 VEENTUS',8,1777,'GDDR6',3,399.91,2,1,2),
(5,'GIGABYTE','GT 730',2,902,'GDDR3',1,82.36,1,1,1),
(6,'GIGABYTE','GTX 1050 Ti',4,1430,'GDDR5',1,214.94,2,1,2),
(7,'GIGABYTE','RX 6600',8,16000,'GDDR6',3,419.89,2,2,2),
(8,'GIGABYTE','RTX 3050',8,1822,'GDDR6',3,369.90,2,1,2),
(9,'GIGABYTE','RTX 2060 WINDFORCE',12,2176,'GDDR6',2,515.59,2,1,2),
(10,'ASUS','RX 550',2,1183,'GDDR5',3,136.94,1,2,2),
(11,'ASUS','GT 1030',2,1266,'GDDR5',3,144.81,1,1,1),
(12,'ASUS','GTX 1650',4,1485,'GDDR5',3,233.27,1,1,2),
(13,'ASUS','RTX 2060',6,1365,'GDDR6',3,379.89,2,1,2),
(14,'ASUS','RTX 3050',8,2560,'GDDR6',3,420.83,2,1,2),
(15,'SAPPHIRE','RX 6400',4,2039,'GDDR6',3,159.89,1,2,2),
(16,'SAPPHIRE','RX 6600',8,2044,'GDDR6',3,379.89,2,2,2),
(17,'SAPPHIREE','RX 6900',16,2365,'GDDR6',4,2302.07,1,2,3),
(18,'PNY','Quadro P400 V2',2,256,'GDDR5',4,137.40,1,1,3),
(19,'PNY','GTX 1660',6,1530,'GDDR6',3,368.57,2,1,2),
(20,'PNY','Quadro P1000 V2',4,640,'GDDR5',3,377.88,1,1,3),
(21,'PNY','RTX 3080 Ti',12,1665,'GDDR6X',3,1592.17,3,1,2),
(22,'PNY','RTX A4000',16,6144,'GDDR6',4,1379.83,1,1,3),
(23,'PNY','Tesla A100',40,6144,'HBM2',2,12916.12,0,1,3),
(24,'ZOTAC','GT 730',4,902,'GDDR3',1,147.53,1,1,1),
(25,'ZOTAC','GTX 1650',4,1620,'GDDR6',4,234.58,1,1,2),
(26,'ZOTAC','RTX 3050',8,1807,'GDDR6',3,349.90,2,1,2),
(27,'ZOTAC','RTX A4000',6,1680,'GDDR6',4,379.89,2,1,2),
(28,'EVGA','GTX 1650',4,1860,'GDDR5',1,262.24,2,1,2),
(29,'EVGA','RTX 2060 KO',6,1755,'GDDR6',2,479.40,2,1,2),
(30,'EVGA','RTX 3050',8,1845,'GDDR6',3,349.90,2,1,2),
(31,'EVGA','RTX 3090 Ti',24,1920,'GDDR6X',3,2439.89,3,1,2);

/*Datos para multimedia*/
INSERT INTO multimedia VALUES (1,'Si', 'Si', 'Si');

/*Datos para aplicaciones_3d*/
INSERT INTO aplicaciones_3d VALUES (2,'Si', 'Si', 'Si');

/*Datos para servidor*/
INSERT INTO servidor VALUES (3,'Si', 'Si');

/*Datos para ensambla*/
INSERT INTO ensambla VALUES 
(1,1),(1,2),(1,3),(1,4),
(2,5),(2,6),(2,7),(2,8),(2,9),
(3,10),(3,11),(3,12),(3,13),(3,14),
(4,15),(4,16),(4,17),
(5,18),(5,19),(5,20),(5,21),(5,22),(5,23),
(6,24),(6,25),(6,26),(6,27),
(7,28),(7,29),(7,30),(7,31);

/*Datos para proveedores*/
INSERT INTO proveedores VALUES 
(1,'PcComponentes', 'https://www.pccomponentes.com/'),
(2,'Amazon', 'https://www.amazon.es/'),
(3,'COOLMOD', 'https://www.coolmod.com/');

INSERT INTO vende VALUES 
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),
(2,1),(2,5),(2,11),(2,24),
(3,17),(3,18),(3,20),(3,22),(3,23);

                                
                                