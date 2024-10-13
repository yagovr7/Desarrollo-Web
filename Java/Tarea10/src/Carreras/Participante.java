package Carreras;


public class Participante {
	private String nombre;
	private String apellidos;
	private Sexo sexo;
	private int edad;
	private Categoria categoria;
	
	public Participante(String nombre, String apellidos, String sexo, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		if(sexo=="H") {
			this.sexo = Sexo.Hombre;
		}else if(sexo=="M") {
			this.sexo = Sexo.Mujer;
		}
		if(edad<8) {
			this.categoria = Categoria.Benjamin;
		}else if(edad>=8 && edad <=10) {
			this.categoria = Categoria.Alevin;
		}else if(edad>=11 && edad <=12) {
			this.categoria = Categoria.Infantil;
		}else if(edad>=13 && edad <=14) {
			this.categoria = Categoria.Cadete;
		}else if(edad>=15 && edad <=18) {
			this.categoria = Categoria.Xuvenil;
		}else if(edad>=19 && edad <=30) {
			this.categoria = Categoria.Senior;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String toString() {
		return "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nSexo: " + sexo + "\nEdad: " + edad
				+ "\nCategoria: " + categoria;
	}
	
	
	
}
