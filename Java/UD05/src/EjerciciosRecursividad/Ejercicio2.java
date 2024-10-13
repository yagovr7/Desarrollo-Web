package EjerciciosRecursividad;
import java.util.Scanner;

public class Ejercicio2 {
	public void recursividad(int acumulador, int contador) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Ingrese el #%d: ",contador);
		int num=sc.nextInt();
		if(num==0) {
			System.out.println();
			System.out.println("Se ingreso cero"+
					"\nSuma total: "+acumulador+
					"\nFin!.");
		}else {
			acumulador+=num;
			recursividad(acumulador, contador+1);
		}

	}
	public static void main(String[] args) {
		int contador=1;
		int acumulador=0;
		Ejercicio2 re = new Ejercicio2();
		re.recursividad(acumulador, contador);
	}
}
