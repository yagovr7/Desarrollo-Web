package laClaseString;
import java.util.Scanner;

public class ejercicio2 {
	public static void main(String []args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce un número decimal ej:78,75");
		String dato = teclado.next();
		System.out.println("Parte entera: "+dato.substring(0,dato.length()-3)+" Parte decimal: "+dato.substring(dato.length()-2,dato.length()));
	}
}
