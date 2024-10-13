package HerenciaEjercicios1;

public class Portatil extends Ordenador{
	private int peso;
	
	
	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	Portatil(String cpu, int ram, int peso){
		super(cpu, ram);
		this.peso = peso;
		System.out.println("Portatil");
		System.out.println("CPU: "+getProcesador());
		System.out.println("Memoria: "+getMemoria()+" GB");
		System.out.println("Peso: "+getPeso()+" Kg");
	}
}
