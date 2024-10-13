package objetosBigDecimal;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class ejercicio1 {
	public static void main(String []args) {
		
		BigDecimal numero1 = new BigDecimal("10.7");
		BigDecimal numero2 = new BigDecimal("5.4");
		
		BigDecimal suma = numero1.add(numero2);
		System.out.println("numero1+numero2= "+suma);
		
		BigDecimal resta = numero1.subtract(numero2);
		System.out.println("numero1+numero2= "+resta);
		
		BigDecimal multiplicacion = numero1.multiply(numero2);
		System.out.println("numero1*numero2= "+multiplicacion);
		
		BigDecimal division = numero1.divide(numero2,7,RoundingMode.DOWN);
		System.out.println("numero1/numero2= "+division);
	}
}
