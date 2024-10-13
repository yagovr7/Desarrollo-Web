package objetosBigDecimal;
import java.math.BigDecimal;
public class main {
	public static void main(String[] args) {
		 
	 	/*BigDecimal a;
 		a = new BigDecimal("2.53333");
 		System.out.println(a);
 		System.out.println(a.scale());
	 	 */
		
		
		 BigDecimal a;
		 a = new BigDecimal("2.53");
		 a=a.setScale(4);
		 System.out.println(a);
		 System.out.println(a.scale());
	}
}
