package ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println("Crear un ArrayList:");
		List<String> listStrings = new ArrayList<String>();
		listStrings.add("One");
		listStrings.add("Two");
		listStrings.add("Three");
		listStrings.add(0,"Four");
		System.out.println(listStrings);
		
		List<Integer> listNumbers = new ArrayList<>();
		listNumbers.add(1);
		listNumbers.add(2);
		listNumbers.add(3);
		listNumbers.add(4);
		System.out.println(listNumbers);
		
		List<Integer> listNumbers2 = List.of(1,2,3,4);
		System.out.println(listNumbers2);
		
		List<Integer> listNumberOne = List.of(4,3,2,1);  // existing collection
		List<Integer> listNumberTwo = new ArrayList<>(listNumberOne);
		System.out.println(listNumberTwo);
		
		System.out.println("Agregar objetos:");
		List<String> listStrings2 = new ArrayList<>();
		listStrings2.add("Paco");
		listStrings2.add("Pepe");
		listStrings2.add("Pedro");
		listStrings2.add(1, "Pirola");
		
		//listStrings2.addAll(listStrings);
		listStrings2.addAll(2, listStrings);
		System.out.println(listStrings2);
		
		System.out.println("Obtener objeto:");
		String element = listStrings.get(1);
		System.out.println(element);
		
		System.out.println("Actualizar objeto:");
		listStrings.set(2, "Hi");
		System.out.println(listStrings);
		
		System.out.println("Eliminar obejtos de la lista:");
		listStrings.remove(2);
		System.out.println(listStrings);
		
		System.out.println("Recorrer la lista:");
		for (String elemento : listStrings) {
			  System.out.println(elemento);
			  }
		System.out.println("Recorrer con for-each:");
		System.out.println("Primer método");
		listStrings.forEach(s -> System.out.println(s));
		System.out.println("Segundo método");
		for(String x:listStrings) {
			System.out.println(x);
		}
		
		
		
	}
}

