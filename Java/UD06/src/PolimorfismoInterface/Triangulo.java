package PolimorfismoInterface;

public class Triangulo implements MiInterface{
	
	int base = 3;
	int altura = 5;
	
	public void calcularArea() {
		System.out.println(base*altura);	
	}

	public void calcularPerimetro() {		
	}	
}
