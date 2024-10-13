package ejercicios;
import java.util.Scanner;

public class ejercicio5 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una vocal");
		char vocal = sc.next().charAt(0);
		if(
			vocal == 'a'|| vocal == 'A') {
			System.out.println("A de Anormal");
		}else if(vocal == 'e'|| vocal == 'E') {
			System.out.println("E de Eunuco");
		}else if(vocal == 'i'|| vocal == 'I') {
			System.out.println("I de Isco Alarcon");
		}else if(vocal == 'o'|| vocal == 'O') {
			System.out.println("O de Ostia puta");
		}else if(vocal == 'u'|| vocal == 'U') {
			System.out.println("U de Umamu");
		}else{
			System.out.println(vocal+" no es una vocal");
		}
	}
}
