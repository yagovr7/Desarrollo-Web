package laClaseString;
import java.util.Scanner;

public class ejercicio1 {
	public static void main(String[] args){
		 /*String s="HOLA,ADIOS,CHAO";
		 Scanner sc = new Scanner(s);
		 sc.useDelimiter(",");
		 System.out.println(sc.next() + " "+ sc.next()+ " "+sc.next());*/
		 Scanner teclado = new Scanner(System.in);
		 
		 System.out.println("Introduce un decimal");
		 String dato = teclado.next();
		 Scanner sc = new Scanner(dato);
		 sc.useDelimiter(",");
		 System.out.println(
				 "Parte entera: "+sc.next()+" Parte decimal: "+sc.next());
		
		 }

}
