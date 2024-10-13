package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		Divisor d = num -> {
			for(int i = 2; i<= Math.sqrt(num); i++) {
				if(num%i==0) {
					return i;
				}
			}return num;
		};
		System.out.println("El divisor más pequeño de 15 es: "+d.divisor(15));
		System.out.println("El divisor más pequeño de 12 es: "+d.divisor(12));
		
	}
}
