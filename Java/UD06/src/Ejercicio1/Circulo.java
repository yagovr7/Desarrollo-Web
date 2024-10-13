package Ejercicio1;

public class Circulo {
	private Punto centro;
	private int radio;
	
	
	
	public Punto getCentro() {
		return centro;
	}



	public void setCentro(Punto centro) {
		this.centro = centro;
	}



	public int getRadio() {
		return radio;
	}



	public void setRadio(int radio) {
		this.radio = radio;
	}



	Circulo(int radio, Punto centro){
		this.radio = radio;
		this.centro = centro;
	}
		
}
