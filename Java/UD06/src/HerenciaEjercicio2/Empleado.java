package HerenciaEjercicio2;

public class Empleado extends Persona{
	private int sueldo;

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	
	Empleado(String dni, String nombre, String direccion, int sueldo){
		super(dni, nombre, direccion);
		this.sueldo = sueldo;
		System.out.println("Sueldo: "+getSueldo()+" €");
	}
}
