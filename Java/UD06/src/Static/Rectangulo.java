package Static;

class Rectangulo {
	 private int origenX;
	 private int origenY;
	 private int ancho ;
	 private int alto ;
	 
	 Rectangulo(int origenX, int origenY, int ancho, int alto) {
	 this.origenX = origenX;
	 this.origenY = origenY;
	 this.ancho = ancho;
	 this.alto = alto;
	 }
	 
	 public void setAncho(int ancho){
	 this.ancho=ancho;
	 }

	 public void desplazar(int x, int y) {
	 origenX+=x;
	 origenY+=y;
	 }
	 
	 public Rectangulo duplicar(){
	 return new Rectangulo(origenX,origenY,ancho,alto);
	 }
	 public boolean esMayor(Rectangulo rect){

	 if (this.ancho*this.alto>rect.ancho*rect.alto) {
	 return true;
	 }
	 else {
		 return false;
	 }
	 }
	 public String datosRectangulo(){
	 return "("+ origenX+","+origenY+","+ancho+","+alto+")";
	 }

	public int getOrigenX() {
		return origenX;
	}

	public void setOrigenX(int origenX) {
		this.origenX = origenX;
	}

	public int getOrigenY() {
		return origenY;
	}

	public void setOrigenY(int origenY) {
		this.origenY = origenY;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}
	 
	}
