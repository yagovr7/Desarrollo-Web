package ArrayList;
import java.util.*;
public class Libro {
	String id;
	String titulo;
	String autor;
	Libro(String id, String titulo, String autor){
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
	}
	public static void main(String[] args) {
		Libro libro1 = new Libro("0345404475", "Do Androids Dream of Electric Sheep?", "Philip K.Dick");
		Libro libro2 = new Libro("0451457998", "2001: A Space Odissey", "Arthur C. Clarke");
		List<Libro> lista = new ArrayList<>();
		lista.add(libro1);
		lista.add(libro2);
		Iterator<Libro> it = lista.iterator(); // Iterator que apuntará al inicio de la colección
		while(it.hasNext()) { // mientras haya "siguiente" elemento...
		    Libro libro = it.next(); // leemos el "siguiente" elemento
		    System.out.println("Título: " + libro.titulo);
		}
	}
}
