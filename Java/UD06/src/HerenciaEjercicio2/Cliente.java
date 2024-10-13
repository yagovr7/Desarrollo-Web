package HerenciaEjercicio2;

public class Cliente extends Persona{
	private int deuda;

	public int getDeuda() {
		return deuda;
	}

	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}
	
	Cliente(String dni, String nombre, String direccion, int deuda){
		super(dni, nombre, direccion);
		this.deuda = deuda;
		System.out.println("Deuda: "+getDeuda()+" €");
	}
}
