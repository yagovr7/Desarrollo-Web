package Autoevaluacion;

public class Ejercicio1 {
	
	public static int lastIndexOf(int[] matriz, int num) {
		for(int i = matriz.length - 1; i >= 0; i--) {
			if(matriz[i] == num) {
				return i;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int[] matriz = {74, 85, 102, 99, 101, 85, 56};
		
		System.out.println(Ejercicio1.lastIndexOf(matriz, 85));
	}
}
