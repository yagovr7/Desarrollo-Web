package PolimorfismoEjercicio3;

public class Barco {
	private String nombre;
	private String tipo;
	private int CapacidadPasajeros;
	private int CapacidadCarga;
	
	public Barco(String nombre, String tipo, int capacidadPasajeros, int capacidadCarga) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.CapacidadPasajeros = capacidadPasajeros;
		this.CapacidadCarga = capacidadCarga;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCapacidadPasajeros() {
		return CapacidadPasajeros;
	}
	public void setCapacidadPasajeros(int capacidadPasajeros) {
		CapacidadPasajeros = capacidadPasajeros;
	}
	public int getCapacidadCarga() {
		return CapacidadCarga;
	}
	public void setCapacidadCarga(int capacidadCarga) {
		CapacidadCarga = capacidadCarga;
	}
	
	public String toString() {
		return "Nombre Barco: " + getNombre()+
				"\nTipo de Barco: "+getTipo()+
				"\nCapacidad de Pasajeros: "+getCapacidadPasajeros()+
				"\nCapacidad de Carga: "+getCapacidadCarga()+" Kg";
	}
	
	
	
	public void datosBarco() {
		System.out.println("Nombre Barco: " + getNombre());
		System.out.println("Tipo de Barco: "+getTipo());
		System.out.println("Capacidad de Pasajeros: "+getCapacidadPasajeros());
		System.out.println("Capacidad de Carga: "+getCapacidadCarga()+" Kg");

	}
	
	
}
