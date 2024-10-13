package Autoevaluacion;

public class Ejercicio7 {
	
	public static double median (double[] array) {
		double media = 0;
		for(int i=0;i<array.length;i++) {
			double num1=array[array.length-1]/2;
			double num2=array[array.length-1]/2+1;
			media=num1+num2;
			media=media/2;
		}
		
		
		return media;
	}
	
	public static void main(String[] args) {
		double[] array = {1.0, 2.0, 3.0, 4.0};
		
		
	}

}
