<?php
$tituloWeb = 'Autentificación';
$error = '';
if (isset($_POST['usuario'], $_POST['password'])) {
    $usuario = $_POST['usuario'];
    $password = $_POST['password'];
    require 'conexionBD.php';
    if ($objUsuario = (new Conexion())->loginCorrecto($usuario, $password)) {
        session_name('NOMBRE_SESION');
        session_start();
        $_SESSION['usuario'] = $objUsuario;
        header('Location:.');
    } else
        $error = 'Usuario y/o contraseña incorrecta';
}
?>
<!DOCTYPE html>
<html>

<head>
    <title>
        <?= $tituloWeb ?>
    </title>
</head>

<body>
    <h1>
        <?= $tituloWeb ?>
    </h1>
    <hr>
    <a href='nuevoUsuario.php'>Nuevo usuario</a>
    <a href='recuperarPassword.php'>Olvidé la contraseña</a>
    <FORM METHOD='POST'>
        <INPUT type='text' name='usuario' placeholder='Usuario' required=''><br>
        <INPUT type='password' name='password' placeholder='Contraseña' required=''><br>
        <INPUT type='submit' value='Entrar'>
    </FORM>
    <?php if ($error != ''): ?>
        <p style='color:red'>
            <?= $error ?>
        </p>
    <?php endif ?>
