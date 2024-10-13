package Podcast;

public class Generos {
	private int idGeneros;
	private String nombre;
	
	Generos(){
		this.idGeneros = 0;
		this.nombre = null;
	}

	public int getIdGeneros() {
		return idGeneros;
	}

	public void setIdGeneros(int idGeneros) {
		this.idGeneros = idGeneros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
