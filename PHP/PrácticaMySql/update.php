<?php
function update($connect){
    $conexion = new PDO($connect[0], $connect[1], $connect[2]);
    $use = $conexion -> prepare("USE TarjetasGraficas; ");
    $use->execute();
    $use = $conexion -> prepare("UPDATE graficas SET marca = 'Fernando', modelo = 'Wirz' WHERE marca = 'EjemploMarca';");
    $use->execute();
    $filas = $use -> rowCount();
    echo "<h2>".$filas. " filas afectadas</h2>";
}