package Ejercicios;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ejercicio5 {
	public static void remove(TreeSet<Integer> x) {
		System.out.println(x.last());
		x.remove(x.last());
	}
	
	public static void main(String[] args) {
		TreeSet<Integer> numeros = new TreeSet<>();
		numeros.add(46);
		numeros.add(87);
		numeros.add(90);
		numeros.add(34);
		numeros.add(23); 
		
		System.out.println(numeros);
		Ejercicio5.remove(numeros);
		System.out.println(numeros);
		/*
		// creating tree map 
	      TreeMap<Integer, Integer> treemap = new TreeMap<Integer, Integer>();

	      // populating tree map
	      treemap.put(1, 46);
	      treemap.put(2, 87);
	      treemap.put(3, 90);
	      treemap.put(4, 34);
	      treemap.put(5, 23);   

	      // polling last entry
	      System.out.println("Value before poll: "+ treemap);            
	      System.out.println("Value returned: "+ treemap.pollLastEntry());      
	      System.out.println("Value after poll: "+ treemap);
		*/
		

	}
}
