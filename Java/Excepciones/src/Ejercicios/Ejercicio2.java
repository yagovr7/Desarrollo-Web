package Ejercicios;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n = 0; // Numero entero introducido por teclado.
        boolean entradaValida = false;
        
        // Pedimos al usuario que introduzca un número entero válido
        while (!entradaValida) {
            System.out.print("Introduzca un número entero: ");
            try {
                n = teclado.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe introducir un número entero.");
                teclado.nextLine(); // Limpiamos el buffer del Scanner
            } catch (NumberFormatException e) {
                System.out.println("Error: debe introducir un número entero.");
                teclado.nextLine(); // Limpiamos el buffer del Scanner
            }
        }
        
        // Calculamos factorial
        int factorial = n;
        String salida = n + "! = " + n;
        for (int i = n - 1; i > 0; i--) {
            salida += "*" + i;
            factorial *= i;
        }
        salida += " = " + factorial;
        System.out.println(salida);
    }
}
