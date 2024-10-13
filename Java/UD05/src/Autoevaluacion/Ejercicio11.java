package Autoevaluacion;

public class Ejercicio11 {
	
	public static void collapse(int[] array) {
		int[] arrayAux = new int [array.length/2];
		int j = 0;
			for(int i = 0;i<array.length;i++) {
				arrayAux[j]=array[i]+array[i+1];
				i++;
				j++;
			}
			
			for(int i = 0;i<arrayAux.length;i++) {
				System.out.print(arrayAux[i]+ " ");
			}
	}
	
	public static void main(String[] args) {
		int[] array = {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
		collapse(array);
	}
}
