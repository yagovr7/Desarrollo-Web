package ejercicios;
import java.util.Scanner;
public class ejercicio3 {
	public static void main (String []args) {
		Scanner entrada = new Scanner (System.in);
		
		float lado1 = entrada.nextFloat();
		float lado2 = entrada.nextFloat();
		entrada.close();
		float perimetro = 2*(lado1+lado2);
		float area = lado1*lado2;
		
		System.out.printf("Longitud del primer lado: %,.2f",lado1);
		System.out.printf("\nLongitud del primer lado: %,.2f",lado2);
		System.out.println("\n================================");
		System.out.printf("Perímetro: %,.2f",perimetro);
		System.out.printf(" Área: %,.2f",area);
	}
}
