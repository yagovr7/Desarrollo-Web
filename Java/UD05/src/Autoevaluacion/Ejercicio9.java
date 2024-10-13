package Autoevaluacion;

public class Ejercicio9 {
	
	public static boolean isUnique(int[] array) {
		int contador = 0;
		
		for(int i = 0;i<array.length;i++) {
			for( int j = 0;j<array.length-1;j++) {
				if(i!=j&&array[i]==array[j]) {
					contador++;
				}
			}
		}
		if(contador>0) {
			return false;
			}else{
				return true;
			}
		
		
	}
	
	public static void main(String[] args) {
			int[] array = {1, 3, 3};
			
			System.out.println(isUnique(array));
	}
}
