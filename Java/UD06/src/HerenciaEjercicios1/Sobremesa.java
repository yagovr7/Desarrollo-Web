package HerenciaEjercicios1;

public class Sobremesa extends Ordenador{
	private String tipoCaja;
	
	
	public String getTipoCaja() {
		return tipoCaja;
	}


	public void setTipoCaja(String tipoCaja) {
		this.tipoCaja = tipoCaja;
	}


	Sobremesa(String cpu, int ram, String tipoCaja){
		super(cpu, ram);
		this.tipoCaja = tipoCaja;
		System.out.println("Sobremesa");
		System.out.println("CPU: "+getProcesador());
		System.out.println("Memoria: "+getMemoria()+" GB");
		System.out.println("Caja: "+getTipoCaja());
	}
}
