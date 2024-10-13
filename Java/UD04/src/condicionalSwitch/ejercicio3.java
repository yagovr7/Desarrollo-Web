package condicionalSwitch;
import java.util.Scanner;

public class ejercicio3 {
	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce una vocal");
		char vocal = sc.next().charAt(0);
		
		switch(vocal) {
			case 'a':
			case 'A':
				System.out.println("A de Anormal");
				break;
			case 'e':
			case 'E':
				System.out.println("E de Eunuco");
				break;
			case 'i':
			case 'I':
				System.out.println("I de Isco Alarcon");
				break;
			case 'o':
			case 'O':
				System.out.println("O de Ostia puta");
				break;
			case 'u':
			case 'U':
				System.out.println("U de Umamu");
				break;
			default:
				System.out.println(vocal+" no es una vocal");
				
		}
	}
}


