package Ejercicio2File;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		File file = new File(args[0]);
		java.io.File archivo = new java.io.File(args[0]);
		if(!archivo.isDirectory()) {
			System.out.println("El directorio no existe");
		}else {
			for(String s:archivo.list()) {
				System.out.println(s);
			}
		}
	}
}
