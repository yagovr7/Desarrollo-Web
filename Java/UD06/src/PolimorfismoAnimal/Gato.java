package PolimorfismoAnimal;

public class Gato extends Animal {
	
	public Gato(String nombre, int edad) {
		super(nombre, edad);
		System.out.println(">Constructor de Gato");
	}
	
	public String habla() {
		return "Miau!!";
	}
}
