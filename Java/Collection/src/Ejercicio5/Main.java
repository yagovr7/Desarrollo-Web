package Ejercicio5;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void filterRange(List<Integer> enteros, int min, int max) {
		for(int i = 0;i<enteros.size();i++) {
			if(enteros.get(i)>=min&&enteros.get(i)<=max) {
				enteros.remove(i);
				i=0;
			}
		}
		
		for(Integer x: enteros) {
			System.out.print(x+" ");
		}
	}
	
	public static void main(String[] args) {
		List<Integer> enteros = new ArrayList<>();
		enteros.add(4);
		enteros.add(7);
		enteros.add(9);
		enteros.add(2);
		enteros.add(7);
		enteros.add(7);
		enteros.add(5);
		enteros.add(3);
		enteros.add(5);
		enteros.add(1);
		enteros.add(7);
		enteros.add(8);
		enteros.add(6);
		enteros.add(7);
		
		Main.filterRange(enteros, 5, 7);
		
		
	}
}
