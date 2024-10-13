package lambda_Ej1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ej2 {
	static List<Path> buscarFichero(Path path, String nombre) throws IOException {
		List<Path> result;  
		try(Stream<Path> stream = Files.find(path, Integer.MAX_VALUE,
			(p, attr) -> p.getFileName().toString().equalsIgnoreCase(nombre)&& attr.isRegularFile())
			){
			result = stream.collect(Collectors.toList());
				
			}
		return result;
	}
	public static void main(String[] args) throws IOException {
		
		Path p = Paths.get(".");
		List<Path> result = buscarFichero(p, "Perro.java");
		result.forEach(x -> System.out.println(x));
	}
}
