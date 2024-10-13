-- PRIMERO CREAR ESTA BD
DROP DATABASE IF EXISTS juallapop;
CREATE DATABASE juallapop;
USE juallapop;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
-- – Base de datos: `login` --
-- -- Estructura de tabla para la tabla `usuarios` --
CREATE TABLE `usuarios` (
`usuario` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
`password` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
`correo` varchar(128) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
-- -- Índices para tablas volcadas --
-- – Indices de la tabla `usuarios` --

CREATE TABLE `productos` (
`id` varchar(50) NOT NULL PRIMARY KEY,
`titulo` varchar(50) NOT NULL,
`categoria` varchar (25) NOT NULL,
`estado` varchar(25) NOT NULL,
`precio` INT NOT NULL,
`foto` varchar(25) NULL,
`usuario` varchar(25) COLLATE utf8_spanish_ci NOT NULL
);
ALTER TABLE `usuarios`
ADD PRIMARY KEY (`usuario`);
COMMIT;

ALTER TABLE `productos` 
ADD CONSTRAINT `FK_usuario` 
FOREIGN KEY (`usuario`) 
REFERENCES `usuarios` (`usuario`) 
ON DELETE NO ACTION ON UPDATE CASCADE;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;