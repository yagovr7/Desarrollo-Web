package PolimorfismoAnimal;

public class Estudiante extends Animal{
	
	Estudiante(String nombre, int edad){
		super(nombre, edad);
		System.out.println(">Constructor de Estudiante");
	}
	
	public String habla() {
		return super.habla();
	}
}
