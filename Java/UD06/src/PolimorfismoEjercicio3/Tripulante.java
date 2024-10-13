package PolimorfismoEjercicio3;

public abstract class Tripulante{
	private int dni;
	private int edad;
	private int posicion;
	private int experiencia;
	private String nombre;
	private String telefono;
	private char sexo;
	Barco barco;
	GPS gps;
	
	Tripulante(int dni, int posicion, int edad, int experiencia, String nombre, String telefono, char sexo){
		this.dni = dni;
		this.edad = edad;
		this.experiencia = experiencia;
		this.nombre = nombre;
		this.telefono = telefono;
		this.sexo = sexo;
		this.setPosicion(posicion);
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
	public abstract double sueldo();
	public abstract void datos();

	

}

	