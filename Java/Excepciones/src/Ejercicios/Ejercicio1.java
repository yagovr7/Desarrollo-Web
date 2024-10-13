package Ejercicios;

public class Ejercicio1 {
	public static void main(String[] args){
		int[] x= {0,1,2,3,4};
		try {
			x[5]=5;
		}catch(IndexOutOfBoundsException e){
			System.out.println("No puedes dividir entre cero");
		}
		System.out.println("El programa se recupera de la excepción y continua");
		}
}
