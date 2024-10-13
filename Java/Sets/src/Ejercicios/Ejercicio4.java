package Ejercicios;
import java.util.Iterator;
import java.util.TreeSet;

public class Ejercicio4 {
	public static void main(String[] args) {
		int random;
		TreeSet<Integer> numeros = new TreeSet<>();
		Iterator<Integer> it = numeros.iterator();
		for(int i = 0;i<50;i++) {
			random = (int)Math.floor(Math.random()*100+1);
			numeros.add(random);
		}
		
		System.out.println(numeros);
	}
}
