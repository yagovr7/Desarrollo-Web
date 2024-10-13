package PolimorfismoEjercicio2;

public class Triangulo extends Figura{
	double base;
	double altura;
	
	public Triangulo(String color, double base, double altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	public double area() {
		return base*altura;
	}

}
