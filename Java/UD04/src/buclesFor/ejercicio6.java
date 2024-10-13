package buclesFor;

public class ejercicio6 {
	public static void main(String []args) {
		System.out.println("Números impares hasta 100:");
		int acumulador = 0;
		for(int i = 0;i<=100;i++) {
			if(i%2!=0) {
				System.out.println(i);
				acumulador++;
			}
		}System.out.println("Total de números impares: "+acumulador);
	}
}
