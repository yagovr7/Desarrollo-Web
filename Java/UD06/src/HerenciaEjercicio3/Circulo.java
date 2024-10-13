package HerenciaEjercicio3;

public class Circulo extends Figura{
	private double radio;

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public Circulo(double radio, String color){
		this.radio = radio;
		this.setColor(color);
	}
}
