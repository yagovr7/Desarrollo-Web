package Ejercicio3;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Estudiante e1 = new Estudiante("Yago", 26);
		Estudiante e2 = new Estudiante("Claudia", 23);
		Estudiante e3 = new Estudiante("Lara", 22);
		Estudiante e4 = new Estudiante("Samuel", 31);
		LinkedList<Estudiante> estudiantes = new LinkedList<>();
		estudiantes.add(e1);
		estudiantes.add(e2);
		estudiantes.add(e3);
		estudiantes.add(e4);
		
		Collections.sort(estudiantes, new ComparadorEstudiante());
		
		estudiantes.forEach(s -> System.out.println(s.getNombre()+"		"+s.getEdad()));
	}
}
