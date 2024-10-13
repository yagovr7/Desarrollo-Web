<?php
//Importo los archivos .php para ejecutar las funciones
    include('conexion.php');
    include('consultas.php');
    include('insert.php');
    include('update.php');
    include('delete.php');
    /*
    Inicio sesion para almacenar los datos del usuario teniendo en cuenta que los botones del ejercicio son submit del formulario,
    de esta forma evito perder los datos del usuario
    */
    session_start();
    if(!isset($_SESSION['user']) && !isset($_SESSION['passwd']) && !isset($_SESSION['conexion']) && !isset($_SESSION['exito'])){
        $_SESSION['user'] = "";
        $_SESSION['passwd'] = "";
        $_SESSION['conexion'] = "";
        $_SESSION['exito'] = false;
        $estado = "Desconectado 🔴";
    }
    if($_SESSION['exito']){
        $estado = "Conectado 🔵";
    }else{
        $estado = "Desconectado 🔴";
    }
    //Pasamos los datos del login y si el usuario y contraseña con correctos se conecta a la base de datos
    if(isset($_POST['login'])){
        $_SESSION['user'] = $_POST['user'];
        $_SESSION['passwd'] = $_POST['passwd']; 
        try{
            $_SESSION['conexion'] = conexion($_SESSION['user'], $_SESSION['passwd']);
            $db = new PDO($_SESSION['conexion'][0], $_SESSION['conexion'][1], $_SESSION['conexion'][2]);
            createDataBase($_SESSION['conexion']);
            $_SESSION['exito'] = true;
            $estado = "Conectado 🔵";
        }catch(PDOException $e){
            $estado = "Desconectado 🔴";
            $_SESSION['exito'] = false;
        }
    }
    //Si pulsamos el el input logout nos desconectamos de la base de datos
    if(isset($_POST['logout'])){
        $_SESSION['user'] = "";
        $_SESSION['passwd'] = "";
        $estado = "Desconectado 🔴";
        $_SESSION['exito'] = false;
    }   
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarjetas Gráficas</title>
    <link rel="stylesheet" href="styles/styles.css">
</head>
<body>
    <header>
        <?php
            echo "<p>". $estado . "</p>";    
         ?>
         
         <!-- Creamos el login -->
        <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
                <input type="text" name="user" id="user" placeholder="Username">
                <input type="text" name="passwd" id="passwd" placeholder="Password">
                <input type="submit" name="login" value="Login">
                <input type="submit" name="logout" value="Logout">
        </form>
    </header>
    <main>
        <?php
        //Si la conexión es exitosa mostramos los botones para ejecutar el ejercicio
            if($_SESSION['exito']){
                echo "<div>";
            }else{
                echo "<div style=\"display: none\">";
            }
            ?>
            <!-- Formulario para acceder a la consulta, insert, update y delete -->
            <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST" class ="consultas">
            <input type="submit" name="tablas" value="Ver Tablas">
            <input type="submit" name="total" value="Gráficas">
            <input type="submit" name="insert" value="Insert">
            <input type="submit" name="update" value="Update">
            <input type="submit" name="delete" value="Delete">
            </form>
        </div>
        <?php
        /*
        *Se ejecuta todo este bloque en caso de que la conexión a la Base de Datos sea exitosa,
        *de lo contrario no se accede a los datos.
        */

        //Funcion verTablas que muestra las tablas de la base de datos
        if($_SESSION['exito']){
            if(isset($_POST['tablas'])){
                echo "<section>";
                echo "<h2>Tablas Tarjetas Graficas</h2>";
                try{
                    verTablas($_SESSION['conexion']);
                }catch(PDOException $e){
                    echo $e->getMessage();
                }
                echo "</section>";
            }

            //Funcion graficas que visualizar todas las tarjetas graficas de la tabla graficas
            if(isset($_POST['total'])){
                echo "<section>";
                echo "<h2>Gráficas</h2>";
                try{
                    graficas($_SESSION['conexion']);
                }catch(PDOException $e){
                    echo $e->getMessage();
                }
                echo "</section>";
            }

            //Funcion insert para insertar el registro
            if(isset($_POST['insert'])){
                echo "<section>";
                try{
                    insert($_SESSION['conexion']);
                }catch(PDOException $e){
                    echo "<h2>".$e->getMessage()."</h2>";
                }
                echo "</section>";
            }

            //Funcion update para actualizar un registro
            if(isset($_POST['update'])){
                echo "<section>";
                try{
                    update($_SESSION['conexion']);
                }catch(PDOException $e){
                    echo "<h2>".$e->getMessage()."</h2>";
                }
                echo "</section>";
            }
            //Funcion delete que elimina un registro
            if(isset($_POST['delete'])){
                echo "<section>";
                try{
                    delete($_SESSION['conexion']);
                }catch(PDOException $e){
                    echo "<h2>".$e->getMessage()."</h2>";
                }
                echo "</section>";
            }
        }
        ?>
    </main>
    <footer>Yago Vila Rama &copy;</footer>
</body>
</html>