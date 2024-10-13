package Autoevaluacion;

public class Ejercicio4 {
	public  static boolean isSorted(double[] matriz) {
		for (int i = 0; i < matriz.length-1; i++) {
            if (matriz[i] > matriz[i+1]) {
            return false;  
            }      
        }
        return true;
		
	}
	
	public static void main(String[] args) {
		double[] matriz={16.1, 12.3, 22.2, 14.4};
			System.out.println(Ejercicio4.isSorted(matriz));

	}
}
