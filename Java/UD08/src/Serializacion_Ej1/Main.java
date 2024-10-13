package Serializacion_Ej1;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public static void main(String[] args) {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("employee.em")));
		}catch(IOException ioException) {
			System.out.println("Error en la apertura del fichero");
			System.exit(1);
		}
		
		boolean fin = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce ID\s firstName\slastName");
		while(!fin) {
			try {
				Employee empleado = new Employee(sc.next(), sc.next(), sc.next());
				output.writeObject(empleado);
				System.out.println("¿Desea continuar? S/N");
				String salir = sc.next();
				if(salir.equalsIgnoreCase("N")) {
					fin = true;
				}
			}catch(NoSuchElementException elementException) {
				System.err.println("Datos incorrectos");
			}catch(IOException ioException) {
				System.out.println("Error en la escritura");
				break;
			}
		}
		
		try {
			input = new ObjectInputStream(Files.newInputStream(Paths.get("employee.em")));
		}catch(IOException ioException) {
			System.out.println("Error al abrir el fichero");
			System.exit(1);
		}
		
		System.out.println("ID\sfirstName\slastName");
		
		try {
			while(true) {
				Employee empleado = (Employee) input.readObject();
				System.out.printf("%s%s%s", empleado.id, empleado.firstName, empleado.lastName);
			}
		}catch(EOFException endOfFileException) {
			System.out.println("Non hai mais datos");
		}catch(ClassNotFoundException classNotFound) {
			System.out.println("Tipo de objeto no válido");
		}catch(IOException ioException) {
			System.out.println("Error al leer el fichero");
		}
	}
}
