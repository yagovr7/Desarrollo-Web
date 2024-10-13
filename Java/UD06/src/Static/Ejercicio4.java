package Static;

public class Ejercicio4 {
	static int sqrt(int a){
		int resultado=(int) Math.sqrt(a);
		return resultado;
		
	}
	
	static int pow(int a, int b){
		int resultado=(int) Math.pow(a, b);
		return resultado;
		
	}
	
	public static void main(String[] args) {
		System.out.println("Math.sqrt(25): "+Ejercicio4.sqrt(25));
		System.out.println("Math.pow(2,8): "+Ejercicio4.pow(2,8));
	}
}
