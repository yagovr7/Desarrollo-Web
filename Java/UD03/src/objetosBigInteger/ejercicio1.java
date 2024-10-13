package objetosBigInteger;
import java.math.BigInteger;
import java.util.Scanner;

public class ejercicio1 {
	private static Scanner sc;

	public static void main (String []args) {
		sc = new Scanner(System.in);
		
		 System.out.println("Introduce numberA");
		 BigInteger numberA = sc.nextBigInteger();
		 System.out.println("Introduce numberB");
		 BigInteger numberB = sc.nextBigInteger();
		 numberA = numberA.add(numberB);
		 System.out.println("numberA = " + numberA);
		 numberA = numberA.multiply(numberB);
		 System.out.println("numberA = " + numberA);
		 numberA = numberA.subtract(numberB);
		 System.out.println("numberA = " + numberA);
		 numberA = numberA.divide(numberB);
		 System.out.println("numberA = " + numberA);
		 numberA = numberA.mod(numberB);
		 System.out.println("numberA = " + numberA);
		 numberA = numberA.pow(2);
		 System.out.println("numberA = " + numberA);
		 numberA = numberA.negate();
		 System.out.println("numberA = " + numberA);
	}
}
