import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer; 
public class Prueba {
	
	
	public static void leerArchivo(String archivo) throws IOException {
		String cadena;
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(cadena,"&");
			String[] parts = cadena.split("&");
			String part1 = parts[2];
			System.out.println(part1);
		}
	}
	public static void main(String[] args)throws IOException {
		/*String txt = "Hola&que&tal";
		StringTokenizer st = new StringTokenizer(txt,"&");
		String[] parts = txt.split("&");
		String part1 = parts[1];
		System.out.println(part1);*/
		leerArchivo("/Users/yagov/Downloads/Prueba.txt");
	}
}
