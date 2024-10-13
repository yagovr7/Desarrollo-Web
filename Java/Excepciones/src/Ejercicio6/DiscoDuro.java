package Ejercicio6;

public class DiscoDuro {
	
	private float capacidad;
	private String tipo;
	private int velocidad;
	
	
	
	public float getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(float capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	DiscoDuro(){
		this.capacidad = 1;
		this.tipo = "SSD";
		this.velocidad = 3500;
	}
	
	DiscoDuro(Float capacidad, String tipo, int velocidad){
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.velocidad = velocidad;
	}
	
	void datosDisco(DiscoDuro disco) {
		System.out.println(disco.capacidad+" Tera "+disco.tipo+" y "+disco.velocidad+" Mb/s");
	}
}
