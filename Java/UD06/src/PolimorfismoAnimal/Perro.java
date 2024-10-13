package PolimorfismoAnimal;

public class Perro extends Animal{
	public Perro(String nombre, int edad) {
		super(nombre, edad);
		System.out.println(">Constructor de Perro");
	}
	
	public String habla() {
		return "Guau!!";
	}
	
}
