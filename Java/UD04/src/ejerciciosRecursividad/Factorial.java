package ejerciciosRecursividad;

public class Factorial {
	int calcularFactorial(int n) {
		if(n==0) {
		return 1;
		}else {
			return n*calcularFactorial(n-1);
		}
		
	}
}
