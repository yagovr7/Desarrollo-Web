package Ejercicios;
import java.util.HashSet;
import java.util.Iterator;

public class Ejercicio1 {
	public static int maxLength(HashSet<String> x) {
		int max = 0;
		String word = "";
		Iterator<String> it = x.iterator();
		/*if(x.isEmpty()) {
			return 0;
		}*/
		while(it.hasNext()) {
			//if(it.next().length()>word.length()) {
				//word = it.next();
				max = Math.max(max, it.next().length());
			}
		return max;
	}
	
	public static boolean hasOdd(HashSet<Integer> x) {
		Iterator<Integer> it = x.iterator();
		while(it.hasNext()) {
			if(it.next()%2!=0) {
				return true;
			}
		}
		return false;
	}
	
	public static void removeEvenLength(HashSet<String> x) {
		Iterator<String> it = x.iterator();
		while(it.hasNext()) {
			if(it.next().length()%2==0) {it.remove();}
		}
	}
	
	public static void main(String[] args) {
		HashSet<String> cadenas = new HashSet<String>();
		cadenas.add("");
		cadenas.add("Rust");
		cadenas.add("Rainbow");
		cadenas.add("Pubg");
		
		System.out.println("maxLength: "+Ejercicio1.maxLength(cadenas));
		
		HashSet<Integer> enteros = new HashSet<Integer>();
		enteros.add(2);
		enteros.add(4);
		enteros.add(6);
		enteros.add(7);
		
		System.out.println("HashSet contiene impares: "+Ejercicio1.hasOdd(enteros));
		
		HashSet<String> words = new HashSet<String>();
		words.add("Yago");
		words.add("Claudia");
		words.add("Mateo");
		words.add("Izan");
		
		Ejercicio1.removeEvenLength(words);
		System.out.println(words);
		
		
		
		
		
		
		
		
		
		
		
	}
}
