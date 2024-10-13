<?php require 'autentificacion.php' ?>
<!DOCTYPE html>
<html>

<body>
    <h1>Página para usuarios autentificados</h1>
    <b>Usuario conectado</b>:<?= "$usuarioSesion->usuario ($usuarioSesion->correo)" ?>
    <hr>
    <a href='cerrarSesion.php'>Cerrar sesión</a>
</body>

</html>