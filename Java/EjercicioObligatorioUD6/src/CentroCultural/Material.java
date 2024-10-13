package CentroCultural;

public abstract class Material {
	private int codigo;
	private String titulo;
	private int estanteria;
	private int altura;
	private String autor;
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getEstanteria() {
		return estanteria;
	}
	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	Material(){
		this.codigo = 0;
		this.titulo = null;
		this.estanteria = 0;
		this.altura = 0;
		this.autor = null;
	}
	Material(int codigo, String titulo, int estanteria, int altura, String autor){
		this.codigo = codigo;
		this.titulo = titulo;
		this.estanteria = estanteria;
		this.altura = altura;
		this.autor = autor;
	}
	
	public abstract void informacion();
}
