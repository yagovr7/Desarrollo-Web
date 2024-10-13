<?php
//Función que muestra las tablas de la base de datos
function verTablas($connect){
    $conexion = new PDO($connect[0], $connect[1], $connect[2]);
    $use = $conexion -> query("USE TarjetasGraficas");
    $consulta = $conexion -> query("SHOW TABLES;");
    while($val = $consulta -> fetch(PDO::FETCH_NUM)){
            echo "<p>" . $val[0] . "</p>";
    }
    
}
//Función que visualiza todas las filas de la tabla
function graficas($connect){
    $conexion = new PDO($connect[0], $connect[1], $connect[2]);
    $use = $conexion -> query("USE TarjetasGraficas");
    $consulta = $conexion -> query('SELECT * FROM graficas;');
    $consulta2 = $conexion -> query('SELECT count(*) FROM graficas;');
    while($val = $consulta -> fetch(PDO::FETCH_NUM)){
        echo "<p><span>".$val[1]." ".$val[2]."</span><span>Precio: ".$val[7]."€</span></p>";
    }
    while($val = $consulta2 -> fetch(PDO::FETCH_NUM)){
        echo "<br><h3>Total de gráficas: ".$val[0]."</h3>";
    }
}
