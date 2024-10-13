<?php
class Conexion extends PDO
{
    private $SERVIDOR = 'localhost';
    private $USUARIO = 'root';
    private $PASSWORD = 'root';
    private $BD = '20231130_login';
    public function __construct()
    {
        $dsn = "mysql:host=$this->SERVIDOR;dbname=$this->BD;charset=utf8";
        parent::__construct($dsn, $this->USUARIO, $this->PASSWORD);
    }
    function loginCorrecto($usuario, $password)
    {
        // si login es correcto devuelve un objeto usuario, null en caso contrario
        $sql = 'SELECT * FROM usuarios WHERE usuario=?';
        $stmt = $this->prepare($sql);
        $stmt->bindParam(1, $usuario);
        $stmt->execute();
        if ($stmt->rowCount() == 1) {
            $objUsuario = $stmt->fetch(PDO::FETCH_OBJ);
            if (password_verify($password, $objUsuario->password))
                return $objUsuario;
        }
        return null;
    }
    public function esCorreoValido($correo)
    {
        // TODO mejorar la expresión regular para un correo
        return preg_match('/^[^@]+@[^@]+\.[a-z\d]{2,}$/i', $correo);
    }
    function insertarUsuario($usuario, $password, $correo): bool
    {
        /* validar usuario en función de requisitos, podríamos escapar caracteres,
        quitar etiquetas en usuario para evitar inyecciones (la inyección SQL ya la evitan los parámetros*/
        $usuario = strip_tags($usuario);
        $password = password_hash($password, PASSWORD_DEFAULT);
        if (!$this->esCorreoValido($correo))
            return false;
        $sql = 'INSERT INTO usuarios (usuario,password,correo) VALUES(?,?,?)';
        $stmt = $this->prepare($sql);
        $stmt->bindParam(1, $usuario, PDO::PARAM_STR);
        $stmt->bindParam(2, $password, PDO::PARAM_STR);
        $stmt->bindParam(3, $correo, PDO::PARAM_STR);
        try {
            $stmt->execute();
        } catch (PDOException $ex) {
            return false;
        }
        return ($stmt->rowCount() == 1);
    }
    function getHash($usuario)
    {
        /* TODO mejorar incluyendo algún dato del registro del usuario: timestamp de inserción, por ejemplo */
        return MD5("ASDÑFLKJASO0W3;;~@$usuario---9asd");
    }
}