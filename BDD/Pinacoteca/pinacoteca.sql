create database Pruebas;
use Pruebas;
--
-- Estructura de tabla para la tabla `pinacoteca`
--
CREATE TABLE IF NOT EXISTS pinacoteca (
	NPinacoteca varchar(40) primary key,
	Ciudad varchar(30) default NULL,
	Direccion varchar(50) default NULL,
	Superficie smallint default NULL
    
);


--
-- Volcado de datos en la tabla `pinacoteca`
--
INSERT INTO pinacoteca (NPinacoteca, Ciudad, Direccion, Superficie) VALUES

('Capilla Real-Granada', 'Granada   ', NULL, NULL),
('Fund. Gala-S. Dalí', 'Barcelona ', NULL, NULL),
('Iglesia St. Tomé', 'Toledo    ', 'Plaza del Conde s/n ', NULL),
('M. del Grabado-Goya', 'Zaragoza  ', 'Fuendetodos         ', NULL),
('Museo de El Escorial', 'Madrid    ', NULL, NULL),
('Museo de El Greco', 'Toledo    ', 'Toledo              ', NULL),
('Museo del Prado', 'Madrid    ', 'Paseo del Prado s/n ', NULL),
('Museo Picasso', 'Barcelona ', NULL, NULL),
('Museo Reina Sofía', 'Madrid    ', 'Sta. Isabel, 52     ', NULL),
('Thyssen-Bornemisza', 'Madrid    ', 'Paseo del Prado, 8  ', NULL);
  
  
--
-- Estructura de tabla para la tabla `mecenas`
--

CREATE TABLE IF NOT EXISTS MECENAS (
  NombreM varchar(30) NOT NULL primary key,
  CiudadM varchar(10) default NULL,
  PaisM varchar(10) default NULL
  
);

--
-- Volcado de datos en la tabla `mecenas`
--
INSERT INTO mecenas (NombreM, CiudadM, PaisM) VALUES
('L. Medici', 'Florencia', 'Italia'),
('Joaquim Cusi i Furtunet', 'Barcelona', 'España');



--
-- Estructura de tabla para la tabla `escuela`
--

CREATE TABLE IF NOT EXISTS ESCUELA (
  NEscuela varchar(10) NOT NULL primary key,
  Pais varchar(10) default NULL,
  Fecha date default NULL
  
);

--
-- Volcado de los datos en la `escuela`
--
INSERT INTO escuela (NEscuela, Pais, Fecha) VALUES

('Flamenca', 'Holanda', '1903-10-31'),
('Sevillana', 'España', '1904-03-29'),
('Veneciana', 'Italia', '1903-07-23');

--
-- Estructura de tabla para la tabla `pintor`
--

CREATE TABLE IF NOT EXISTS pintor (
  Npintor varchar(15) NOT NULL primary key,
  Ciudadpintor varchar(20) default NULL,
  PaisPintor varchar(10) default NULL,
  Fnac date default NULL,
  Ffall date default NULL,
  NombreE varchar(10) default NULL,
  NPintorMaestro varchar(15) default NULL
  
);
--
-- Volcado de datos en la tabla `pintor`
--
INSERT INTO pintor (Npintor, Ciudadpintor, PaisPintor, Fnac, Ffall, NombreE, NPintorMaestro) VALUES


('Balthus', 'Paris', 'Francia', '1908-02-29', '2001-02-18', NULL, 'Derain'),
('Bayeu', NULL, NULL, NULL, NULL, NULL, NULL),
('Botticelli', 'Florencia', 'Italia', '1445-03-01', '1510-05-17', NULL, 'F. F. Lippi'),
('D. Soberano', NULL, NULL, NULL, NULL, NULL, NULL),
('Dali', 'Figueras', 'España', '1904-05-11', '1989-01-22', NULL, NULL),
('Degas', 'Paris', 'Francia', '1834-07-19', '1917-09-27', NULL, NULL),
('Derain', NULL, NULL, NULL, NULL, NULL, NULL),
('El Greco', 'Creta', 'Grecia', '1541-01-01', '1614-04-07', 'Veneciana', NULL),
('F. F. Lippi', NULL, NULL, NULL, NULL, NULL, NULL),
('F. Pacheco', NULL, NULL, NULL, NULL, NULL, NULL),
('Goya', 'Fuendetodos', 'España', '1746-03-30', '1828-04-16', NULL, 'Bayeu'),
('Juan Gris', 'Madrid', 'España', '1887-03-23', '1927-05-11', NULL, NULL),
('M. Fortuny', 'Reus', 'España', '1838-06-11', '1874-11-21', NULL, 'D. Soberano'),
('Manet', 'Paris', 'Francia', '1832-01-23', '1883-04-30', NULL, NULL),
('Miro', 'Barcelona', 'España', '1893-04-20', '1983-12-25', NULL, NULL),
('Murillo', 'Sevilla', 'España', '1617-01-01', '1682-04-03', 'Sevillana', NULL),
('Picasso', 'Malaga', 'España', '1881-10-25', '1973-04-08', NULL, NULL),
('Rubens', 'Siegen', 'Alemania', '1577-06-28', '1640-05-30', 'Flamenca', NULL),
('Sorolla', 'Valencia', 'España', '1863-02-27', '1923-08-10', NULL, NULL),
('Tristan', 'Toledo', 'España', '1585-01-01', '1624-12-31', NULL, 'El Greco'),
('Van Dyck', 'Amberes', 'Belgica', '1599-03-22', '1641-12-09', 'Flamenca', 'Rubens'),
('Velazquez', 'Sevilla', 'España', '1599-06-05', '1660-08-06', NULL, 'F. Pacheco');

--
-- Estructura de tabla para la tabla `protege`
--
CREATE TABLE IF NOT EXISTS protege (
  NMecenas varchar(30),
  NPintor varchar(15),
  FInicio date,
  FFin date
  
);


--
-- Volcar la base de datos para la tabla `protege`
--
INSERT INTO protege (NMecenas, NPintor, FInicio, FFin) VALUES
('Joaquim Cusi i Furtunet', 'Dali', '1879-06-05', '1968-08-06');


--
-- Estructura de tabla para la tabla `salas`
--
CREATE TABLE IF NOT EXISTS salas (
  NPinacoteca varchar(20),
  numSala smallint(5),
  metros double(7,2)
);

--
-- Volcado de datos en la tabla `salas`
--

INSERT INTO salas (NPinacoteca, numSala, metros) VALUES
('Capilla Real-Granada', 1, 3000.50),
('Fund. Gala-S. Dalí', 1, 2000.00),
('Iglesia St. Tomé', 1, 750.00),
('M. del Grabado-Goya', 1, 800.10),
('Museo de El Escorial', 1, 1500.00),
('Museo de El Greco', 1, 2456.87),
('Museo del Prado', 1, 3456.00),
('Museo del Prado', 2, 3456.00),
('Museo del Prado', 3, 3456.00),
('Museo del Prado', 4, 3456.00),
('Museo Picasso', 1, 5000.00),
('Museo Picasso', 2, 5000.00),
('Museo Reina Sofía', 1, 4500.00),
('Museo Reina Sofía', 2, 4500.00),
('Museo Reina Sofía', 3, 4500.00),
('Thyssen-Bornemisza', 1, 7000.00),
('Thyssen-Bornemisza', 2, 7000.00),
('Thyssen-Bornemisza', 3, 7000.00);



-- Estructura de tabla para la tabla `cuadro`

CREATE TABLE IF NOT EXISTS CUADRO (
  CodCuadro varchar(10) NOT NULL primary key,
  Ncuadro varchar(40) default NULL,
  Alto smallint default NULL,
  Ancho smallint default NULL,
  Fcuadro date default NULL,
  Tecnica varchar(15) default NULL,
  NPintor varchar(15) default NULL,
  NPinacoteca varchar(40) default NULL,
  numsala smallint default NULL
  
);

--
-- Volcado de datos en la tabla `cuadro`
--

INSERT INTO cuadro (CodCuadro, Ncuadro, Alto, Ancho, Fcuadro, Tecnica, NPintor, NPinacoteca, numsala) VALUES

('10540', 'Tribunal de la Alhambra                 ', 75, 59, '1871-02-13', 'Oleo           ', 'M. Fortuny', 'Fund. Gala-S. Dalí', 1),
('10733', 'Galarina                                ', 64, 50, '1944-04-27', 'Oleo           ', 'Dalí', 'Fund. Gala-S. Dalí', 1),
('21987', 'San Andrés                              ', 99, 77, '1595-06-01', 'Oleo           ', 'El Greco', 'Museo de El Greco', 1),
('23001', 'Autorretrato                            ', NULL, NULL, '1912-03-24', 'Oleo           ', 'Juan Gris', 'Museo Reina Sofía', 1),
('23155', 'La Nageuse                              ', 182, 216, '1881-04-17', 'Carboncillo    ', 'Picasso', 'Museo Reina Sofía', 1),
('23180', 'Violín y guitarra                       ', 81, 60, '1913-03-27', 'Oleo           ', 'Juan Gris', 'Museo Reina Sofía', 1),
('23458', 'El Guernica                             ', 349, 776, '1937-04-20', 'Oleo           ', 'Picasso', 'Museo Reina Sofía', 1),
('23469', 'Muchacha en la ventana                  ', 105, 74, '1925-04-08', 'Oleo s/cartón  ', 'Dalí', 'Museo Reina Sofía', 1),
('23511', 'Mujer en azul                           ', 133, 101, '1905-03-15', 'Oleo           ', 'Picasso', 'Museo Reina Sofía', 1),
('23670', 'Paisaje                                 ', 130, 194, '1901-05-29', 'Acrílico y cera', 'Miró', 'Museo Reina Sofía', 1),
('33079', 'Los caprichos                           ', NULL, NULL, '1798-11-29', 'Aguafuerte     ', 'Goya', 'M. del Grabado-Goya', 1),
('45109', 'Bailarinas en el escenario              ', 66, 36, '1880-02-22', 'Pastel         ', 'Degas', 'Thyssen-Bornemisza', 1),
('45280', 'La partida de cartas                    ', 140, 194, '1595-05-03', 'Oleo           ', 'Balthus', 'Thyssen-Bornemisza', 1),
('45901', 'Amazona de frente                       ', NULL, NULL, '1882-02-04', NULL, 'Manet', 'Thyssen-Bornemisza', 1),
('50971', 'La oración del huerto                   ', NULL, NULL, '1500-02-08', NULL, 'Botticelli', 'Capilla Real-Granada', 1),
('61329', 'Entierro del Sr. Orgaz                  ', 480, 360, '1587-05-06', 'Oleo           ', 'El Greco', 'Iglesia St. Tomé', 1),
('76004', 'Autorretrato                            ', 32, 23, '1907-03-10', 'Oleo s/papel   ', 'Picasso', 'Museo Picasso', 1),
('76543', 'Bodegón                                 ', 59, 78, '1901-03-15', 'Oleo           ', 'Picasso', 'Museo Picasso', 1),
('76770', 'La comida frugal                        ', 61, 44, '1904-03-18', 'Aguafuerte     ', 'Picasso', 'Museo Picasso', 1),
('76807', 'La copa azul                            ', 66, 28, '1902-03-16', 'Oleo           ', 'Picasso', 'Museo Picasso', 1),
('80175', 'El martitio de S. Mauricio              ', 448, 301, '1582-04-30', 'Oleo           ', 'El Greco', 'Museo de El Escorial', 1),
('90111', 'Paisaje                                 ', NULL, NULL, NULL, 'Oleo           ', 'Van Dyck', 'Museo del Prado', 1),
('90258', 'Las tres gracias                        ', 221, 181, '1635-06-17', 'Oleo           ', 'Rubens', 'Museo del Prado', 1),
('90700', 'La maja desnuda                         ', 97, 190, '1797-11-29', 'Oleo           ', 'Goya', 'Museo del Prado', 1),
('90707', 'La maja vestida                         ', 95, 190, '1805-12-02', 'Oleo           ', 'Goya', 'Museo del Prado', 1),
('90813', 'Retrato de Carlos I                     ', NULL, NULL, NULL, 'Oleo           ', 'Van Dyck', 'Museo del Prado', 1),
('91230', 'Las Meninas                             ', 318, 276, '1656-07-13', 'Oleo           ', 'Velázquez', 'Museo del Prado', 1),
('91558', 'Santa Cena                              ', 107, 164, '1624-06-11', 'Oleo           ', 'Tristán', 'Museo del Prado', 1),
('91987', 'La rendición de Breda                   ', 307, 367, '1635-06-22', 'Oleo           ', 'Velázquez', 'Museo del Prado', 1),
('92110', 'Niños en la playa                       ', 118, 185, '1910-03-24', 'Oleo           ', 'Sorolla', 'Museo del Prado', 1);



-- Claves FORANEAS

ALTER TABLE salas
ADD CONSTRAINT FK_NPinacoteca
FOREIGN KEY FK_NPinacoteca(NPinacoteca)
REFERENCES pinacoteca(NPinacoteca)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE protege
ADD CONSTRAINT FK_NMecenas
FOREIGN KEY FK_NMecenas(NMecenas)
REFERENCES mecenas(NombreM)
ON DELETE SET NULL
ON UPDATE CASCADE;

ALTER TABLE protege
ADD CONSTRAINT FK_NPintor
FOREIGN KEY FK_NPintor(NPintor)
REFERENCES pintor(NPintor)
ON DELETE SET NULL
ON UPDATE CASCADE;

-- 3._ Crear una tabla llamada ‘PintoresEspañoles’ con los campos npintor, fnac, ffall. Establecer la clave primaria. 
create table PintoresEspañoles(
npintor VARCHAR (30),
fnac date,
ffall date);
alter table PintoresEspañoles add pais varchar(15) default 'España';

insert into PintoresEspañoles (npintor, fnac, ffall, pais) values ('Yago Vila Rama', '1996-04-01', '2000-08-06', default);


