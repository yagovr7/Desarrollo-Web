package AbstractoEjercicio6;

public class Main {
	public static void main(String[] args) {
		Triangulo tr = new Triangulo(15,20,"Amarillo");
		Circulo ci = new Circulo(20,"Azul");
		
		System.out.println("Area Cuadrado: "+Math.round(tr.area()));
		System.out.println("Area Circulo: "+Math.round(ci.area()));
	}
}
