package Autoevaluacion;

public class Ejercicio2 {
	
	public static int range(int[] matriz) {
		int mayor, menor;
		mayor = menor = matriz[0];
		
		for(int i = 0;i<matriz.length;i++) {
			if(matriz[i]>mayor) {
				mayor = matriz[i];
			}
			if(matriz[i]< menor){
				menor = matriz[i];
			}
		}
		return (mayor-menor)+1;
		 
	}
	
	public static void main(String[] args) {
		int[] matriz = {8, 3, 5, 7, 2, 4};
		
		
		System.out.println(Ejercicio2.range(matriz));;
	}
}
