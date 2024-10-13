package PolimorfismoInterface;

public class Cuadrado implements MiInterface{
	int lado = 4;

	public void calcularArea() {
		System.out.println(lado*lado);
	}

	public void calcularPerimetro() {
	}	
}
