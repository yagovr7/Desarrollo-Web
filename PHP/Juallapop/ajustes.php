<?php
    require 'conexion.php';

    session_name('Juallapop');
    session_start();
    $error = "<p></p>";

    if(isset($_POST['cuser'])){
        if((new Conexion) -> cambiarUsuario($_SESSION['usuario'] -> usuario, $_POST['username'])){
            $error = "<p style='color:green;'>Usuario modificado</p>";
            if($objectUsuario = (new Conexion()) -> loginCorrecto($_POST['username'], $_SESSION['password'])){
                $_SESSION['usuario'] = $objectUsuario;
            }
        }else{
            $error = "<p id='error'>Error al modificar el usuario</p>";
        }
    }

    if(isset($_POST['cpasswd'])){
        if($_POST['password1'] == $_POST['password2']){
            if((new Conexion) -> cambiarContraseña($_SESSION['usuario'] -> usuario, $_POST['password'], $_POST['password1'])){
                $error = "<p style='color:green;'>Contraseña modificada</p>";
            }else{
                $error = "<p id='error'>Error al modificar la contraseña</p>";
            }
        }else{
            $error = "<p id='error'>La nueva contraseña no coincide</p>";
        }
        
    }

    if(isset($_POST['delete'])){
        if((new Conexion) -> eliminarCuenta($_SESSION['usuario'] -> usuario)){
            header('Location: login.php');
        }else{
            $error = "<p id='error'>Error al eliminar la cuenta</p>";
        }
    }

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <title>Juallapop</title>
    <link rel="stylesheet" href="styles/perfil.css">
</head>
<body>
<header>
        <figure>
            <a href="login.php"><img src="img/Logos/logo-wallapop-home-v2.svg" alt="Logo"></a>
        </figure>
        <div id="error">
        <?php
            echo $error;
        ?>
    </div>
        <figure id="perfil">
            <img src="./img/Logos/usuario.png" alt="Perfil">
            <?php echo $_SESSION['usuario'] -> usuario?>
        </figure>
    </header>

    <main id="ajustes">
        <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST" class="ajustes">
            <label for="username">Username</label>
            <input type="text" name="username" id="username" require>
            <input type="submit" name="cuser" value="Change" class="boton">
        </form>

        <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST" class="ajustes">
            <label for="password">Password</label>
            <input type="text" name="password" id="password" placeholder="Old" require>
            <input type="text" name="password1" placeholder="New" require>
            <input type="text" name="password2" placeholder="Repeat New" require>
            <input type="submit" name="cpasswd" value="Change" class="boton">
        </form>

        <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST" class="ajustes">
            <label for="delete">Delete Account</label>
            <input type="submit" name="delete" id="delete" value="Delete" class="delete">
        </form>
    </main>
    <footer>
    <button onclick="location.href='procesar.php'" class="boton">Perfil</button>
    <button onclick="location.href='login.php'" class="boton">Logout</button>
    </footer>
</body>
</html>