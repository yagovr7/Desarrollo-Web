package libros;
import java.util.Scanner;
public class Libro {
	private int ISBN;
	private String titulo;
	private String autor;
	private int n_paginas;
	private static Scanner sc;
	
	public Libro() {
		this.ISBN=0;
		this.titulo="";
		this.autor="";
		this.n_paginas=0;

		

	}
	
	public Libro(int ISBN, String titulo, String autor, int n_paginas) {
		this.setISBN(ISBN);
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setN_paginas(n_paginas);
		
	}
	

	public int getISBN() {
		return ISBN;
		
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
		
	}

	public String getTitulo() {
		return titulo;
		
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
		
	}

	public String getAutor() {
		return autor;
		
	}

	public void setAutor(String autor) {
		this.autor = autor;
		
	}

	public int getN_paginas() {
		return n_paginas;
		
	}

	public void setN_paginas(int n_paginas) {
		this.n_paginas = n_paginas;
		
	}
	
	public String toString() {
		
		return "ISBN: "+ISBN+"\nTítulo: "+titulo+"\nAutor: "+autor+"\nNumero de Páginas: "+n_paginas;
	}
	
	public void comparar(Libro libro2) {
		if(this.n_paginas>libro2.n_paginas) {
			System.out.println("El libro con Titulo "+this.titulo+" tiene más páginas que "+libro2.titulo);
		}else {
			System.out.println("El libro con Titulo "+libro2.titulo+" tiene más páginas que "+this.titulo);
		}
	}
	
	
	public static void main(String []args) {
		sc = new Scanner(System.in);
		
		Libro libro1 = new Libro();
		System.out.println("Introduce el ISBN");
		libro1.ISBN = sc.nextInt();
		
		System.out.println("Introduce el Titulo");
		libro1.titulo = sc.next();
		
		sc.nextLine();

		System.out.println("Introduce el Autor");
		libro1.autor = sc.next();

		

		System.out.println("Introduce el Nº paginas");
		libro1.n_paginas = sc.nextInt();
		
		Libro libro2 = new Libro(123456, "Cervantes", "Yago", 180);

		System.out.println("Libro dado de ALTA\n"+libro1.toString());
		
		libro1.comparar(libro2);
		
	}
	
	
}
