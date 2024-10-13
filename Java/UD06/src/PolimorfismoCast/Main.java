package PolimorfismoCast;

public class Main {
	public static void main(String[] args) {
		int temp;
	    A a; // Referencia a objetos de la clase A
	    a= new B (); // Referencia a objetos clase A, pero apunta realmente a objeto clase B
	    //temp=a.atrib2; //error, obj apunta a un objeto de clase B pero solo tiene acceso a parte de superclase
	    B b= (B) a;//la refencia a la convierto a otra de tipo B
	    temp=b.atrib2;
	    
	    System.out.println("a.atrib1: "+a.atrib1);
	    System.out.println("b.atrib1: "+b.atrib1);
	    System.out.println("b.atrib2: "+b.atrib2);
	}
}
