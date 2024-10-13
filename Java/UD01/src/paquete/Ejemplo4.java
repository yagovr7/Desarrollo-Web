package paquete;

public class Ejemplo4 {
	public static void main(String args[]){
		 int x=10;
		 int y=20;
		 int z=5;
		 final int MICONSTANTE = 1000;
		 System.out.println("Valor de la constante: " +MICONSTANTE);
		 System.out.println("ANTES. x vale "+ x + " y vale "+y );
		 //……..instrucciones que realizan el intercambio de valores
		 z=x;
		 x=y;
		 y=z;
		 System.out.println("DESPUES. x vale "+ x + " y vale "+ y );
	 }
}