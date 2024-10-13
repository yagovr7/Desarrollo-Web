package ejerciciosArrayini;

public class Ejercicio5 {
	public static void main(String args[]) {
			int tam = Integer.parseInt(args[0]);
			int aux1,aux2;
			int[][] matriz = new int[tam][tam];
			for(int i = 0;i<tam;i++) {
				for(int j = 0;j<tam;j++) {
					matriz[i][j]=(int)(Math.random()*(100));

				}
			}
			for(int i = 0;i<tam;i++) {
				for(int j = 0;j<tam;j++) {
					System.out.print(matriz[i][j]+" ");
				}
				System.out.println();

		}
					
				for(int i = 0;i<tam/2;i++) {
					
					aux1 =matriz[i][i];
					matriz[i][i] = matriz[tam-1-i][tam-1-i];
					matriz[tam-1-i][tam-1-i] = aux1;
					
					aux2 =matriz[i][tam-1-i];
					matriz[i][tam-1-i] = matriz[tam-1-i][i];
					matriz[tam-1-i][i] = aux2;

				}
				System.out.println();
				for(int i = 0;i<tam;i++) {
					for(int j = 0;j<tam;j++) {
						System.out.print(matriz[i][j]+" ");
						
					}System.out.println();
				}
			}

	}
