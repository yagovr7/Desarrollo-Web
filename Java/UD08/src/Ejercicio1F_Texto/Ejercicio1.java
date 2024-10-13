package Ejercicio1F_Texto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		File archivo = new File("test.txt");
		File temp = File.createTempFile("test_temp", ".txt");
		try(BufferedReader  lectura = new BufferedReader (new FileReader(archivo));
			BufferedWriter  escritura = new BufferedWriter (new FileWriter(temp));){
				
				String linea;
				
				while((linea = lectura.readLine()) != null) {
					String lineaSinEspacios = linea.replaceAll("\\s+", "");
					escritura.write(lineaSinEspacios);
				}
		}
					if (archivo.delete()) {
						if(!temp.renameTo(archivo)) {
							throw new IOException("No se puede renombrar el archivo");
						}
					}else {
						throw new IOException("No se puede eliminar el archivo");
					}
					
					System.out.println("Los espacios en blanco han sido eliminados"+archivo.getName());
			}
		}	
