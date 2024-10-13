package Ejercicio3;

import Ejercicio1.Persona;

public class Main {
	
	public static <T> void imprimeArray(T[] a) {
	    for (T val: a) System.out.printf("%s ", val);
	        System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] a = {1,2,3};
		Double[] b = {2.5,6.7,8.8};
		Persona pj = new Persona("Yago",26);
		Persona px = new Persona("Claudia", 23);
		Persona[] p = {pj,px};
		
		imprimeArray(a);
		imprimeArray(b);
		imprimeArray(p);
	}

}
