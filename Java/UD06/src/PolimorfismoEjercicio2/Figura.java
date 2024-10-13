package PolimorfismoEjercicio2;

public abstract class Figura {
	String color;
	
	public Figura(String color) {
		this.color = color;
	}
	
	public abstract double area();
}
