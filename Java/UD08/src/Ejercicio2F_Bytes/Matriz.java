package Ejercicio2F_Bytes;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Matriz {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		double[][] matriz;
		int n = 1;
		double dato;
		int filas, columnas;
		System.out.print("Filas:");
		filas = sc.nextInt();
		System.out.print("Columnas:");
		columnas = sc.nextInt();
		matriz = new double[filas][columnas];
		
			for(int i = 0;i<matriz.length;i++) {
				for(int j = 0;j<matriz.length;j++) {
					System.out.print("Dato: ");
					dato = sc.nextDouble();
					matriz[i][j] = dato;
				}
			}
			
			FileOutputStream archivo = null;
			DataOutputStream salida = null;
			
			try {
				for(int i = 0;i<matriz.length;i++) {
					filas+=1;
					for(int j = 0;j<matriz.length;j++) {
						columnas+=1;
					}
				}
				archivo = new FileOutputStream("datos.txt");
				salida = new DataOutputStream(archivo);
				for(int i = 0;i<matriz.length;i++) {
					//salida.write(matriz[i]);
				}
				
			}catch(FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			 

	}
}
