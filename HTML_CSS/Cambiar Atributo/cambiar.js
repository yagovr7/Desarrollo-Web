var estado = 0;
function cambiar(){
    var x = document.getElementById("imagen");
    if (estado === 0) {
        imagen.src = "robot-handshake-human-background-futuristic-digital-age_53876-129770.webp"; // Cambia "imagen2.jpg" por la ruta de la segunda imagen
        estado = 1;
      } else {
        imagen.src = "1000_F_599012797_nAUTiVIm2VfISUhJlXJd6yX8jhnzxEm6.jpg"; // Cambia "imagen1.jpg" por la ruta de la primera imagen
        estado = 0;
      }
}
