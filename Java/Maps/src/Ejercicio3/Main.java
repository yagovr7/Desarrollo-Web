package Ejercicio3;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Main{
	
	public static void main(String[] args) {
		Alumno a1 = new Alumno("Daw", 5,5,5);
		Alumno a2 = new Alumno("Counter", 8,9,7);
		Alumno a3 = new Alumno("Bear", 8,2,9);
		Alumno a4 = new Alumno("Ares", 6,4,7);
		
		TreeMap<String, Alumno> alumnos = new TreeMap<>(Collections.reverseOrder());
		alumnos.put(a1.getNombre(), a1);
		alumnos.put(a2.getNombre(), a2);
		alumnos.put(a3.getNombre(), a3);
		alumnos.put(a4.getNombre(), a4);
		
		Set<String> setCodes = alumnos.keySet();
		Iterator<String> it = setCodes.iterator();
		System.out.println("****Orden Inverso****");
		while(it.hasNext()) {
			String code = it.next();
			int media = alumnos.get(code).getMedia();
			System.out.println(code+"	Media: "+media);
		}
		
		System.out.println("\nFirst Key: "+alumnos.firstKey());
		System.out.println("\nLast Key: "+alumnos.lastKey());
		System.out.println("\nHead Map: "+alumnos.headMap("Ares").keySet());
		
		
	}
}
