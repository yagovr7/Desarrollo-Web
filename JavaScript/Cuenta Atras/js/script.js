let dias;
let horas;
let minutos;
let segundos;
let fecha;
let fechaActual;
let diferencia;
let intervalo;
let array = [];
let contador;


function principal(){
    dias = document.getElementById("dias");
    horas = document.getElementById("horas");
    minutos = document.getElementById("minutos");
    segundos = document.getElementById("segundos");
    contador = document.getElementById("contador");
    mostrarCuentaAtras();
    intervalo = setInterval(actualizar, 1000);
    if(diferencia == 0){
        clearInterval(intervalo);
    }
}

function convertirSegundos(aux){
    array = [];
    array.push(Math.floor(aux  / (60 * 60 * 24)));
    array.push(Math.floor(aux % (60 * 60 * 24) / (60 * 60)));
    array.push(Math.floor(aux % (60 * 60) / (60)));
    array.push(Math.floor(aux % (60)));
}

function mostrarCuentaAtras(){
    let texto = "";
    fechaActual = new Date();
    fecha = new Date(document.getElementById("fecha").value);
    let vacio = document.getElementById("fecha").value == "";
    diferencia = fecha - fechaActual;
    if(vacio ||diferencia < 0){
        diferencia = 0;
        alert("Fecha Inválida");
        if(intervalo != undefined){
            clearInterval(intervalo);
        }
    }
    diferencia = Math.floor(diferencia)/1000;
    convertirSegundos(diferencia);
    contador.textContent = "";
    for(let val of array){
        texto += "<div>"+val+"</div>";
    }
    contador.innerHTML = texto;
}

function actualizar(){
    mostrarCuentaAtras();
}

function detenerTemporizador(){
    clearInterval(intervalo);
}