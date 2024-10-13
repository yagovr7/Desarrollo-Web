<?php
session_name('NOMBRE_SESION');
session_start();
if (!isset($_SESSION['usuario'])) {
    header('Location:login.php');
    exit;
}
$usuarioSesion = $_SESSION['usuario'];