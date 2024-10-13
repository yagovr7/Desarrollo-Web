<?php
$tituloWeb='Nuevo usuario';
$error='';
if(isset($_POST['usuario'],$_POST['pass1'],$_POST['pass2'],$_POST['correo'])) {
require 'conexionBD.php';
$pass1=$_POST['pass1'];
$pass2=$_POST['pass2'];
$correo=$_POST['correo'];
//validamos dentro de insertarUsuario
if($pass1==$pass2)
if((new Conexion())->insertarUsuario($_POST['usuario'],$pass1,$correo))
header('Location:login.php');
else
$error='Problemas insertando el usuario';
else //salvo 'ataque', no debería llegar aquí debido al javascript
$error='Contraseñas distintas';
}
?>
<!DOCTYPE html>
<html>
<head>
<title><?=$tituloWeb?></title>
<script>
function formOk(f) {
if(f.pass1.value!=f.pass2.value) {
alert('Las contraseñas son distintas');
return false;
}
return true;
}
</script>
</head>
<body>
<h1><?=$tituloWeb?></h1><hr>
<form method='POST' onSubmit='return formOk(this)'>
<input name='usuario' type='text' required='' placeholder='Usuario' ><br>
<input name='pass1' type='password' required='' placeholder='Contraseña'><br>
<input name='pass2' type='password' required='' placeholder='Repita'><br>
<input name='correo' type='text' required='' placeholder='Correo'
 pattern='[^@]+@[^@]+\.[a-z\d]{2,}'><br>
<input type='submit' value='Crear usuario'>
</form>
<?php if($error!=''):?>
<p style='color:red'><?=$error?></p>
<?php endif?>
</body>
</html>