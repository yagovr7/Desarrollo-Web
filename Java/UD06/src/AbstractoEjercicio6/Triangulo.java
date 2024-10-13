package AbstractoEjercicio6;

public class Triangulo extends Figura {
	
	private double base;
	private double altura;
	
	Triangulo(double base, double altura, String color){
		super(color);
		this.base = base;
		this.altura = altura;
	}
	
	public double area() {
		return (this.base*this.altura)/2;
	}
}
