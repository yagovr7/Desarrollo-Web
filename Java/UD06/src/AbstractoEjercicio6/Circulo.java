package AbstractoEjercicio6;

public class Circulo extends Figura{
	
	private double radio;
	
	Circulo(double radio, String color){
		super(color);
		this.radio = radio;
	}
	
	public double area() {
		return Math.PI*(Math.pow(this.radio, 2));
	}
}
