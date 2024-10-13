<?php
$tituloWeb='Establecer contraseña';
if(!isset($_GET['usuario'],$_GET['hash']))
exit('Problemas estableciendo contraseña');
$usuario=$_GET['usuario'];
$hash=$_GET['hash'];
?>
<!DOCTYPE html>
<html>
<head><title><?=$tituloWeb?></title></head>
<body>
<h1><?=$tituloWeb?></h1><hr>
<form method='POST' action='actualizarPassword.php'>
<input type='hidden' name='usuario' value='<?=$usuario?>'>
<input type='hidden' name='hash' value='<?=$hash?>'>
<input type='password' name='pass1' placeholder='Contraseña'><br>
<input type='password' name='pass2' placeholder='Repita'><br>
<input type='submit' value='Recuperar contraseña'>
</form>
