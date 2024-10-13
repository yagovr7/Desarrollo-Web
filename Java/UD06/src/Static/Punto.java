package Static;
//Ejercicio1
class Punto {
	 int x , y ;
	 static int num = 0;

	 Punto ( int x, int y ) {
	 this.x = x ;
	 this.y = y;
	 num++;
	 

	 }
	 
	 public static void main(String[] args) {
		Punto p1 = new Punto(2,4);
		Punto p2 = new Punto(2,4);
		System.out.println("Cantidad de objetos creados: "+Punto.num);
	}
	}

