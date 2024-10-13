package StreamEjercicio1;

import java.util.Arrays;
import java.util.Optional;

public class Ej1 {
	public static void main(String[] args) {
		String[] array = {"Java", "Python", "SQL", "JavaScript"};
		Optional<String> MIN = Arrays.stream(array).min((str1, str2) -> 
        Character.compare(str1.charAt(str1.length() - 1), str2.charAt(str2.length() - 1)));
		if(MIN.isPresent()) {
			System.out.println(MIN.get());
		}
	}
}
