package Ejercicio4;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void markLength4(List<String> x) {
		for(int i = 0;i<x.size();i++) {
			if(x.get(i).length()==4) {
				x.add(i,"****");
				i+=1;
			}
		}
		
		for(String j: x) {
			System.out.print(j+" ,");
		}
	}
	
	public static void main(String[] args) {
		List<String> cadena = new ArrayList<>();
		cadena.add("this");
		cadena.add("is");
		cadena.add("lots");
		cadena.add("of");
		cadena.add("fun");
		cadena.add("for");
		cadena.add("every");
		cadena.add("Java");
		cadena.add("programmer");

		Main.markLength4(cadena);
	}
}
