package Ejercicio4;

public class Main {
	public static void main(String[] args) {
		Integer[] matriz = {123,123,123};
		String s = "Hola";
		
		Nodo n1 = new Nodo(s);
		System.out.println(n1.getDato());
		Nodo n2 = new Nodo(matriz);
		for(Integer m:matriz) {
			System.out.println(m);
		}
		
		MiListaEnlazada<Nodo> x = new MiListaEnlazada<>();
		
		x.insertar(n1);
		
		System.out.println(x);
		
		
		
	}
}
