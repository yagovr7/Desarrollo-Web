package HashMap;
import java.util.HashMap;

public class CreateMap {
	public static void main(String[] args) {
		HashMap<Integer, String> mapHttpErrors = new HashMap<>();
		 
		mapHttpErrors.put(200, "OK");
		mapHttpErrors.put(303, "See Other");
		mapHttpErrors.put(404, "Not Found");
		mapHttpErrors.put(500, "Internal Server Error");
		 
		System.out.println(mapHttpErrors);
		
		HashMap<Integer, String> mapErrors = new HashMap<>(mapHttpErrors);
		
		String status301 = mapErrors.get(200);
		System.out.println("301: " + status301);

		if (mapHttpErrors.containsKey("200")) {
		    System.out.println("Http status 200");
		}
		if (mapHttpErrors.containsValue("OK")) {
		    System.out.println("Found status OK");
		}
		
		String status3011 = mapHttpErrors.get(301);
		System.out.println("301: " + status3011);
	}
}
