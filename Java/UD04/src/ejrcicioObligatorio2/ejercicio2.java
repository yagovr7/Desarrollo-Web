package ejrcicioObligatorio2;
import java.util.Scanner;

public class ejercicio2 {
	public static void main(String[] args) {
		String letras ="TRWAGMYFPDXBNJZSQVHLCKE";
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero de tu DNI para calcular tu letra:");
		int dni = sc.nextInt();
		sc.close();
		int resto = dni%23;
		char resultado = letras.charAt(resto);
		System.out.println(dni+""+resultado);
		
		
		
	}
}
