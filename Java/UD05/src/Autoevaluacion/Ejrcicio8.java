package Autoevaluacion;

public class Ejrcicio8 {
	public static double percentEven(int [] array) {
		double resultado = 0;
		for(int i = 0;i<array.length;i++) {
			if(array[i]%2==0) {
				resultado++;
			}
		}
		resultado = (100*resultado)/array.length;
		if(array.length==0) {
			resultado=0;
			return resultado;
		}
		
		return resultado;
	}
	
	public static void main(String[] args) {
		int[] array = {};
		
		System.out.println(percentEven(array));
	}

}
