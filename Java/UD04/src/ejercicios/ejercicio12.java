package ejercicios;
import java.util.Scanner;

public class ejercicio12 {
	public static void main(String[] args) {
		 Scanner teclado= new Scanner(System.in);
		 int a,b,s=5; //mejor, es cada variable en su línea pero existe esta posibilidad
		 System.out.println("a: ");
		 a=teclado.nextInt();
		 System.out.println("b: ");
		 b=teclado.nextInt();

		 if(a==0) {
			 if(b!=0) {s=s+b;}
		 }else if(a==0) {
			 if(b==0) {++s;}
		 }else if(a!=0) {
			 if(b==0) {s=999+a;}
		 }else if(a!=0) {
			if(b!=0) {s=888+a+b;}
			System.out.println("s: "+s);
		}
	}
}
