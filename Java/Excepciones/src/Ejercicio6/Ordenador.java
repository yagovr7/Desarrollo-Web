package Ejercicio6;

public class Ordenador {
	
	private Procesador procesador;
	private Memoria memoria;
	private DiscoDuro discoduro;
	private String numeroDeSerie;
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
	
	



	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}



	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}



	public Ordenador(String numeroDeSerie,int capacidadMemoria,String tipMemoria,int velocidadMemoria,float capacidadDisco,String tipoDisco,int velocidadDisco,String tipoProcesador,float velocidadProcesador,int precio)throws OrdenadorException{
		if(tipoProcesador=="i7"&&tipoDisco!="SATA3") {
			throw new OrdenadorException(numeroDeSerie+": "+tipoProcesador+" sin "+tipoDisco+" no se monta");
		}
		if(numeroDeSerie.contains("HP")&&capacidadMemoria<4) {
			throw new OrdenadorException("Serie "+numeroDeSerie.substring(0, 2)+" no puede tener menos de 4gb de memoria");
		}
		this.numeroDeSerie = numeroDeSerie;
		memoria = new Memoria(capacidadMemoria, velocidadMemoria, tipMemoria);
		discoduro = new DiscoDuro(capacidadDisco, tipoDisco, velocidadDisco);
		procesador = new Procesador(tipoProcesador, velocidadProcesador);
		this.pvp = precio;
		cont++;
	}
	
}
