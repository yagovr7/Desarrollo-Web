<?php
//Función que inserta un registro en la tabla
function insert($connect){
    $conexion = new PDO($connect[0], $connect[1], $connect[2]);
    $use = $conexion -> prepare("USE TarjetasGraficas; ");
    $use->execute();
    $use = $conexion -> prepare("INSERT INTO graficas (marca, modelo, vram, frecuencia, tipomemoria, generacion, precio, num_ventiladores, id_chip, id_tipo)
    VALUES ('EjemploMarca', 'EjemploModelo', 8, 1600, 'GDDR6', 7, 120, 2, 1, 3);");
    $use->execute();
    $filas = $use -> rowCount();
    echo "<h2>".$filas. " filas afectadas</h2>";
}