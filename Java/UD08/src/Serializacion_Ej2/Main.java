package Serializacion_Ej2;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	public static void main(String[] args) {
		HashMap<String, Ciudades> ciudades = new HashMap<>();
		
		ciudades.put("Lugo", new Ciudades("Lugo", 43.01, 7.33));
		ciudades.put("Barcelona", new Ciudades("Barcelona", 41.23, 2.11));
		ciudades.put("Madrid", new Ciudades("Madrid", 40.24, 3.41));
		ciudades.put("Lima", new Ciudades("Lima", 12.03, 77.03));
		
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get("Ciudades.city")));
			Set<String> setCodes = ciudades.keySet();
			Iterator<String> iterator = setCodes.iterator();
			
			while(iterator.hasNext()) {
				String code = iterator.next();
				Ciudades city = ciudades.get(code);
				output.writeObject(city);
			}
			
		}catch(IOException ioException) {
			System.out.println("Error en la apertura");
			System.exit(1);
		}
		
		try {
			input = new ObjectInputStream(Files.newInputStream(Paths.get("Ciudades.city")));
		}catch (IOException ioException){
	         System.err.println("Erro abrindo ficheiro.");
	         System.exit(1);
	      }
		boolean fin = false;
		
		System.out.printf("%-10s%-10s%-10s%n", "Ciudad", "Latitud", "Longitud");
		try {
			while(!fin) {
				Ciudades city = (Ciudades) input.readObject();
				System.out.printf("%-10s%-10s%-10s%n", city.ciudad, city.latitud, city.longitud);
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
