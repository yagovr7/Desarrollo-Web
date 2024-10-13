package Herencia;

public class Animal {
	
	private int edad;
	private String nombre;
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Animal:" + this.nombre + ":" + this.edad;
	}
	
	
	public Animal() {
		this("- sin nombre -", 0);
	}
	
	public Animal(String string, int i) {
		System.out.println(">Constructor Animal");
		this.nombre = string;
		this.edad = i;
	}
	
}
