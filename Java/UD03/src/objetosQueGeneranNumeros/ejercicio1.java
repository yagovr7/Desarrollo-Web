package objetosQueGeneranNumeros;
import java.util.Random;
public class ejercicio1 {
	public static void main(String[] args){
		Random numeroAleatorio= new Random();
		int tirada1= numeroAleatorio.nextInt(6) + 1;
		int tirada2= numeroAleatorio.nextInt(6) + 1;
		int tirada3= numeroAleatorio.nextInt(6) + 1;
		int tirada4= numeroAleatorio.nextInt(6) + 1;
		int tirada5= numeroAleatorio.nextInt(6) + 1;
		int tirada6= numeroAleatorio.nextInt(6) + 1;
		
		System.out.println(tirada1);
		System.out.println(tirada2);
		System.out.println(tirada3);
		System.out.println(tirada4);
		System.out.println(tirada5);
		System.out.println(tirada6);
		}
}
