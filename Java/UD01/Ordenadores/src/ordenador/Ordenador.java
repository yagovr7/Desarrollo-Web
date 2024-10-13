package ordenador;

public class Ordenador {
	
	private Procesador procesador;
	private Memoria memoria;
	private DiscoDuro discoduro;
	private int pvp;
	private static int cont = 0;
	
	
	
	public Procesador getProcesador() {
		return procesador;
	}



	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}



	public DiscoDuro getDiscoduro() {
		return discoduro;
	}



	public void setDiscoduro(DiscoDuro discoduro) {
		this.discoduro = discoduro;
	}



	public int getPvp() {
		return pvp;
	}



	public void setPvp(int pvp) {
		this.pvp = pvp;
	}



	public static int getCont() {
		return cont;
	}



	public static void setCont(int cont) {
		Ordenador.cont = cont;
	}



	public void setMemoria(Memoria memoria) {
		this.memoria = memoria;
	}



	public Memoria getMemoria() {
		return memoria;
	}



	public Ordenador(int capacidadMemoria,String tipMemoria,int velocidadMemoria,float capacidadDisco,String tipoDisco,int velocidadDisco,String tipoProcesador,float velocidadProcesador,int precio){
		
		memoria = new Memoria(capacidadMemoria, velocidadMemoria, tipMemoria);
		discoduro = new DiscoDuro(capacidadDisco, tipoDisco, velocidadDisco);
		procesador = new Procesador(tipoProcesador, velocidadProcesador);
		this.pvp = precio;
		cont++;
	}
	
}
