package Lambda_con_ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class lecturaSecuencial {
	public static void main(String[] args) throws IOException {
		Path file = Paths.get("readFile.txt");
		try(Stream<String>lines = Files.lines(file)
		    .onClose(() -> System.out.println("Fin de lectura"))) {
		        lines.forEach(System.out::println); 
		}
		
		try(BufferedReader br = Files.newBufferedReader(file);
			    Stream<String> lines = br.lines()
			        .onClose(() -> System.out.println("Fin de lectura de ficheiro."));){
			            lines.forEach(System.out::println);
			}
		
		try(Stream<String>lines = Files.lines(file)
		        .parallel()
		        .onClose(() -> System.out.println("Fin de lectura de ficheiro."))) {
		        //modificamos esta parte para poder observar os fíos que se xeran
		        lines.forEach(s ->{
		        System.out.println(s +" " + Thread.currentThread().getName());});
	}
}}
