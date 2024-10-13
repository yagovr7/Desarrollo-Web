package ArrayList;
import java.util.ArrayList;
import java.util.List;

public class ListasDemo3 {
	public static void main(String[] args) {
	List<String> lista = new ArrayList<>();
	String s = "bye";
	lista.add("hi");
	lista.add(s);
	System.out.println("hello está en la lista? " + lista.contains("hello"));
	System.out.println("bye está en la lista? " + lista.contains("bye"));
	System.out.println(s + " está en la lista? " + lista.contains(s));
	System.out.println("posición de " + s + " en la lista? " + lista.indexOf(s));
		 }
}
