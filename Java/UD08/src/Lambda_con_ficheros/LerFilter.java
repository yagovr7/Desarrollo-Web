package Lambda_con_ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
public class LerFilter {        
    public static void main(String[] args) throws IOException {      
        //Exemplos do uso do filter     
        try (Stream<String> lines = Files.lines(Path.of("probas.txt"))) {
            long i = lines.filter(line ->line.startsWith("T"))
            .count();
        System.out.println("Numero de lineas que empezar por 'T' e " + i);
    }                
        try (Stream<String> lines = Files.lines(Path.of("probas.txt"))) {
            long i = lines.filter(line ->line.isEmpty())
            .count();
        System.out.println("Número de lineas vacias: " + i);
    }            
    try (Stream<String> lines = Files.lines(Path.of("probas.txt"))) {  
            lines.filter(line ->line.endsWith("11"))
            .forEach(System.out::println);
    }
}}
