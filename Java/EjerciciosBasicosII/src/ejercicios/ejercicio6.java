package ejercicios;
import java.util.Scanner;

public class ejercicio6 {
	public static void main (String []args) {
		Scanner entrada = new Scanner (System.in);
		
		double nota1 = entrada.nextDouble();
		double nota2 = entrada.nextDouble();
		double nota3 = entrada.nextDouble();
		entrada.close();
		double media = (nota1+nota2+nota3)/3;
		int media1 = (int)media;
		
		System.out.println("Nota Primera Evaluación: "+nota1);
		System.out.println("Nota Segunda Evaluación: "+nota2);
		System.out.println("Nota Tercera Evaluación: "+nota3);
		System.out.printf("Media: %.2f %s",media,(media>=5?"Aprobado":"Suspenso"));//Redondeada a dos decimales
		System.out.printf("\nMedia: %d %s",media1,(media>=5?"Aprobado":"Suspenso"));
	}
}
