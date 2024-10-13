package PolimorfismoEjercicio3;

public class Capitan extends Tripulante{
	private int horas;
	private static final int sueldo = 4500000;
	private float sueldoTotal;
	private float bono;
	
	Capitan(int dni, int posicion, int edad, int experiencia, String nombre, String telefono, char sexo, int horas){
		super(dni, posicion, edad, experiencia, nombre, telefono, sexo);
		this.horas = horas;
		this.bono = 0;
		this.setSueldoTotal(0);
	}
	
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public float getBono() {
		return bono;
	}

	public void setBono(float bono) {
		this.bono = bono;
	}

	public int getSueldo() {
		return sueldo;
	}

	
	public float getSueldoTotal() {
		return sueldoTotal;
		
	}

	public void setSueldoTotal(float sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
		
	}

	public void datos() {
		System.out.println("*CAPITÁN*");
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
		if(this.horas>=5000 && this.horas<150000) {
			this.bono = 20;
		}else if(this.horas>=150000 && this.horas<300000) {
			this.bono = 40;
		}else if(this.horas>300000) {
			this.bono = 75;
		}
		return this.bono;
	}
	
	public float sueldoTotal() {
		this.sueldoTotal = this.getSueldo()+((this.getSueldo()*(int)this.calcularBono())/100);
		return this.getSueldoTotal();
	}

	

}
