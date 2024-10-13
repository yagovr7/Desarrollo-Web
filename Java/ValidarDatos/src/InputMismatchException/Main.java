package InputMismatchException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int [] array = {4,2,6,7};
	    int n;
	    boolean repetir = false;
	    do{
	         try{
	                repetir = false;
	                System.out.print("Introduce un número entero > 0 y < " + array.length + " ");                     
	                n = sc.nextInt();
	                System.out.println("Valor en la posición " + n + ": " + array[n]);
	         }catch(InputMismatchException e){
	                   sc.nextLine();
	                   n = 0;
	                   System.out.println("Debe introducir un número entero ");
	                   repetir = true;
	         }catch(IndexOutOfBoundsException e){
	                  System.out.println("Debe introducir un número entero > 0 y < " + array.length + " ");           
	                  repetir = true;
	         }catch(Exception e){ //resto de excepciones de tipo Exception y derivadas
	                   System.out.println("Error inesperado " + e.toString());
	                   repetir = true;
	         }
	     }while(repetir);
	}
}
