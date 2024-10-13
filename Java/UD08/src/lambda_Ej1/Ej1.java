package lambda_Ej1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ej1 {
	static void busquedaFicheros(Path p, String x) {
		try(Stream<Path> stream = Files.find(p, Integer.MAX_VALUE,
			(path, attr) ->  attr.isRegularFile())){
			stream.forEach(System.out::println);
			System.out.println("Tamaño: "+Files.size(p));
			
		} catch (IOException e) {
		    System.out.println("Es un directorio");
		}
	}
	
	static boolean isDirectory(String x) {
		try (Stream<Path> paths = Files.list(Path.of(x))) {
		    paths.filter(Files::isDirectory);
		    return true;
		}catch (IOException e) {
		    e.getStackTrace();
		}
		return false;
		
	}
	public static void main(String[] args) {
		Path ruta = Paths.get(".\\src");
		String uri = ".\\src\\Ejercicio1\\Main.java";
		busquedaFicheros(ruta, uri);
		System.out.println("Es un directorio: "+isDirectory(uri));
	}
}
