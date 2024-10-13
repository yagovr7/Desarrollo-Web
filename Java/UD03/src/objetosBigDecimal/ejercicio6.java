package objetosBigDecimal;
import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

public class ejercicio6 {
	private static Scanner sc;
	
	public static void main(String []args) {
		sc = new Scanner(System.in);
		BigDecimal pvp;
		BigDecimal i = new BigDecimal(100);
		
		System.out.println("Precio en euros");
		BigDecimal precio = sc.nextBigDecimal();
		precio = precio.setScale(2,RoundingMode.UP);
		
		System.out.println("Impuesto en %");
		BigDecimal impuesto = sc.nextBigDecimal();
		impuesto = impuesto.setScale(2,RoundingMode.UP);
		impuesto=(precio.multiply(impuesto).divide(i)).setScale(2,RoundingMode.UP);
				
		pvp = precio.add(impuesto);
		System.out.println("Precio redondeado a dos decimales: "+precio);
		System.out.println("Impuesto en euros sobre precio: "+impuesto);
		System.out.println("PVP: "+pvp);


	}
	/* Obsoleto el ROUND_UP
	public static void main(String []args) {
		sc = new Scanner(System.in);
		BigDecimal pvp;
		BigDecimal i = new BigDecimal(100);
		
		System.out.println("Precio en euros");
		BigDecimal precio = sc.nextBigDecimal();
		precio = precio.setScale(2,BigDecimal.ROUND_UP);
		
		System.out.println("Impuesto en %");
		BigDecimal impuesto = sc.nextBigDecimal();
		impuesto = impuesto.setScale(2,BigDecimal.ROUND_UP);
		impuesto=(precio.multiply(impuesto).divide(i)).setScale(2,BigDecimal.ROUND_UP);
				
		pvp = precio.add(impuesto);
		System.out.println("Precio redondeado a dos decimales: "+precio);
		System.out.println("Impuesto en euros sobre precio: "+impuesto);
		System.out.println("PVP: "+pvp);
	}*/
}