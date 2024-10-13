package PolimorfismoEjercicio2;

public class Rectangulo extends Figura{
	double base;
	double altura;
	
	Rectangulo(String color, double base, double altura){
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	public double area() {
		return base*altura;
	}

}
