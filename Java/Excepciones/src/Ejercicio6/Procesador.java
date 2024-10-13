package Ejercicio6;

public class Procesador {
	
	private String modelo;
	private float velocidad;
	
	
	
	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public float getVelocidad() {
		return velocidad;
	}



	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}



	Procesador(String modelo, Float velocidad){
		this.modelo = modelo;
		this.velocidad = velocidad;
	}
}
