package PolimorfismoEjercicio3;

public class Marinero extends Tripulante{
	private int totalPescado;
	private static final float sueldo = 90000;
	private float sueldoTotal;
	private float bono;
	
	
	Marinero(int dni, int posicion, int edad, int experiencia, String nombre, String telefono, char sexo, int totalPescado){
		super(dni, posicion, edad, experiencia, nombre, telefono, sexo);
		this.totalPescado = totalPescado;
		this.sueldoTotal = 0;
		this.bono = 0;
	}
	
	
	public int getTotalPescado() {
		return totalPescado;
	}


	public void setTotalPescado(int totalPescado) {
		this.totalPescado = totalPescado;
	}


	public float getSueldoTotal() {
		return sueldoTotal;
	}


	public void setSueldoTotal(float sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
	}


	public float getBono() {
		return bono;
	}


	public void setBono(float bono) {
		this.bono = bono;
	}


	public  float getSueldo() {
		return sueldo;
	}


	public void datos() {
		System.out.println("*MARINERO*");
		String letras ="TRWAGMYFPDXBNJZSQVHLCKE";
		int resto =this.getDni()%23;
		char resultado = letras.charAt(resto);
		System.out.println("DNI: "+this.getDni()+""+resultado);
		System.out.println("Edad: "+this.getEdad()+" años");
		System.out.println("Nombre: "+this.getNombre());
		System.out.println("Telefono: "+this.getTelefono());
		System.out.println("Sexo: "+this.getSexo());
		System.out.println("Años de experiencia: "+this.getExperiencia());
		System.out.println("Bono: "+(int)this.calcularBono()+"%");
		System.out.println("Sueldo Total: "+this.sueldoTotal()+"€");
		System.out.println("Posicion GPS: ");
	}
	
	public double sueldo() {
		return this.getSueldo();
	}
	
	public float calcularBono() {
		if(this.totalPescado>=1) {
			this.bono = (float) (this.totalPescado*0.25);
		}
		return bono;
	}
	
	public float sueldoTotal() {
		this.sueldoTotal = (float) (((this.getSueldo()*this.bono)/100)+this.sueldo());
		return this.sueldoTotal;
	}

}
