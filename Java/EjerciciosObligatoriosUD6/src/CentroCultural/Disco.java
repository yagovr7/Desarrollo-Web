package CentroCultural;

public class Disco extends Material {
	
	private String discografia;
	
	
	
	public String getDiscografia() {
		return discografia;
	}

	public void setDiscografia(String discografia) {
		this.discografia = discografia;
	}

	Disco(){
		super();
		this.discografia = null;
		
	}
	
	Disco(int codigo, String titulo, int estanteria, int altura, String autor, String discografia){
		super(codigo, titulo, estanteria, altura, autor);
		this.discografia = discografia;
	}

	public void informacion() {
		
			System.out.println("DISCO");
			System.out.println("Codigo: "+this.getCodigo());
			System.out.println("Titulo: "+this.getTitulo());
			System.out.println("Autor: "+this.getAutor());
			System.out.println("Estanteria: "+this.getEstanteria());
			System.out.println("Altura: "+this.getAltura());
			System.out.println("Discografica: "+this.getDiscografia());
		
		
	}
}
