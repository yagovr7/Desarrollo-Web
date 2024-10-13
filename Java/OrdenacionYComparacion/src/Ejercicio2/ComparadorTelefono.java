package Ejercicio2;
import java.util.Comparator;

public class ComparadorTelefono implements Comparator<String>{

	public int compare(String o1, String o2) {

		return o2.compareTo(o1);
	}
	
}
