package Ejercicio1;

public class Main {
	
	public static void main(String[] args) {
		
		//Creamos puntos
		Punto P1 = new Punto(4,5);
		Punto P2 = new Punto(20,20);
		
		//Creamos ciruclos
		Circulo C1 = new Circulo(10,P1);
		Circulo C2 = new Circulo(5,P2);
		
		System.out.println("¿P1 es igual a P2?: "+P1.puntosIguales(P2));
		
		System.out.println("Datos P1 antes de desplazar: "+" X = "+P1.getX()+" Y = "+P1.getY());
		P1.desplazar(10, 15);
		System.out.println("Datos P1 después de desplazar: "+" X = "+P1.getX()+" Y = "+P1.getY());
		
		System.out.println("Datos de C1");
		System.out.println("Radio: "+C1.getRadio()+" Centro: "+" X "+C1.getCentro().getX()+" Y "+C1.getCentro().getY());
		
		System.out.println("Datos de C2");
		System.out.println("Radio: "+C2.getRadio()+" Centro: "+" X "+C2.getCentro().getX()+" Y "+C2.getCentro().getY());
	}
}
