package Autoevaluacion;

public class Ejercicio2Alternativa {
	
	public static int range(int [] matriz){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int n:matriz) {
			if(n>max) {
				max = n;
			}
			if(n<min) {
				min = n;
			}
		}
		return (max-min)+1;
	}
	
	public static void main(String[] args) {
		int[] matriz = {8, 3, 5, 7, 2, 4};
		
		
		System.out.println(Ejercicio2Alternativa.range(matriz));;
	}
}
