package interfaces;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		
		//Consumer
		System.out.println("****Consumer****");
		List<Integer> numbers = Arrays.asList(1,3,4,6);
		numbers.forEach(number -> System.out.println(number));
		
		//Supplier
		System.out.println("****Supplier****");
		Supplier<Integer> randomNumbersSupp=() -> new Random().nextInt(10);
		Supplier<LocalDateTime> s = () -> LocalDateTime.now();
		LocalDateTime time = s.get();
		System.out.println(time);
		System.out.println(randomNumbersSupp.get());
		
		//Predicate
		System.out.println("****Predicate****");
		Predicate<String> checker = a -> a.startsWith("M");
		System.out.println(checker.test("Miguel"));
		
		//Function
		System.out.println("****Function****");
		Matematicas o = (x, y) -> x + y;
	    System.out.println(o.operacion(2, 3));
	}
}
