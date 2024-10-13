package PolimorfismoEjercicio2;

public class Main {
	public static void main(String[] args) {
		
		Figura[] figuras = new Figura[9];
		
		figuras[0] = new Triangulo("Amarillo",2,2);
		figuras[1] = new Triangulo("Azul",4,4);
		figuras[2] = new Triangulo("Verde",8,8);
		
		figuras[3] = new Rectangulo("Rojo",3,3);
		figuras[4] = new Rectangulo("Naranja",6,6);
		figuras[5] = new Rectangulo("Marron",12,12);
		
		figuras[6] = new Circulo("Rosa",4);
		figuras[7] = new Circulo("Violeta",8);
		figuras[8] = new Circulo("Magenta",16);
		
		for(Figura f: figuras) {
			if(f.area()>40) {
				f.color="Negro";
			}
			System.out.println("Area: "+f.area()+" Color: "+f.color);
		}
	}
}
