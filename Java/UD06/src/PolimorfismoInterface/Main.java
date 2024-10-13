package PolimorfismoInterface;

public class Main {
	public static void main(String[] args) {
        MiInterface tri = new Triangulo();
        MiInterface cua = new Cuadrado();
        tri.calcularArea();
        cua.calcularArea();
    }
}
