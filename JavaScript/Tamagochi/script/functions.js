let felicidad;
let energia;
let salud;
let limpieza;
let fAleatorio;
let eAleatorio;
let sAleatorio;
let lAleatorio;

function stats(){
    felicidad = document.getElementById('felicidad');
    energia = document.getElementById('energia');
    salud = document.getElementById('salud');
    limpieza = document.getElementById('limpieza');
    fAleatorio = Math.floor(Math.random()*(11 - 1) + 1);
    eAleatorio = Math.floor(Math.random()*(11 - 1) + 1);
    sAleatorio = Math.floor(Math.random()*(11 - 1) + 1);
    lAleatorio = Math.floor(Math.random()*(11 - 1) + 1);
    felicidad.textContent = fAleatorio;
    energia.textContent = eAleatorio;
    salud.textContent = sAleatorio;
    limpieza.textContent = lAleatorio;
    
}

function alimentar(){

    if(fAleatorio <= 8){
        fAleatorio = fAleatorio + 2;
        felicidad.textContent = fAleatorio;
    }else{
        fAleatorio = 10;
        felicidad.textContent = fAleatorio;
    }

    if(eAleatorio <= 7){
        eAleatorio = eAleatorio + 3;
        energia.textContent = eAleatorio;
    }else{
        eAleatorio = 10;
        energia.textContent = eAleatorio;
    }
}

function jugar(){

    if(fAleatorio <= 8){
        fAleatorio = fAleatorio + 2;
        felicidad.textContent = fAleatorio;
    }else{
        fAleatorio = 10;
        felicidad.textContent = fAleatorio;
    }

    if(eAleatorio >= 3){
        eAleatorio = eAleatorio - 2;
        energia.textContent = eAleatorio;
    }else{
        eAleatorio = 1;
        energia.textContent = eAleatorio;
    }

    if(lAleatorio >= 2){
        lAleatorio = lAleatorio - 1;
        limpieza.textContent = lAleatorio;
    }else{
        lAleatorio = 1;
        limpieza.textContent = lAleatorio;
    }
}

function dormir(){

    if(eAleatorio <= 5){
        eAleatorio = eAleatorio + 5;
        energia.textContent = eAleatorio;
    }else{
        eAleatorio = 10;
        energia.textContent = eAleatorio;
    }

    if(sAleatorio <= 8){
        sAleatorio = sAleatorio + 2;
        salud.textContent = sAleatorio;
    }else{
        sAleatorio = 10;
        salud.textContent = sAleatorio;
    }

    if(lAleatorio >= 3){
        lAleatorio = lAleatorio - 2;
        limpieza.textContent = lAleatorio;
    }else{
        lAleatorio = 1;
        limpieza.textContent = lAleatorio;
    }
}

function vacunar(){

    if(fAleatorio >= 7){
        fAleatorio = fAleatorio - 6;
        felicidad.textContent = fAleatorio;
    }else{
        fAleatorio = 1;
        felicidad.textContent = fAleatorio;
    }

    if(sAleatorio <= 5){
        sAleatorio = sAleatorio + 5;
        salud.textContent = sAleatorio;
    }else{
        sAleatorio = 10;
        salud.textContent = sAleatorio;
    }

}

function bañar(){

    if(lAleatorio <= 7){
        lAleatorio = lAleatorio + 3;
        limpieza.textContent = lAleatorio;
    }else{
        lAleatorio = 10;
        limpieza.textContent = lAleatorio;
    }

}

function retar(){

    if(fAleatorio >= 4){
        fAleatorio = fAleatorio - 3;
        felicidad.textContent = fAleatorio;
    }else{
        fAleatorio = 1;
        felicidad.textContent = fAleatorio;
    }

}

function acariciar(){

    if(fAleatorio <= 5){
        fAleatorio = fAleatorio + 4;
        felicidad.textContent = fAleatorio;
    }else{
        fAleatorio = 10;
        felicidad.textContent = fAleatorio;
    }

}