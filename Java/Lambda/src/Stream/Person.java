package Stream;

public class Person {
	private String nombre;
	private int edad;
	
	Person(String n, int e){
		this.nombre = n;
		this.edad = e;
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
	
	
}
