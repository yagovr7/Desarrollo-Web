<?php
if(!isset($_POST['usuario'],$_POST['hash'],$_POST['pass1'],$_POST['pass2']))
exit('Faltan datos');
$usuario=$_POST['usuario'];
$hash=$_POST['hash'];
$pass1=$_POST['pass1'];
$pass2=$_POST['pass2'];
require 'conexionBD.php';
require 'hash.php';
$con=new Conexion();
if(getHash($usuario)!=$hash) exit('Problemas con el hash');
if($pass1!=$pass2) exit('Contraseñas distintas');
$sql='UPDATE usuarios SET password=:password WHERE usuario=:usuario';
$stmt=$con->prepare($sql);
$stmt->bindParam(':usuario',$usuario);
$stmt->bindParam(':password',$password);
$password=password_hash($pass1,PASSWORD_DEFAULT);
$stmt->execute();
header('Location:login.php');