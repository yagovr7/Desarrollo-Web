<?php
    require 'conexion.php';

    session_name('Juallapop');
    session_start();

    $error = "<p></p>";

    

    if($_SERVER["REQUEST_METHOD"] == "POST"){
        if(isset($_POST['subir'])){
            $tam = $_FILES["foto"]["size"];
            if($tam > 500000){
                echo "<p id='error'>Archivo demasiado grande</p>";
                return;
            }
            $res = move_uploaded_file($_FILES["foto"]["tmp_name"],"img/" . $_FILES["foto"]["name"]);
            $titulo = $_POST['titulo'];
            $categoria = $_POST['categoria'];
            $estado = $_POST['estado'];
            $precio = $_POST['precio'];
            $foto = $_FILES["foto"]["name"];
            $id = strtolower($titulo).$_SESSION['usuario'] -> usuario;
            $user = $_SESSION['usuario'] -> usuario;
            if((new Conexion) ->insertarProducto($id, $titulo, $categoria, $estado, $precio, $foto, $user)){
                header("Location: procesar.php");
                $error = "<p style='color:green;'>Producto subido</p>";
            }else{
                $error = "<p id='error'>Error ya existe el producto</p>";
            }
            
            
            
        }
    }

    if(isset($_POST['eliminar'])){
        $producto = $_POST['producto'];
        $user = $_SESSION['usuario'] -> usuario;
        (new Conexion) ->eliminarProducto($producto, $user);
    }

    if(isset($_POST['vaciar'])){
        (new Conexion) ->vaciarBBDD($_SESSION['usuario'] -> usuario);
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

    <main>
    
            <?php
                $productos  = (new Conexion) -> verProductos($_SESSION['usuario'] -> usuario);
                foreach($productos as $val){
                    echo "<dialog class=\"producto\" id=\"dialog_$val[0]\">
                    <img src=\"./img/$val[5]\">
                    Título: $val[1]<br>
                    Categoria: $val[2]<br>
                    Estado: $val[3]<br>
                    Precio: $val[4]€<br>
                    <button onclick=\"document.getElementById('dialog_$val[0]').close()\" class=\"boton\">Cerrar</button>
                    <form method='POST'>
                    <input type='submit' name='eliminar' value='Eliminar' class='boton'>
                    <input type='hidden' name='producto' value='$val[0]'>
                    </form>
                    </dialog>";
                    echo "<button onclick=\"document.getElementById('dialog_$val[0]').showModal()\" class=\"vistaPrevia\">
                            <img src=\"./img/$val[5]\">
                        </button>";
                }
            ?>
        <dialog id="modal">
            <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST" id="subirProducto" enctype="multipart/form-data">
            <fieldset>
                <label for="titulo">Título</label>
                <input type="text" name="titulo" id="titulo" required>
                <label for="categoria">Categoria</label>
                <select name="categoria" id="categoria" required>
                    <option value="Pantalon">Pantalón</option>
                    <option value="Camisa">Camisa</option>
                    <option value="Vestido">Vestido</option>
                    <option value="Jersey">Jersey</option>
                    <option value="Calzado">Calzado</option>
                </select>
                <label for="estado">Estado</label>
                <select name="estado" id="estado" required>
                    <option value="Nuevo con etiqueta">Nuevo con etiqueta</option>
                    <option value="Nuevo sin etiqueta">Nuevo sin etiqueta</option>
                    <option value="Bueno">Bueno</option>
                    <option value="Usado">Usado</option>
                    <option value="Regular">Regular</option>
                </select>
                <label for="precio">Precio</label>
                <input type="number" name="precio" min="1" required>
                <label id="foto"><img src="img/Logos/camara.png" alt="Camara">
                <input type="file" name="foto" id="foto" accept="image/*">
                </label>
                
                <input type="submit" value="Subir" name="subir" class="boton">
                <button onclick="window.modal.close()" class="boton">Cerrar</button>
            </fieldset>
            </form>
        </dialog>
    </main>
    <footer>
    <button onclick="window.modal.show()" class="boton">Subir</button>
    <form action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
        <input type="submit" value="Vaciar" name="vaciar" class="boton" action="<?php echo $_SERVER['PHP_SELF']?>">
    </form>
    <button onclick="location.href='ajustes.php'" class="boton">Cuenta</button>
    <button onclick="location.href='login.php'" class="boton">Logout</button>
    </footer>
</body>
</html>