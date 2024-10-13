package PolimorfismoEjercicio3;

import java.math.BigDecimal;

public class Jefe extends Tripulante{
	private int pesoPescado;
	private int pesoMarisco;
	private static final int sueldo = 350000000;
	private float sueldoTotal;
	private float bonoPescado = pesoPescado*1;
	private float bonoMarisco = pesoMarisco*2;
	 
	Jefe(int dni, int posicion,int edad, int experiencia, String nombre, String telefono, char sexo, int pesoPescado, int pesoMarisco){
		super(dni, posicion, edad, experiencia, nombre, telefono, sexo);
		this.pesoPescado = pesoPescado;
		this.pesoMarisco = pesoMarisco;
	}
	
	public int getPesoPescado() {
		return pesoPescado;
	}


	public void setPesoPescado(int pesoPescado) {
		this.pesoPescado = pesoPescado;
	}


	public int getPesoMarisco() {
		return pesoMarisco;
	}


	public void setPesoMarisco(int pesoMarisco) {
		this.pesoMarisco = pesoMarisco;
	}


	public int getSueldo() {
		return sueldo;
	}
	
	public float getBonoMarisco() {
		return bonoMarisco;
	}

	public void setBonoMarisco(float bonoMarisco) {
		this.bonoMarisco = bonoMarisco;
	}

	public float getBonoPescaddo() {
		return bonoPescado;
	}

	public void setBonoPescaddo(float bonoPescaddo) {
		this.bonoPescado = bonoPescaddo;
	}
	
	public float getSueldoTotal() {
		return sueldoTotal;
		
	}

	public void setSueldoTotal(float sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
		
	}


	public void datos() {
		System.out.println("DATOS DEL JEFE");
		String letras ="TRWAGMYFPDXBNJZSQVHLCKE";
		int resto =this.getDni()%23;
		char resultado = letras.charAt(resto);
		System.out.println("DNI: "+this.getDni()+""+resultado);
		System.out.println("Edad: "+this.getEdad()+" años");
		System.out.println("Nombre: "+this.getNombre());
		System.out.println("Telefono: "+this.getTelefono());
		System.out.println("Sexo: "+this.getSexo());
		System.out.println("Años de experiencia: "+this.getExperiencia());
		this.calcularBono();
		BigDecimal bd = new BigDecimal(this.sueldoTotal());
		System.out.println("Sueldo Total: "+bd+"€");
		System.out.println("Posicion GPS: ");
	}
	
	public double sueldo() {
		return this.getSueldo();
	}
	
	public void calcularBono() {
		this.bonoPescado = this.pesoPescado*1;
		this.bonoMarisco = this.pesoMarisco*2;
		System.out.println("Bono Pescado: "+this.bonoPescado+"€");
		System.out.println("Bono Marisco: "+this.bonoMarisco+"€");
	}
	
	public float sueldoTotal() {
		this.sueldoTotal = this.getSueldo()+(this.bonoPescado+this.bonoMarisco);
		return this.sueldoTotal;
	}

	

	

}
