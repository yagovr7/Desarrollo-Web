package Autoevaluacion;

public class Ejercicio5 {
	public static int mode(int[] array) {
		int resultado = 0;
		int[] aux = new int[array.length];	
		for(int i = 0;i<array.length;i++) {
			
			for(int j = 0;j<array.length;j++) {
				if(array[i]==array[j]) {
					aux[array[j]]+=1;
					resultado=aux[array[j]];
				}
				
			}
		}
		
		return resultado;
		
		
		
		

	}
	
	
	public static void main(String[] args) {
		int[] array = {1, 1, 2, 3};
		int[] array1 = {1, 1, 2, 3, 3};
		int[] array2 = {27, 15, 15, 11, 27};
		
		System.out.println(Ejercicio5.mode(array2));
		
	}
}

/*
if(array[i]==array[i+1]) {
	resultado++;
}*/