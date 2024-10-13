package Serializacion_Ej3;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("Personas.p")));
			System.out.print("Nombre: ");
			String nombre = sc.next();
			System.out.print("Password: ");
			String pwd = sc.next();
			Persona p = new Persona(nombre, pwd);
			output.writeObject(p);
		}catch(IOException ioException) {
			System.out.println("Error al abrir el fichero");
		}
		
		try {
			input = new ObjectInputStream(Files.newInputStream(Paths.get("Personas.p")));
		}catch(IOException ioException) {
			System.out.println("Error al abrir el archivo");
		}
		System.out.printf("%-10s%-10s%n", "Nombre", "Password");
		try {
			while(true) {
				Persona p = (Persona) input.readObject();
				System.out.printf("%-10s%-10s%n", p.nome, p.pwd);
			}
		}catch (EOFException endOfFileException)
	      {
	         System.out.printf("%nNon hai mais datos.%n");
	      } 
	      // Excepcion que xorde cando nos chega un obxecto que non esperamos
	      catch (ClassNotFoundException classNotFoundException)
	      {
	         System.err.println("Tipo de obxecto inválido.");
	      } 
	      catch (IOException ioException)
	      {
	         System.err.println("Erro lendo o ficheiro.");
	      }
	}
}
