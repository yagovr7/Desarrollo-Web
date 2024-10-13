package Lambda_con_ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class lambdaDirectoriosArchivos {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("/Users/jmor/NetBeansProjects/AccesoDatos_licencia");
		String folderPath = ".";
		try (Stream<Path> paths = Files.list(Path.of(folderPath))) {
		    paths.filter(Files::isDirectory)
		    .forEach(System.out::println);
		}
		
		Stream<Path> miStream = Files.walk(Paths.get("./src"));
		miStream.forEach(System.out::println);
	}
}
