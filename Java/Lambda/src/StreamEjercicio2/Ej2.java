package StreamEjercicio2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ej2 {
	public static void main(String[] args) {
		Persona p1 = new Persona("Maria", 54);
		Persona p2 = new Persona("Vila", 55);
		Persona p3 = new Persona("Yago", 27);
		Persona p4 = new Persona("Claudia", 23);
		Persona p5 = new Persona("Abuela", 94);
		List<Persona> personas = Arrays.asList(p1,p2,p3,p4,p5);
		
		Persona menor = personas.stream().min(Comparator.comparing(Persona::getEdad)).orElse(null);
		
		System.out.println("Nombre: "+menor.getNombre()+" \nEdad: "+menor.getEdad());
	}
}
