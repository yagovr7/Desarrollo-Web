package buclesWhile;
import java.util.Scanner;

public class ejercicio6 {
	public static void main (String []args) {
		Scanner sc = new Scanner(System.in);
		String palabra;
		String listapalabra="";
		System.out.println("Palabra:");
		palabra=sc.next();
		
		while(!palabra.equals("fin")) {
			listapalabra+=" "+palabra;
			System.out.println("Palabra: ");
			palabra=sc.next();
		}
		System.out.println("Lista de palabras: "+listapalabra);
}
}
