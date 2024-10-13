package ejercicios;
import java.util.Scanner;
public class ejercicio4 {
	public static void main(String []args) {
		Scanner entrada = new Scanner (System.in);
		
		float capital = entrada.nextFloat();
		float interes = entrada.nextFloat();
		int tiempo = entrada.nextInt();
		entrada.close();
		double cuadrado = Math.pow(1+interes/100, tiempo);
		double cuenta =capital*cuadrado;
		double rendimiento =Math.pow(1+interes/100, tiempo)-1;
		double cuenta2 =capital*rendimiento;
		
		System.out.printf("Capital inicial (€): %.2f",capital);
		System.out.printf("\nInterés anual (%s):  %.2f","%",interes);
		System.out.println("\nAños (a): "+tiempo);
		System.out.println("**********************************");
		System.out.printf("* Capital inicial:	%.2f € *",capital);
		System.out.printf("\n* Interés anual:	     %.2f%s *",interes,"%");
		System.out.println("\n* Periodo: 		       "+tiempo+" a*");
		System.out.printf("* Capital fial: 	%.2f € *",cuenta);
		System.out.printf("\n* Rendimeinto : 	%.2f € *",cuenta2);
		System.out.println("\n**********************************");
	}
}
