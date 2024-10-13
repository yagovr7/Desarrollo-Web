package Ejercicio3;

import java.util.Comparator;

public class ComparadorEstudiante implements Comparator <Estudiante>{

	public int compare(Estudiante o1, Estudiante o2) {
		int comp = o1.getNombre().compareTo(o2.getNombre());
		if(comp != 0) {
			return comp;
		}
		return Integer.valueOf(o1.getEdad()).compareTo(o2.getEdad());
	}
	
	
}
