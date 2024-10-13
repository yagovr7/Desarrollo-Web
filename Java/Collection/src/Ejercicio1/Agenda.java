package Ejercicio1;
import java.util.*;

public class Agenda {
	public static void main(String[] args) {
		
		Persona p1 = new Persona(654733907,"Yago");
		Persona p2 = new Persona(678546363,"Mateo");
		
		List<Persona> agenda = new ArrayList<>();
		
		agenda.add(p1);
		agenda.add(p2);
		
		System.out.println("*Bucle for-each*");
		for(Persona p:agenda) {
			System.out.println("CONTACTO");
			System.out.println("Teléfono: "+p.getTlf());
			System.out.println("Nombre: "+p.getNombre()+"\n");
		}
		agenda.remove(0);
		
		
		System.out.println("*Bucle while con iterator*");
		Iterator<Persona> index = agenda.iterator();
		
		while(index.hasNext()) {
			Persona x = index.next();
			System.out.println("CONTACTO");
			System.out.println("Teléfono: "+x.getTlf());
			System.out.println("Nombre: "+x.getNombre()+"\n");
		}
		agenda.clear();
		
		System.out.println("*Simple Syste.out.println*");
		agenda.forEach(p -> System.out.println("Teléfono: "+p.getTlf()+"\nNombre: "+p.getNombre()+"\n"));
		
		
		
	}
}
