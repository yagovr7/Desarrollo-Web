package ejercicios;
import java.util.Scanner;
public class ejercicio6 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero entero");
		int numero = sc.nextInt();
		
		if ((numero % 2) == 0) {
			System.out.println(numero+" es par");
		}else {
			System.out.println(numero+" no es par");
		}
	}
}
