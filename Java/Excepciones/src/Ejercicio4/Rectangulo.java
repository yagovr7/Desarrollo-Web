package Ejercicio4;

public class Rectangulo {
	Punto origen;
    int ancho;
    int alto;
    Rectangulo(int x, int y, int w, int h) throws Exception{
        origen = new Punto(x,y);
        ancho = w;
        alto = h;
    }
}
