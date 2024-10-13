package buclesFor;
import java.util.Random;

public class ejercicio13 {
	public static void main(String[] args) {
		Random numeroAleatorio= new Random();
		
		for(;;) {
			int jugada1= numeroAleatorio.nextInt(2);
			System.out.println("En la jugada salió: "+ (jugada1==0?"cara":"cruz"));
		}
	}
}
