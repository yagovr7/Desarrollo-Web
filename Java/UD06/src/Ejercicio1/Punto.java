package Ejercicio1;

public class Punto {
	
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	Punto(){
		this.x = 0;
		this.y = 0;
	}
	
	Punto(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void desplazar(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	public boolean puntosIguales(Punto p) {
		return this.x == p.x && this.y == p.y;
	}
	
	
}
