package Ejercicio2;

public class Guia {
	private String nombre;
	private int telefono;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	Guia(String n, int t){
		this.nombre = n;
		this.telefono = t;
	}
}
