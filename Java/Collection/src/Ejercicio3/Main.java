package Ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void minToFront(List<Integer> x) {
		int posicion = x.indexOf(Collections.min(x));
		x.add(0, Collections.min(x));
		x.remove(posicion+1);
		for(Integer i: x) {
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(3);
		numeros.add(8);
		numeros.add(92);
		numeros.add(4);
		numeros.add(2);
		numeros.add(17);
		numeros.add(9);
		
		Main.minToFront(numeros);
		
		
		
	}
}
