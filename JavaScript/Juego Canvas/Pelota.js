class Pelota{
    constructor(contexto, radio, color, x, y){
        this.contexto = contexto;
        this.radio = radio;
        this.color = color;
        this.x = x;
        this.y = y + 20;
        this.xVelocidad = 5;
        this.yVelocidad = -5;

        this.imagen = new Image();
        this.imagen.src = 'asteroide.png';
    }

    mover(objeto) {
        if (this.x + this.radio > this.contexto.canvas.width || this.x - this.radio < 0) {
            this.xVelocidad = -this.xVelocidad;
        }
    
        // Colisión con la barra
        if (
            this.y + this.radio > objeto.y &&
            this.y - this.radio < objeto.y + objeto.alto &&
            this.x + this.radio > objeto.x &&
            this.x - this.radio < objeto.x + objeto.largo
        ) {
            this.yVelocidad = -this.yVelocidad;
        }
    
        // Colisión con la parte superior
        if (this.y - this.radio < 0) {
            this.yVelocidad = -this.yVelocidad;
        }
    
        // Colisión con la parte inferior
        if (this.y + this.radio > this.contexto.canvas.height) {
            this.x = this.contexto.canvas.width / 2;
            this.y = 0 + this.radio;
            alert("YOU LOSE");
            this.draw();
        }
    
        this.x += this.xVelocidad;
        this.y += this.yVelocidad;
    }
    
    

    draw(){
        this.contexto.clearRect(0, 0, 500, 500);
        this.contexto.beginPath();
        this.contexto.arc(this.x, this.y, this.radio, 0, 2 * Math.PI);

        // Dibujar la imagen como fondo
        this.contexto.drawImage(this.imagen, this.x - this.radio, this.y - this.radio, this.radio * 2, this.radio * 2);

        this.contexto.fillStyle = "transparent";  // Establecer el color de relleno como transparente
        this.contexto.fill();
        this.contexto.closePath();

    }

}

class Barra{
    constructor(contexto, largo, alto){
        this.contexto = contexto;
        this.largo = largo;
        this.alto = alto;
        this.x = 200;
        this.y = 450;
        this.velocidad = 50;

        this.imagen = new Image();
        this.imagen.src = 'barra.png';
    }


    redondearBordes(x, y, width, height, radius) {
        this.contexto.beginPath();
        this.contexto.moveTo(x + radius, y);
        this.contexto.arcTo(x + width, y, x + width, y + height, radius);
        this.contexto.arcTo(x + width, y + height, x, y + height, radius);
        this.contexto.arcTo(x, y + height, x, y, radius);
        this.contexto.arcTo(x, y, x + width, y, radius);
        this.contexto.closePath();
    }

    dibujarBarra() {
        // Llamar a la función para dibujar el rectángulo con bordes redondeados
        this.redondearBordes(this.x, 450, this.largo, this.alto, 5); // Puedes ajustar el valor del radio según tus preferencias
        this.contexto.drawImage(this.imagen, this.x, 450, this.largo, this.alto);
        
    }
    /*
    dibujarBarra(){
        this.contexto.fillRect(this.x, 450, this.largo, this.alto);
    }*/

    moverBarra(direccion){
        if(direccion == "Derecha" && this.x < this.contexto.canvas.width - this.largo){
            this.x += this.velocidad;
        }else if(direccion == "Izquierda" && this.x > 0){
            this.x -= this.velocidad;
        }
    }
}



