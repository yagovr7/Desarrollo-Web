package objetosBigInteger;
import java.math.BigInteger;

public class main {
	public static void main(String[] args) {
		 long miLong=9223372036854775807l;
		 BigInteger bigInt=new BigInteger("9999999999999999999999999999999999999999999999999999999999999999999");
		 System.out.println("miLong: "+miLong);
		 System.out.println("bigInt: "+bigInt);
		 BigInteger suma=bigInt.add(new BigInteger("1"));
		 System.out.println("Suma de miLong + bigInt: "+suma);
		 }

}
