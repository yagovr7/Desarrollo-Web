package Ejercicio3File;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		File f = new File(args[0]);;
		File[] ficheros = f.listFiles();
		for (int x=0;x<ficheros.length;x++){
		  System.out.println(ficheros[x].getName());
		}
	}
}
