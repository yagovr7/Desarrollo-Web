-- PRIMERO CREAR ESTA BD 
USE 20231130_login;
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
ALTER TABLE `usuarios`
ADD PRIMARY KEY (`usuario`);
COMMIT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;