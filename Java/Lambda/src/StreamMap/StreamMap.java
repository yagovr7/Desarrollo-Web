package StreamMap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamMap {
	public static void main(String[] args) {
		Persona p1 = new Persona("pedro", 30, "perez");
		Persona p2 = new Persona("juan", 25, "perez");
		Persona p3 = new Persona("ana", 20, "perez");
		List < Persona > lista = new ArrayList < Persona > ();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		lista.stream()
		.map(a -> a.getEdad())
		.forEach(a -> System.out.println(a));
		
		lista.stream()
	    .sorted(Comparator.comparing( p -> p.getEdad())).map(x -> x.getEdad())
	    .forEach(System.out::println);
	}
}
