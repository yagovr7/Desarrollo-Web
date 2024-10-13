package ejercicioObligatorio4;
import java.util.Scanner;

public class ejercicio4 {
	
	public int contadorLetra(String cadena, char caracter) {
		int contador=0;
		for(int limite =0;limite<cadena.length();limite++) {
			if(cadena.charAt(limite)==caracter) {
				contador++;
			}
		}
		return contador;
	}
	
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		String cadena;
		int suma=0;
		System.out.print("Introduce un carácter:");
		CharSequence caracter=sc.next();
		char x = caracter.charAt(0);
		ejercicio4 total=new ejercicio4();
		System.out.println("Escribe lo que quieras (<> para Finalizar)");
		
		for(;;) {
			cadena=sc.next();
			suma=suma+total.contadorLetra(cadena, x);
			if(cadena.contains("<>")) {
				System.out.println("Apariciones de  '"+x+"'"+": "+suma);
				break;
				}
			}
		
	}
}
