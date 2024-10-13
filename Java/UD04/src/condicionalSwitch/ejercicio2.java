package condicionalSwitch;
import java.util.Scanner;

public class ejercicio2 {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introuce el nombre del mes para obtener su número");
		String mes = sc.next();
		
		switch(mes) {
			case ("Enero"):
				System.out.println("Numero de mes: 1");
				break;
			case ("Febrero"):
				System.out.println("Numero de mes: 2");
				break;
			case ("Marzo"):
				System.out.println("Numero de mes: 3");
				break;
			case ("Abril"):
				System.out.println("Numero de mes: 4");
				break;
			case ("Mayo"):
				System.out.println("Numero de mes: 5");
				break;
			case ("Junio"):
				System.out.println("Numero de mes: 6");
				break;
			case ("Julio"):
				System.out.println("Numero de mes: 7");
				break;
			case ("Agosto"):
				System.out.println("Numero de mes: 8");
				break;
			case ("Septiembre"):
				System.out.println("Numero de mes: 9");
				break;
			case ("Octubre"):
				System.out.println("Numero de mes: 10");
				break;
			case ("Noviembre"):
				System.out.println("Numero de mes: 11");
				break;
			case ("Diciembre"):
				System.out.println("Numero de mes: 12");
				break;
			default:
				System.out.println("ERROR: ¡El mes introducido no es correcto, comprueba la ortografía!");
		}
		
	}
}