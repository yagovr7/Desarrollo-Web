<?php
//Función que elimina un registro en la tabla
function delete($connect){
    $conexion = new PDO($connect[0], $connect[1], $connect[2]);
    $use = $conexion -> prepare("USE TarjetasGraficas; ");
    $use->execute();
    $use = $conexion -> prepare("DELETE FROM graficas WHERE marca = 'Fernando' OR marca = 'EjemploMarca';");
    $use->execute();
    $filas = $use -> rowCount();
    echo "<h2>".$filas. " filas afectadas</h2>";
}