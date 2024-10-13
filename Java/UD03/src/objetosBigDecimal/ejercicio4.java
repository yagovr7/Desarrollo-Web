package objetosBigDecimal;
import java.math.BigDecimal;
import java.util.Scanner;
import java.math.RoundingMode;

public class ejercicio4 {
	private static Scanner sc;
	public static void main(String []args) {
		sc = new Scanner(System.in);
		BigDecimal pvp;
		System.out.println("Precio");
		BigDecimal precio = sc.nextBigDecimal();
		
		System.out.println("Impuesto");
		BigDecimal impuesto = sc.nextBigDecimal();
		BigDecimal i = new BigDecimal(100);
		pvp = ((precio.multiply(impuesto)).divide(i,RoundingMode.DOWN)).add(precio);
		System.out.println("PVP: "+pvp);
	}
}
