DROP DATABASE IF EXISTS tarjetasgraficas;
CREATE DATABASE tarjetasgraficas;
USE tarjetasgraficas;
 /*Sentencia DDL para crear las tablas*/
CREATE TABLE chip_grafico(
	id_chip INT auto_increment PRIMARY KEY,
    nombre VARCHAR (20),
    direccion VARCHAR (50)
);

CREATE TABLE fabricante (
	id_fabricante INT auto_increment PRIMARY KEY,
    nombre VARCHAR (20),
    direccion VARCHAR (50)
);

CREATE TABLE graficas (
	id_grafica INT auto_increment PRIMARY KEY,
    marca VARCHAR(20),
    modelo VARCHAR (20),
    vram INT,
    frecuencia INT,
    tipomemoria VARCHAR (10),
    generacion INT,
    precio DOUBLE (7,2),
    num_ventiladores INT,
    id_chip INT,
    id_tipo INT
);

CREATE TABLE tipo_grafica (
	id_tipo INT auto_increment PRIMARY KEY,
    nombre VARCHAR (20)
);

CREATE TABLE multimedia (
	id_tipo INT PRIMARY KEY NOT NULL,
    navegacion_web VARCHAR(5),
    ofimatica VARCHAR(5),
    visualizacion_video VARCHAR(5)
);

CREATE TABLE aplicaciones_3d (
	id_tipo INT PRIMARY KEY,
    edicion_grafica VARCHAR(5),
    aplicaciones_3d VARCHAR(5),
    programas_CAD VARCHAR(5)
);

CREATE TABLE servidor (
	id_tipo INT PRIMARY KEY,
    funcion_servidor VARCHAR(5),
    produccion_audiovisual VARCHAR(5)
);

CREATE TABLE proveedores (
	id_proveedor INT auto_increment PRIMARY KEY,
    nombre VARCHAR (20),
	url VARCHAR (50)
);

CREATE TABLE ensambla (
	id_fabricante INT,
    id_grafica INT
);

CREATE TABLE vende (
	id_proveedor INT,
    id_grafica INT
);

/*Claves foraneas*/
ALTER TABLE graficas 
ADD CONSTRAINT FK_chip 
FOREIGN KEY FK_chip (id_chip) 
REFERENCES chip_grafico (id_chip) 
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE graficas 
ADD CONSTRAINT FK_tipo 
FOREIGN KEY (id_tipo) 
REFERENCES tipo_grafica (id_tipo) 
ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE multimedia 
ADD CONSTRAINT FK_tipomultimedia 
FOREIGN KEY (id_tipo) 
REFERENCES tipo_grafica (id_tipo) 
ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE aplicaciones_3d 
ADD CONSTRAINT FK_tipo3d 
FOREIGN KEY (id_tipo) 
REFERENCES tipo_grafica (id_tipo) 
ON DELETE no action ON UPDATE CASCADE;

ALTER TABLE servidor 
ADD CONSTRAINT FK_tiposerver
FOREIGN KEY (id_tipo) 
REFERENCES tipo_grafica (id_tipo) 
ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE ensambla 
ADD CONSTRAINT FK_fabricante
FOREIGN KEY (id_fabricante) 
REFERENCES fabricante (id_fabricante) 
ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE ensambla 
ADD CONSTRAINT FK_grafica
FOREIGN KEY (id_grafica) 
REFERENCES graficas (id_grafica) 
ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE vende 
ADD CONSTRAINT FK_proveedor
FOREIGN KEY (id_proveedor) 
REFERENCES proveedores(id_proveedor) 
ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE vende 
ADD CONSTRAINT FK_graficaP
FOREIGN KEY (id_grafica) 
REFERENCES graficas (id_grafica) 
ON DELETE NO ACTION ON UPDATE CASCADE;
