package ejercicios;

import java.util.Scanner;

public class ejercicio2 {
	public static void main(String []args) {
		 Scanner entrada=new Scanner(System.in);
		 int x;
		 int y;
		 System.out.println("Teclea número entero");
		 x=entrada.nextInt();
		 System.out.println("Teclea otro número entero");
		 y=entrada.nextInt();
		 if (x== 10) {
		 System.out.println("x vale 10");
		 System.out.println("x + y vale: "+ (x + y));
		 }else {
		 System.out.println("x NO vale 10");
		 System.out.println("x - y vale: "+ (x - y));
		 }
	}
}
