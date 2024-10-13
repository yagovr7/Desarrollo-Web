<?php
$tituloWeb='Recuperar contraseña';
$enviarCorreo=isset($_POST['usuario']);
if($enviarCorreo) {
require 'conexionBD.php';
require 'hash.php';
$usuario=$_POST['usuario'];
$hash=getHash($usuario);
$href="cambiarPassword.php?usuario=$usuario&hash=$hash";
}
?>
<!DOCTYPE html>
<html>
<head><title><?=$tituloWeb?></title></head>
<body>
<h1><?=$tituloWeb?></h1><hr>
<?php if($enviarCorreo):?>
Se ha enviado un correo con el siguiente texto:
<a href='<?=$href?>'>Cambiar contraseña</a>
<?php else:?>
<form method='POST'>
<input name='usuario' placeholder='Usuario'>
<input type='submit' value='Recuperar contraseña'>
</form>
<?php endif?>