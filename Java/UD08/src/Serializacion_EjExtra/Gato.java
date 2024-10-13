package Serializacion_EjExtra;

public class Gato extends Animal{
	private String bigotes;
	
	public String getBigotes() {
		return bigotes;
	}

	public void setBigotes(String bigotes) {
		this.bigotes = bigotes;
	}

	Gato(String n, int e, String b){
		super(n, e);
		this.bigotes = b;
	}
	
	public String habla() {
		return "MIAU";
	}
}
