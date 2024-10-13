package HerenciaEjercicio3;

public class Figura {
	private String color;
	
	
	
	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}

	Figura(){
		this.color = null;
	}

	Figura(String color){
		this.color = color;
	}
}
