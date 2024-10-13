package HashMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class RecorrerMapa {
	public static void main(String[] args) {
		HashMap<String, String> mapCountryCodes = new HashMap<>();
		 
		mapCountryCodes.put("1", "USA");
		mapCountryCodes.put("44", "United Kingdom");
		mapCountryCodes.put("33", "France");
		mapCountryCodes.put("81", "Japan");
		
		System.out.println("*****keySet()*****");
		
		Set<String> setCodes = mapCountryCodes.keySet();
		Iterator<String> iterator = setCodes.iterator();
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    String country = mapCountryCodes.get(code);
		 
		    System.out.println(code + " => " + country);
		}
		
		System.out.println("***** values() *****");
		
		Collection<String> countries = mapCountryCodes.values();
		for (String country : countries) {
		    System.out.println(country);
		}
		
		System.out.println("***** entrySet() *****");
		
		Set<Map.Entry<String, String>> entries = mapCountryCodes.entrySet();
		for (Map.Entry<String, String> entry : entries) {
		    String code = entry.getKey();
		    String country = entry.getValue();
		 
		    System.out.println(code + " => " + country);
		}
		
		System.out.println("***** forEach *****");
		mapCountryCodes.forEach((code, country) -> System.out.println(code+" => "+country));
	}
}
