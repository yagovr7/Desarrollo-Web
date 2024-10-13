package StreamMap;

public class Persona {
	private String nombre;
	private int edad;
	private String apellido;
	
	public Persona(String nombre, int edad, String apellido) {
		this.nombre = nombre;
		this.edad = edad;
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
