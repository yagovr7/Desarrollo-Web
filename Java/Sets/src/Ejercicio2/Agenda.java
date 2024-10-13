package Ejercicio2;
import java.util.*;

public class Agenda {
	public static void main(String[] args) {

		Persona p1 = new Persona(654733907,"Yago");
		Persona p2 = new Persona(666666666,"Yago");
		Persona p3 = new Persona(654753907,"Izan");
		
		HashSet<Persona> agenda = new HashSet<>();
		
		
		agenda.add(p1);
		agenda.add(p2);
		agenda.add(p3);
		
		for(Persona x: agenda) {
			System.out.println(x.getNombre()+" "+x.getTlf());
		}
		
		
	}
}
