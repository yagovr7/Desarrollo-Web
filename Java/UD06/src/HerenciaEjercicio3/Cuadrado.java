package HerenciaEjercicio3;

public class Cuadrado extends Figura{
	private double lado;

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public Cuadrado(double lado, String color){
		this.lado = lado;
		this.setColor(color);
	}

}
