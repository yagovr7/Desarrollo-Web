function pelicula(){
    let edad = document.getElementById("edades").value;
    let genero = document.getElementById("generos").value;
    let resultado = document.getElementById("resultado");
    let convEdad = Number(edad);
    let convGenero = Number(genero);
    if(edad == ''){
        resultado.textContent = "Inserta la Edad";

    }else if(Math.sign(convEdad) <= 0 || !Number.isInteger(convEdad)){
        resultado.textContent = "Campo Inválido";

    }else{
        switch(convGenero){
            case 1:
                
                if(convEdad <= 12){
                        resultado.textContent = "Back to the Future";
    
                }else if(convEdad <= 16){
                    resultado.textContent = "The Truman Show";
                }
                else if(convEdad >= 17){
                    resultado.textContent = "The Wolf of Wall Street";
                }
            break;
    
            case 2:
                if(convEdad <= 12){
                    resultado.textContent = "No hay peliculas";
    
            }else if(convEdad <= 16){
                resultado.textContent = "El secreto de sus ojos";
            }
            else if(convEdad >= 17){
                resultado.textContent = "The Godfather";
            }
            break;
    
            case 3:
                if(convEdad <= 12){
                    resultado.textContent = "Casablanca";
    
            }else if(convEdad <= 16){
                resultado.textContent = "The Shawshank Redemption";
            }
            else if(convEdad >= 17){
                resultado.textContent = "Taxi Driver";
            }
            break;
    
            case 4:
                if(convEdad <= 12){
                    resultado.textContent = "La La Land";
    
            }else if(convEdad <= 16){
                resultado.textContent = "Les Miserables";
            }
            else if(convEdad >= 17){
                resultado.textContent = "The Rocky Horror Picture Show";
            }
            break;

            default:
                resultado.textContent = "Seleccione el género";
            break;
        }
    }

    
}