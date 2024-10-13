package EjerciciosRecursividad;
import java.util.Scanner;

public class Ejercicio1 {
	
	public void recursividad(String[] ciudad, int x) {
		if(x>0) {
			System.out.println("Ciudad #"+(x)+": "+(ciudad[x-1]));
			recursividad(ciudad,x-1);
		}
		
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Ejercicio1 re = new Ejercicio1();
		String[] ciudad = new String[5];
		
		for(int i = 0;i<ciudad.length;i++) {
			System.out.print("Ingrese el nombre de la ciudad #"+(i+1)+": ");
			ciudad[i]=teclado.next();
		}
		teclado.close();
		re.recursividad(ciudad, 5);
	}
}
