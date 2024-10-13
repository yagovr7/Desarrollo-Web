package laClaseString;
import java.util.Scanner;
import numeros.Complejo;

public class ejercicio3 {
	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in);
		
		//creamos número a
		System.out.println("Número a");
		String parteReal=teclado.next();
		String parteImaginaria=teclado.next();
		Complejo a= new Complejo(Double.parseDouble(parteReal),Double.parseDouble(parteImaginaria));
		
		//creamos número b
		System.out.println("Número b");
		String parteReal2=teclado.next();
		String parteImaginaria2=teclado.next();
		Complejo b= new Complejo(Double.parseDouble(parteReal2),Double.parseDouble(parteImaginaria2));
		
		//probar suma a y b
		a.sumar(b);
		String suma=a.convertirAString();
		System.out.println("\nsuma de a y b: "+ suma);
		}
}
