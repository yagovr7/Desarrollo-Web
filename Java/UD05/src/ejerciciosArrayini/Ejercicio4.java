package ejerciciosArrayini;


public class Ejercicio4 {
	public static void main(String args[]) {
		int tam = Integer.parseInt(args[0]);
		int[][] matriz = new int[tam][tam];
			for(int i=0;i<tam;i++) {
				for(int j=0;j<tam;j++) {
				matriz[i][j] = (int)(Math.random()*100);
			}
		}
			for(int i=0;i<tam;i++) {
				for(int j=0;j<tam;j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
			System.out.println();
			for(int i=0;i<tam;i++) {
				int aux=matriz[i][i];
				matriz[i][i]=matriz[i][tam-1-i];
				matriz[i][tam-1-i]=aux;
			}
			for(int i=0;i<tam;i++) {
				for(int j=0;j<tam;j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
			
			
		
	}
}
