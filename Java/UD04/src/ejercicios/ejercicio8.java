package ejercicios;
import java.util.Scanner;
public class ejercicio8 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Numero 1");
		int num1 = sc.nextInt();
		System.out.println("Numero 2");
		int num2 = sc.nextInt();
		System.out.println("Numero 3");
		int num3 = sc.nextInt();
		
		if (num1 > num2 && num1 > num3) {
			System.out.println("Numero 1: "+num1+" es el mayor de los 3");
		}else if(num2 > num1 && num2 > num3) {
			System.out.println("Numero 2: "+num2+" es el mayor de los 3");
		}else if(num3 > num1 && num3 > num2) {
			System.out.println("Numero 3 "+num3+" es el mayor de los 3");
		}else if(num1 > num3 && num1 == num2) {
			System.out.println("Numero 1: "+num1+" y Numero 2:"+num2+" son iguales");
		}else if(num1 > num2 && num1 == num3) {
			System.out.println("Numero 1: "+num1+" y Numero 3:"+num3+" son iguales");
		}else if(num2 > num1 && num1 == num3) {
			System.out.println("Numero 2: "+num2+" y Numero 3:"+num3+" son iguales");
		}else if(num2 > num3 && num2 == num1) {
			System.out.println("Numero 2: "+num2+" y Numero 1:"+num1+" son iguales");
		}else if(num3 > num1 && num3 == num2) {
			System.out.println("Numero 3: "+num3+" y Numero 2:"+num2+" son iguales");
		}else if(num1 == num2 && num1 == num3) {
			System.out.println("Todos los numero son iguales");
		}
	}
}
