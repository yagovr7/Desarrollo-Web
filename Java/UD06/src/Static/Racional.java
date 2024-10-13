package Static;
/*
public class Racional {
		 int numerador;
		 int denominador;
		 Racional(int numerador, int denominador){
		 this.numerador=numerador;
		 this.denominador=denominador;
		 }
	static Racional multiplicar(Racional r1, Racional r2) {
		return new Racional (r1.numerador*r2.numerador, r1.denominador*r2.denominador);
	}
}
*/

class Racional{
	 private int numerador;
	 private int denominador;
	 Racional(int numerador, int denominador){
	 this.numerador=numerador;
	 this.denominador=denominador;
	 }
	 public static Racional multiplicar(Racional r1, Racional r2){
	 Racional resultado= new Racional(1,1);
	 resultado.numerador=r1.numerador*r2.numerador;
	 resultado.denominador=r1.denominador*r2.denominador;
	 return resultado;
	 }
	public int getNumerador() {
		return numerador;
	}
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}
	 
	}
