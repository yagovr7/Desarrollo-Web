package Ejercicio4;

public class Punto {
	int x = 0;
    int y = 0;
    Punto(int x, int y) throws Exception{
    	if(x<0||y<0) {
    		throw new Exception("No se puede crear una figura de color blanco.");
    	}
        this.x = x;
        this.y = y;
    }
}
