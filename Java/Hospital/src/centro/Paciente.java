package centro;

import java.io.Serializable;
import java.time.LocalDate;

public class Paciente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String codigoHospital = "HSant01";
	private int dni;
	private Sexo sexo;
	private Nivel nivel;
	private int grado;
	private LocalDate ingreso;
	private int numHabitacion;
	
	public Paciente(int dni, Sexo sexo, int grado, int numHabitacion) {
		this.dni = dni;
		this.setSexo(sexo);
		this.nivel = Nivel.No_Urgente;
		this.ingreso = null;
		this.numHabitacion = numHabitacion;
		this.grado = grado;
	}
	
	public Paciente(int dni, Sexo sexo, int grado) {
		this.dni = dni;
		this.setSexo(sexo);
		this.nivel = Nivel.Urgente;
		this.ingreso = LocalDate.now();
		this.numHabitacion = 0;
		this.grado = grado;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public LocalDate getIngreso() {
		return ingreso;
	}

	public void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public String getCodigoHospital() {
		return codigoHospital;
	}

	public Sexo getSexo() {
		return sexo;
		
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
		
	}
	
	public static char letraDNI(int num) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = num % 23;
		char letra = letras.charAt(resto);
		return letra;
	}
	
	public String toString() {
		if(this.nivel.equals(Nivel.Urgente)) {
			return "DNI: "+dni+letraDNI(dni)+"\nSexo: "+sexo+"\nNivel: "+nivel+"\nGrado: "+grado+"\nIngreso: "+ingreso;
		}else {
			return "DNI: "+dni+letraDNI(dni)+"\nSexo: "+sexo+"\nNivel: "+nivel+"\nGrado: "+grado+"\nNumero de habitación: "+numHabitacion;
		}
		
	}
}
