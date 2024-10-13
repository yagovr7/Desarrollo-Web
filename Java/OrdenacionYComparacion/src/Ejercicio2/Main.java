package Ejercicio2;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("981555555");
		list.add("+34981565656");
		list.add("666666666");
		list.add("+34666666666");
		
		Collections.sort(list, new ComparadorTelefono());
		
		list.forEach(s -> System.out.print(s+" "));
	}
}
