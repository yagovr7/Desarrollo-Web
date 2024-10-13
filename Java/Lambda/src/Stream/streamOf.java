package Stream;

import java.util.stream.Stream;

public class streamOf {
	public static void main(String[] args) {
		Stream<Person> userStream = Stream.of(
			    new Person("Mahesh", 22),
			    new Person("Krishn", 20),
			    new Person("Suresh", 25)
			);
			userStream.forEach(u -> System.out.println(u.getNombre()));
			//Uso con Strings
			Stream<String> mystream = Stream.of("AA", "BB", "CC", "DD");
			mystream.forEach(e -> System.out.println(e));
	}
}
