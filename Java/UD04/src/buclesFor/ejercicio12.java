package buclesFor;
import java.util.Random;

public class ejercicio12 {
	public static void main(String[] args) {
		Random rnd = new Random();
		int i;
		int acumulador = 0;
		int tiradas = 0;
		while(tiradas <= 5999999) {
			i = (int)(rnd.nextDouble()*6+1);
			if(i==6) {
			acumulador++;
			}
			tiradas++;
			
		}
		System.out.println("Total de veces que sale el '6': "+acumulador);
	}
}

