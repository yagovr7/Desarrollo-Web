package Ejercicio4;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(".//Pruebas//test.txt");
		System.out.println(path.getParent());
		System.out.println(path.getNameCount());
		System.out.println(path.getFileName());
		
		Path origen = Path.of(".//Pruebas//test.txt");
		Path directorio = Path.of(".//Pruebas//SubDirectorio");
		try {
		    // Create the empty file with default permissions, etc.
		    Files.createDirectory(directorio);
		} catch (FileAlreadyExistsException x) {
		    System.err.format("O ficheiro chamado  %s" +  " xa existe%n", directorio);
		} catch (IOException x) {
		    // Outro tipo de fallo, coma os relacionados con permisos.
		    System.err.format("createFile da erro: %s%n", x);
		}
		Path destino = Path.of(".//Pruebas//SubDirectorio//test.txt");
		Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
		Files.delete(origen);
	}
}
