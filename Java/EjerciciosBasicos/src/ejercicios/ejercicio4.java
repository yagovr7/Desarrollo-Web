package ejercicios;


public class ejercicio4 {
	public static void main(String []args) {
		int A=1,B=2,C=3,D=4;
		
		System.out.println(
			"Valor inicial de las variables"+
			"\nA = "+A+
			"\nB = "+B+
			"\nC = "+C+
			"\nD = "+D);
		
		System.out.println("Valores finales");
		int Bi = C;
		System.out.println("\nB toma valor de C -> B = "+Bi);
		int Ci = A;
		System.out.println("\nB toma valor de A -> C = "+Ci);
		int Ai = D;
		System.out.println("\nB toma valor de D -> A = "+Ai);
		int Di = B;
		System.out.println("\nB toma valor de B -> D = "+Di);
		
	}
}
