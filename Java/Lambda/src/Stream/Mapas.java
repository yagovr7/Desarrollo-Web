package Stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapas {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("Pepe",5);
		map.put("Fran", 8);
		map.put("Jose", 7);

		List<String> biggerThanSix = map.entrySet().stream()
		  .filter(e -> 6 < e.getValue())
		  .map(a -> a.getKey())
		  .collect(Collectors.toList());
		
		System.out.println(biggerThanSix);
	}
}
