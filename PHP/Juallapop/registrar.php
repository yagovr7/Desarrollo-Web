<?php
    require 'conexion.php';

    $error = "";

    if(isset($_POST['username'], $_POST['password1'], $_POST['password2'], $_POST['correo'] )){
        if($_POST['password1'] == $_POST['password2']){
            if((new Conexion()) -> registrarUsuario($_POST['username'], $_POST['password1'],$_POST['correo'])){
                header('Location:login.php');
            }else{
                $error = "<p id='error'>El usuario ya existe</p>";
            }
        }else{
            $error = "<p id='error'>La contraseña no coincide</p>";
        }
        
        
    }
?>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="img/logo.webp" >
<title>Juallapop</title>
<link rel="stylesheet" href="styles/login.css">
</head>
<body>
<header>
    <figure>
        <a href="login.php"><img src="img/Logos/logo.webp" alt="Logo"></a>
    </figure>
</header>

<main>
    <div id="error">
        <?php
            echo $error;
        ?>
    </div>
    <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
        <fieldset>
            <legend>Compra y vende en Juallapop</legend>
            <input type="text" name="username" id="username" pattern="[A-Za-z]{4,15}" placeholder="Usuario" required>
            <input type="password" name="password1" id="password1" pattern="[a-zA-Z0-9._]{4,16}" placeholder="Contraseña" required>
            <input type="password" name="password2" id="password2" pattern="[a-zA-Z0-9._]{4,16}" placeholder="Repetir" required>
            <input name='correo' type='text' required='' placeholder='Correo' pattern='[^@]+@[^@]+\.[a-z\d]{2,}'>
            <input type="submit" value="Registrar" name="register" class="boton">
        </fieldset>
    </form>
</main>
<footer>
    <p>Juallapop&copy;</p>
</footer>
</body>
</html>