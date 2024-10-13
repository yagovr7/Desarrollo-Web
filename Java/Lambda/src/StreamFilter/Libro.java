package StreamFilter;

public class Libro {
	private String titulo;
	private String genero;
	private int paginas;
	
	public Libro(String titulo, String genero, int paginas) {
		this.titulo = titulo;
		this.genero = genero;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	
}
