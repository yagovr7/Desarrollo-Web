package objetosQueGeneranNumeros;
import java.util.Random;
import java.util.Scanner;
public class ejercicio2 {
	private static Scanner sc;
	public static void main(String[] args){
		sc = new Scanner(System.in);
		
		System.out.println("Introduce Cara o Cruz");
		String select = sc.next();
		int eleccion = select.equals("cara")?0:1;
		Random moneda= new Random();
		int jugada = moneda.nextInt(2);
		System.out.println(jugada == eleccion?"acertaste":"fallaste");
		
		
		}

}
