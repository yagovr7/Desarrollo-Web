package ordenador;

public class Memoria {
	
	private int capacidad;
	private final String tipo = "DDR4";
	private int velocidad;
	
	
	
	public int getCapacidad() {
		return capacidad;
	}



	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}



	public int getVelocidad() {
		return velocidad;
	}



	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}



	public String getTipo() {
		return tipo;
	}



	Memoria(int capacidad, int velocidad, String tipo){
		this.capacidad = capacidad;
		if(capacidad<2) {this.capacidad = 2;};
		this.velocidad = velocidad;
	}
	
	
}
