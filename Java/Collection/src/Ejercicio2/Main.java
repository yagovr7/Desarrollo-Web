package Ejercicio2;
import java.util.*;

public class Main {
	public static void swapParis(List<String> x) {
		String s;
		for(int i = 0;i<x.size()-1;i+=2) {
			s = x.get(i);
			x.set(i, x.get(i+1));
			x.set(i+1, s);
		}
		
		x.forEach(j -> System.out.print(j+" "));
	}
		
	public static void main(String[] args) {
		List<String> hermanos = new ArrayList<>();
		hermanos.add("Yago");
		hermanos.add("Sergio");
		hermanos.add("Ruben");
		hermanos.add("Mateo");
		hermanos.add("Izan");
		
		Main.swapParis(hermanos);
			
	}
}