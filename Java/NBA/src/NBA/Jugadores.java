package NBA;

import java.io.Serializable;

public class Jugadores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int dorsal;
	private double salario;
	
	Jugadores(String nombre, int dorsal, double salario) throws Exception{
		if(salario<0) {
			throw new Exception("El salario debe ser positivo");
		}else {
			this.salario = salario;
		}
		this.nombre = nombre;
		if(dorsal<0||dorsal>100) {
			throw new Exception("El dorsal debe estar entre 0 y 100");
		}else {
			this.dorsal = dorsal;
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
	
}
