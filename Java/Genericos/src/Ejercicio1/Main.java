package Ejercicio1;

public class Main {
	public static void main(String[] args) {
		
		Numeros<Integer, Integer> p1 = new Numeros(12,12);
		System.out.println(p1.getFirst());
		System.out.println(p1.getSecond());
		
		Numeros<Float, Float> p2 = new Numeros(2.5,3.6);
		System.out.println(p2.getFirst());
		System.out.println(p2.getSecond());
		
		Numeros<String, String> p3 = new Numeros("Yago","Claudia");
		System.out.println(p3.getFirst());
		System.out.println(p3.getSecond());
		
		int[] a = {1,2,3};
		int[] b = {3,2,1};
		Numeros<int[], int[]> p4 = new Numeros(a,b);
		for(int i = 0;i<a.length;i++) {
			System.out.print(p4.getFirst()[i]+" ");
		}
		System.out.println();
		for(int i = 0;i<a.length;i++) {
			System.out.print(p4.getSecond()[i]+" ");
		}
		System.out.println();
		Persona pj = new Persona("Yago",26);
		Persona px = new Persona("Claudia", 23);
		Numeros<Persona, Persona> p5 = new Numeros(pj, px);
		
		System.out.println(p5.getFirst().getNombre());
		System.out.println(p5.getSecond().getNombre());
		
	}
}
