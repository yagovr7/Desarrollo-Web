<?php

    class Conexion extends PDO{
        private $host = 'localhost';
        private $user = 'root';
        private $passwd = 'root';
        private $BBDD = 'juallapop';

        public function __construct(){
            $dsn = "mysql:host=$this->host;dbname=$this->BBDD;charset=utf8";
            parent::__construct($dsn, $this->user, $this->passwd);
        }

        function loginCorrecto($usuario, $passwd){
            $sql = 'SELECT * FROM usuarios WHERE usuario=?';
            $stmt = $this->prepare($sql);
            $stmt->bindParam(1, $usuario, PDO::PARAM_STR);
            try{
                $stmt -> execute();
                $objectUsuario = $stmt -> fetch(PDO::FETCH_OBJ);
                if($objectUsuario && password_verify($passwd, $objectUsuario -> password)){
                    return $objectUsuario;
                }else{
                    return null;
                }
            }catch(PDOException $error){
                return null;
            }
        }
        function registrarUsuario($usuario, $passwd, $correo){
            $usuario = strip_tags($usuario);
            $passwd = password_hash($passwd, PASSWORD_DEFAULT);
            $insert = 'INSERT INTO usuarios (usuario, password, correo) VALUES (?,?,?);';
            $stmt = $this->prepare($insert);
            $stmt -> bindParam(1, $usuario, PDO::PARAM_STR);
            $stmt -> bindParam(2, $passwd, PDO::PARAM_STR);
            $stmt -> bindParam(3, $correo, PDO::PARAM_STR);
            try{
                $stmt -> execute();
            }catch(PDOException $error){
                return false;
            }
            return ($stmt -> rowCount() == 1);
        }

        function insertarProducto($id, $titulo, $categoria, $estado, $precio, $foto, $usuario){
            $sql = 'INSERT INTO productos (id, titulo, categoria, estado, precio, foto, usuario) VALUES (?, ?, ?, ?, ?, ?, ?);';
            $stmt = $this ->prepare($sql);
            $stmt -> bindParam(1, $id, PDO::PARAM_STR);
            $stmt -> bindParam(2, $titulo, PDO::PARAM_STR);
            $stmt -> bindParam(3, $categoria, PDO::PARAM_STR);
            $stmt -> bindParam(4, $estado, PDO::PARAM_STR);
            $stmt -> bindParam(5, $precio, PDO::PARAM_STR);
            $stmt -> bindParam(6, $foto, PDO::PARAM_STR);
            $stmt -> bindParam(7, $usuario, PDO::PARAM_STR);

            try{
                $stmt -> execute();
            }catch(PDOException $error){
                return false;
            }
            return ($stmt -> rowCount() == 1 );
        }

        function verProductos($usuario){
            $stmt = $this ->prepare('SELECT * FROM productos WHERE usuario LIKE ?');
            $stmt -> bindParam(1, $usuario, PDO::PARAM_STR);
            $stmt ->execute();
            $resultado = $stmt ->fetchAll(PDO::FETCH_NUM);
            return $resultado;
        }

        function vaciarBBDD($usuario){
            $stmt = $this ->prepare('DELETE FROM productos WHERE usuario LIKE ?');
            $stmt -> bindParam(1, $usuario, PDO::PARAM_STR);
            $stmt -> execute();
        }

        function eliminarProducto($idProducto, $usuario){
            $stmt = $this ->prepare('DELETE FROM productos WHERE id LIKE ? AND usuario LIKE ?');
            $stmt -> bindParam(1, $idProducto, PDO::PARAM_STR);
            $stmt -> bindParam(2, $usuario, PDO::PARAM_STR);
            $stmt ->execute();
        }

        function cambiarUsuario($username, $newUsername){
            $stmt = $this -> prepare('UPDATE usuarios SET usuario = ? WHERE usuario LIKE ?');
            $stmt -> bindParam(1, $newUsername, PDO::PARAM_STR);
            $stmt -> bindParam(2, $username, PDO::PARAM_STR);
            $stmt ->execute();
            return ($stmt -> rowCount() == 1);
        }

        function cambiarContraseña($username, $password, $newPassword){
            $stmt = $this -> prepare('SELECT * FROM usuarios WHERE usuario LIKE ?');
            $stmt -> bindParam(1, $username, PDO::PARAM_STR);
            $stmt -> execute();
            $objectUsuario = $stmt -> fetch(PDO::FETCH_OBJ);
            if($objectUsuario && password_verify($password, $objectUsuario -> password)){
                $newPassword = password_hash($newPassword, PASSWORD_DEFAULT);
                $stmt = $this -> prepare('UPDATE usuarios SET password = ? WHERE usuario LIKE ?');
                $stmt -> bindParam(1, $newPassword, PDO::PARAM_STR);
                $stmt -> bindParam(2, $username, PDO::PARAM_STR);
                $stmt ->execute();
                return ($stmt -> rowCount() == 1);
            }else{
                return null;
            }
            
        }

        function eliminarCuenta($username){
            $stmt = $this -> prepare('DELETE FROM usuarios WHERE usuario LIKE ?');
            $stmt -> bindParam(1, $username, PDO::PARAM_STR);
            $stmt -> execute();
            return ($stmt -> rowCount() == 1);
        }
    }