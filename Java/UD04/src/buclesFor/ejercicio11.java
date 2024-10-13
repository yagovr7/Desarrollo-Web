package buclesFor;
import java.util.Random;


public class ejercicio11 {
	
	
	
	public static void main(String[] args) {
		Random rnd = new Random();
		System.out.println((int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1));
		System.out.println((int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1));
		System.out.println((int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1));
		System.out.println((int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1));
		System.out.println((int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1)+" "+(int)(rnd.nextDouble() * 5 + 1)
				+" "+(int)(rnd.nextDouble() * 5 + 1));
	}
	
}
		/* Solución correcta
		 Random dado = new Random();
		 int tirada;
		 for(int contadorTiradas=1;contadorTiradas<21;contadorTiradas++) {
			 tirada=dado.nextInt(6)+1;
			 System.out.println(tirada+" ");
			 if(contadorTiradas%5=0) {
				 System.out.println();
			 }
		 }*/
 
