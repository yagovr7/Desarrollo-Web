package buclesFor;
import java.util.Scanner;

public class ejercicio7 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número: ");
		int fin = sc.nextInt();
		for(int i = 0; i<=fin;i++) {
			System.out.println(i);
		}
	}
}
