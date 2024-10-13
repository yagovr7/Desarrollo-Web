package Podcast;

public class Autor {
	private int idAutor;
	private String dni;
	private String apellidos;
	private String nombre;
	Podcast podcast;
	
	Autor(){
		this.idAutor = 0;
		this.dni = null;
		this.apellidos = null;
		this.nombre = null;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
