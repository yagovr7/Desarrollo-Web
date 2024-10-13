package HerenciaEjercicios1;

public class Ordenador {
	
	private String procesador;
	private int memoria;	
	
	

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public int getMemoria() {
		return memoria;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public Ordenador() {
		
	}

	public Ordenador(String cpu, int ram){
		this.memoria = ram;
		this.procesador = cpu;
	}
}
