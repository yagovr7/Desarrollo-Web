package Ejercicio2;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Guia persona1 = new Guia("Yago", 654733907);
		Guia persona2 = new Guia("Claudia", 632587895);
		Guia persona3 = new Guia("Mateo", 665874123);
		Guia persona4= new Guia("Izan", 698547852);
		
		TreeMap<String, Integer> guia = new TreeMap<>();
		guia.put(persona1.getNombre(), persona1.getTelefono());
		guia.put(persona2.getNombre(), persona2.getTelefono());
		guia.put(persona3.getNombre(), persona3.getTelefono());
		guia.put(persona4.getNombre(), persona4.getTelefono());
		Set<String> setCodes = guia.keySet();
		Iterator<String> it = setCodes.iterator();
		
		System.out.println("**** Entradas ****");
		while(it.hasNext()) {
			String code = it.next();
			int tlf = guia.get(code);
			System.out.println("Nombre: "+code+"	Teléfono: "+tlf);
		}
		
		System.out.println("\n**** Numero por nombre ****");
		int numero = guia.get("Yago");
		System.out.println("Número por nombre: "+numero);
		
		System.out.println("**** Actualizar número ****");
		guia.replace("Yago", 0);
		Set<String> setCodes2 = guia.keySet();
		Iterator<String> ite = setCodes2.iterator();
		while(ite.hasNext()) {
			String code = ite.next();
			int tlf = guia.get(code);
			System.out.println("Nombre: "+code+"	Teléfono: "+tlf);
		}
	}
}
