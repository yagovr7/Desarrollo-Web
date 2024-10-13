package objetosBigDecimal;
import java.util.Scanner;

public class ejercicio5 {
	private static Scanner sc;
	public static void main(String []args) {
		sc = new Scanner(System.in);
		Double pvp;
		System.out.println("Precio");
		Double precio = sc.nextDouble();
		
		System.out.println("Impuesto");
		Double impuesto = sc.nextDouble();
		int i = 100;
		pvp = ((precio*impuesto)/i)+precio;
		System.out.println("PVP: "+pvp);
	}
}
