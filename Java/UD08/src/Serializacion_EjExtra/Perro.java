package Serializacion_EjExtra;

public class Perro extends Animal{
	private String rabo;
	
	public String getRabo() {
		return rabo;
	}

	public void setRabo(String rabo) {
		this.rabo = rabo;
	}

	Perro(String n, int e, String r){
		super(n, e);
		this.rabo = r;
	}
	
	public String habla() {
		return "GUAU";
	}
	
}
