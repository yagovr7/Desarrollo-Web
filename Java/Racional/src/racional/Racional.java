package racional;

public class Racional {
	protected int numerador;
	protected int denominador;
	
	public Racional(int numerador,int denominador) {
		 this.numerador=numerador;
		 this.denominador=denominador;
	}
	
	public void multiplicar(Racional r1, Racional r2){
		 this.numerador=r1.numerador*r2.numerador;
		 this.denominador=r1.denominador*r2.denominador;
	}
	
	public String toString(){
		 return numerador + "/" + denominador;
	}
	
	public static void main(String[] args) {
		System.out.println("Hola");
	}
}
