package Herencia;

public class Gato extends Animal {
	
	public String habla() {
		return "Miau!!";
	}
	/*
	@Override
	public String toString() {
		return "Edad Gato:" + getEdad() + " Nombre Gato:" + getNombre();
	}*/
	public Gato() {
		System.out.println(">Constructor de Gato");	}
	public Gato(String nombre, int edad) {
		super(nombre, edad);
		System.out.println(">Constructor de Gato");
	}
}
