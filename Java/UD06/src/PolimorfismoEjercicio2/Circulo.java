package PolimorfismoEjercicio2;

public class Circulo extends Figura{
	double radio;
	
	Circulo(String color, double radio){
		super(color);
		this.radio = radio;
	}
	
	public double area() {
		return Math.PI*Math.pow(radio, 2);
	}

}
