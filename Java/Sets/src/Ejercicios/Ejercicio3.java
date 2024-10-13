package Ejercicios;
import java.util.Arrays;
import java.util.TreeSet;

public class Ejercicio3 {
	public static void main(String[] args) {
		TreeSet<Integer> A = new TreeSet<>();
		A.addAll(Arrays.asList(5,7,9,19));
		TreeSet<Integer> B = new TreeSet<>();
		B.addAll(Arrays.asList(10,20,5,7));
		
		System.out.println("A inicial: "+A);
		System.out.println("B inicial: "+B);
		
		System.out.println();
		//A.retainAll(B);
		//System.out.println("A intersección B: "+A);
		
		//A.removeAll(B);
		//System.out.println("A diferencia B: "+A);
		
		//A.addAll(B);
		//System.out.println("A union B: "+A);
		
		
		
	}
}
