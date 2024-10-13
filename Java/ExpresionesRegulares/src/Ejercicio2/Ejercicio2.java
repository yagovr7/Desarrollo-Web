package Ejercicio2;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2{

    public static void main(String[] args){

         
	     Pattern pattern = Pattern.compile("([0-9]){8}([a-zA-Z]{1})");
	     Matcher matcher;
	     Scanner teclado= new Scanner(System.in);
             System.out.println("CTRL-C para fin");
	     while (true){
		System.out.print("DNI: ");
		matcher=pattern.matcher(teclado.next());
		if(matcher.matches()) {
			System.out.println("\tOK");
			break;
		}else {
  			System.out.println("\tMAL"); 
		}
	}
 }
    /*
     * la base de la ER es (25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]), observa:
	va entre paréntesis  para que la opcionalidad de | sea dentro de lo que hay en los paréntesis
	Cada parte de una dirección IP puede tener 1, 2 o 3 dígitos:
	3 dígitos pueden ser números que:
	empiezan por 25: 251,252,253,254 o 255. Lo que se resume con 25[0-5]
	empiezan por 2 pero siendo algo menor que 250. Lo que se resume con 2[0-4][0-9]
	empiezan por 1: 1[0-9][0-9]
	2 digitos, : pero el primero de los números  no puede ser cero [1-9][0-9]
	1 digito [0-9]

     * 
     * */
}
