
package StreamCollect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollect {
	public static void main(String[] args) {
		Car c1 = new Car("Rojo");
		Car c2 = new Car("Amarillo");
		Car c3 = new Car("Blanco");
		List<Car> coches = Arrays.asList(c1, c2, c3);
		List<Car> result = new ArrayList<>();
		
		coches.forEach(x -> System.out.println(x.getColor()));
		
		result.forEach(x -> System.out.println(x.getColor()));
		
		result = coches.stream().collect(Collectors.toList());
		
		result.forEach(x -> System.out.println(x.getColor()));
	}
}
