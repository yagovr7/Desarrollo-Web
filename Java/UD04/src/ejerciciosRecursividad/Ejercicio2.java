package ejerciciosRecursividad;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Teclea número entero para calcular factorial:");
		int n = sc.nextInt();
		sc.close();
		Factorial F = new Factorial();
		
		System.out.println("Su factorial es: "+F.calcularFactorial(n));
}}
