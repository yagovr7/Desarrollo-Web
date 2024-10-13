package ejercicioObligatorio5;
import java.util.concurrent.TimeUnit;

public class ejercicio5 {
	public static void main(String[] args) throws InterruptedException {
		int h = 0;
		int m = 0;
		int s = 0;
		for(int i =0;;i++) {
			System.out.printf("%02d:%02d:%02d",h,m,s);
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
			s++;
			if(s==60) {
				m++;
				s=0;
			}
			if(m==60) {
				h++;
				m=0;
			}
		}
		
	}
}
