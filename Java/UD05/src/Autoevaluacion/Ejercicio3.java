package Autoevaluacion;

public class Ejercicio3 {
	public static int countInRange(int[] matriz, int a, int b){
			int count=0;

			for(int i=0;i<matriz.length;i++) {
				matriz[i]=matriz[i];
				
				if(matriz[i]>=a&&matriz[i]<=b) {
					count++;
						}
					}
			return count;
				}
			
	public static void main(String[] args) {
		int[] matriz={14, 1, 22, 17, 36, 7, -43, 5};
		System.out.println(Ejercicio3.countInRange(matriz,4,17));
		
		
	}
}
