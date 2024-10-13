<?php
//Función que carga la base de datos con sus tablas y la rellena con datos
function createDataBase($conexion){
    $conexion = new PDO($conexion[0], $conexion[1], $conexion[2]);
    $tablasDataBase = './Scripts/tablasTarjetasGraficas.sql';
    $sqlTablas = file_get_contents($tablasDataBase);
    $conexion -> exec($sqlTablas);
    $datosDataBase = './Scripts/datosTarjetasGraficas.sql';
    $sqlDatos = file_get_contents($datosDataBase);
    $conexion -> exec($sqlDatos);
}
//Función que devuelve un array con los datos para ejecutar un objeto PDO
function conexion($user, $passwd){
    $host = "mysql:host = 127.0.0.1";
    $conexion = [$host, $user, $passwd];
    return $conexion;
}