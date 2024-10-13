package Ejercicio1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File("Prueba.txt"))){
		    
		    while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		}catch (FileNotFoundException fnfe) {
		    fnfe.printStackTrace();
		}
	}
}
