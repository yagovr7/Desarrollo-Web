package AbstractoEjercicio6;

public abstract class Figura {
	
	protected String color;
	
	Figura(String color){
		this.color = color;
	}
	
	abstract public double area();
}
