/*Creo un array vacio donde posteriormento almaceno las notas,
al cual pueden acceder todas las funciones*/
var global = [];

function notas(){
    //Bucle para generar los 5 numeros aleatorios entre 0 y 10
    for(let i = 0; i < 5; i++){
        global[i] = Math.floor(Math.random() * 11);
    }
    //Obtengo el <ul> por su id
    let res = document.getElementById("res");
    let texto = "";
    let contador = 0;
    //inserto los <li> con las notas del array global
    for (let x of global){
        texto = texto +"<li>"+ x + "</li>";
        contador++;
    }
    //inserto el resultado en el elemento id="res"
    res.innerHTML = texto;
}

function media(){
    //obtengo el elemento por su id
    let res = document.getElementById("media");
    let suma = 0;
    /*sumo nota a nota en "suma" incluyendo el valor anterior y lo divido
    entre la cantidad de notas para obtener la media*/
    for(let i = 0; i < global.length; i++){
        suma = suma + global[i];
    }
    //inserto el resultado en el elemento con id="media"
    res.innerHTML = suma / global.length;
}

function MaxNota(){
    let nota = 0;
    let iterator = 0;
    //obtengo el elemento por su id="MaxNota"
    let MaxNota = document.getElementById("MaxNota");
    /*Recorro el array global y si la nota es mayor que la contenida sobrescribo
    la variable que contiene la nota mas alta*/
    while(iterator < global.length){
        if(global[iterator] > nota){
            nota = global[iterator];
        }
        iterator++;
    }
    //inserto el resultado en el elemento con id="MaxNota"
    MaxNota.innerHTML = nota;
}

function menor(){
    //obtengo el elemento con id="menor"
    let menor = document.getElementById("menor");
    let iterator = 0;
    /*recorro todas las notas y en el momento que encuantro
    una nota menor que 4 inserto el mensaje Nota mínima no superada
    en el elemento con id="menor" y con break para salir de la ejecucción
    Pero en caso de que ninguna de las notas sea inferior a 4 muestra
    el mensaje alternativo*/
    do{
        if(global[iterator] < 4){
            menor.innerHTML = "Nota mínima no superada";
            break;
        }
        menor.innerHTML = "Nota mínima superada";
        iterator++;
    }while(iterator < global.length);
}