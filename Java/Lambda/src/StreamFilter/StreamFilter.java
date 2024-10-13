package StreamFilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamFilter {
	public static boolean buenosLibros(Libro libro) {
        Predicate <Libro> p1 = (Libro l) -> l.getGenero().equals("ciencia ficcion");
        Predicate <Libro> p2 = (Libro l) -> l.getGenero().equals("fantasia");
        Predicate <Libro> p3 = (Libro l) -> l.getPaginas() > 1000;
        Predicate <Libro> ptotal = p1.or(p2).and(p3);
        return ptotal.test(libro);
    }
	public static void main(String[] args) {
		Libro l = new Libro("El señor de los anillos", "fantasia", 1100);
		Libro l2 = new Libro("El Juego de Ender", "ciencia ficcion", 500);
		Libro l3 = new Libro("La fundacion", "ciencia ficcion", 500);
		Libro l4 = new Libro("Los pilares de la tierra", "historica", 1200);
		List <Libro> lista = Arrays.asList(l, l2, l3, l4);
		
		lista.stream()
		.filter(libro -> libro.getPaginas() > 1000)
		.map(libro -> libro.getTitulo())
		.forEach(System.out::println);
		
		System.out.println(buenosLibros(l));
		
		
		System.out.println(lista.stream().filter(x -> x.getPaginas() < 1000).count());
		}
}
