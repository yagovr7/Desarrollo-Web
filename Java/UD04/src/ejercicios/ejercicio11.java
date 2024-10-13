package ejercicios;
import java.util.Scanner;

public class ejercicio11 {
	 public static void main(String[] args) {
		 Scanner teclado= new Scanner(System.in);
		 int a,b,s=5;
		 System.out.println("a: ");
		 a=teclado.nextInt();
		 System.out.println("b: ");
		 b=teclado.nextInt();

		 if(a==0) {
			 s=s+b;
		 }else if(b!=0){
			 s=s+b;
		 }else if (a==0){
		 s++;
		 }else if(b==0) {
			 s++;
		 }
		 
		 System.out.println("s: "+s);
		 }

}
