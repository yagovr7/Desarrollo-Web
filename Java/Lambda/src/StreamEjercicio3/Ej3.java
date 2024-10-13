package StreamEjercicio3;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ej3{
	public static void main(String[] args) {
		Supplier<Integer> generador = ()->new Random().nextInt(10)+1;
		Stream.generate(generador).limit(5).forEach(System.out::println);
		
		
	}

	
}
