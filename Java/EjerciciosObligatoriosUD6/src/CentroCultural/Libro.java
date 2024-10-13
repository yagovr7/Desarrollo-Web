package CentroCultural;

public class Libro extends Material {
	
	 private int num_paginas;
	
	
	
	public int getNum_paginas() {
		return num_paginas;
	}
	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}
	Libro(){
		super();
		this.num_paginas = 0;
		
	}
	Libro(int codigo, String titulo, int estanteria, int altura, String autor, int num_paginas){
		super(codigo, titulo, estanteria, altura, autor);
		this.num_paginas = num_paginas;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Libro) {
			Libro lib = (Libro) obj;
			if(this.getTitulo() == lib.getTitulo() && this.getNum_paginas() == lib.getNum_paginas() ) {
				return true;
			}
		}
		return false;
	}
	
	
	public void informacion() {
		
			System.out.println("LIBRO");
			System.out.println("Codigo: "+this.getCodigo());
			System.out.println("Titulo: "+this.getTitulo());
			System.out.println("Autor: "+this.getAutor());
			System.out.println("Estanteria: "+this.getEstanteria());
			System.out.println("Altura: "+this.getAltura());
			System.out.println("Numero de paginas: "+this.getNum_paginas());

		
	}


	
	
}
