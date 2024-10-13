package Ejercicio1;

public class Persona {
	private int tlf;
	private String nombre;
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	Persona(int t, String n){
		this.tlf = t;
		this.nombre = n;
	}
}
