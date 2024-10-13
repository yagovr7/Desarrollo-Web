package ejercicios;
import java.util.Scanner;

public class ejercicio2 {
	public static void main (String []args) {
		Scanner entrada = new Scanner (System.in);
		double datos = entrada.nextDouble();
		entrada.close();
		System.out.println(datos+"ºC son "+(1.8*datos+32)+"ºF");
		
	}
}
