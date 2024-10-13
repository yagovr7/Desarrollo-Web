package ejercicios;
import java.util.Scanner;

public class ejercicio7 {
	Double peso;
	Double altura;
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce tu peso");
		Double peso = sc.nextDouble();
		
		System.out.println("Introduce tu altura");
		Double altura = sc.nextDouble();
		Double IMC = peso/Math.pow(altura,2);
		if(IMC <18.5) {
			System.out.println("Delgado: "+IMC);
		}else if(IMC >=18.5 && IMC <=24.9) {
			System.out.println("Normal: "+IMC);
		}else if(IMC >=25 && IMC <=29.9) {
			System.out.println("Sobrepeso: "+IMC);
		}
		else if(IMC >=30) {
			System.out.println("Obeso: "+IMC);
		}
		
	}
}
