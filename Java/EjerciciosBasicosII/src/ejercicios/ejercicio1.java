package ejercicios;
import java.util.Scanner;

public class ejercicio1 {
	public static void main (String []args) {
		Scanner entrada = new Scanner (System.in);
		
		int dias = entrada.nextInt();
		int horas = entrada.nextInt();
		int minutos = entrada.nextInt();
		int segundos = entrada.nextInt();
		entrada.close();
		
		int conversorSegundos = (dias*84600)+(horas*3600)+(minutos*120)+segundos;
		System.out.println(dias+" dias, "+horas+" horas, "+minutos+" minutos, "+segundos+" segundos son "+conversorSegundos+" segundos");
	}
}
