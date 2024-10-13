<?php
    $error = "";

    if(!isset($_SESSION['usuario'])){
        $_SESSION['usuario'] = "";
    }

    if(isset($_POST['login'])){
        $username = $_POST['username'];
        $password = $_POST['password'];
        require 'conexion.php';
        if($objectUsuario = (new Conexion()) -> loginCorrecto($username, $password)){
            session_name('Juallapop');
            session_start();
            $_SESSION['username'] = $_POST['username'];
            $_SESSION['password'] = $_POST['password'];
            $_SESSION['usuario'] = $objectUsuario;
            header("Location: procesar.php");
        }else{
            $error = "<p id='error'>Usuario/contraseña incorrectos</p>";
        }
    }

    if(isset($_POST['register'])){
        header('Location: registrar.php');
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
    <div id="error">
            <?php
                echo $error;
            ?>
    <main>
        
        </div>
        
        <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
            <fieldset>
                <legend>Compra y vende en Juallapop</legend>
                <label for="username">Username</label>
                <input type="text" name="username" id="username" pattern="[A-Za-z]{4,15}">
                <label for="username">Password</label>
                <input type="password" name="password" id="password" pattern="[a-zA-Z0-9._]{4,16}">
                <input type="submit" value="Login" name="login" class="boton">
                <input type="submit" value="Register" name="register" class="boton">
            </fieldset>
        </form>
    
    </main>

    <footer>
        <p>Juallapop&copy;</p>
    </footer>
</body>
</html>