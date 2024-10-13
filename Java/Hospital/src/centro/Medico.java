package centro;

import java.io.Serializable;
import java.util.TreeMap;

public class Medico implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dni;
	private String nombre;
	private String apellidos;
	
	TreeMap<Integer, Paciente> pacientes = new TreeMap<>();
	
	Medico(int d, String n, String a){
		this.dni = d;
		this.nombre = n;
		this.apellidos = a;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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
	
	public static char letraDNI(int num) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = num % 23;
		char letra = letras.charAt(resto);
		return letra;
	}

	public String toString() {
		return "DNI: "+dni+letraDNI(dni)+" \nNombre: "+nombre+" \nApellidos: "+apellidos;
	}
}
