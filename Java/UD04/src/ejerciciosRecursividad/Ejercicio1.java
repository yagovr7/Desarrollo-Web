package ejerciciosRecursividad;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Teclea número entero para calcular factorial:");
		int n = sc.nextInt();
		sc.close();
		int factorial=1;
		while(n>0) {
			factorial=factorial*n;
			n--;
		}
		System.out.println("Su factorial es: "+factorial);
	}
}
