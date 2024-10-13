package Ejercicio3;

import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {
		Supplier<Student> estudiante =()->new Student(1,"Yago", "Male", 27);
		
		System.out.println("ID: "+estudiante.get().getId());
		System.out.println("Name: "+estudiante.get().getName());
		System.out.println("Gender: "+estudiante.get().getGender());
		System.out.println("Age: "+estudiante.get().getAge());
	}
}
