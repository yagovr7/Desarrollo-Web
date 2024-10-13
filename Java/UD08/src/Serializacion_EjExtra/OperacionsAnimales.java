package Serializacion_EjExtra;

public class OperacionsAnimales {
	public static void main(String[] args) {
		Animal root = new Animal();
		
		Animal p1 = new Perro("Brooklyn", 9, "Largo");
		Animal p2 = new Perro("Blacky", 4, "Corto");
		Animal p3 = new Perro("Fusco", 2, "Largo");
		Animal p4 = new Perro("Rex", 10, "Corto");
		Animal p5 = new Perro("Tobby", 2, "Largo");
		
		Animal g1 = new Gato("Mixa", 5, "Largo");
		Animal g2 = new Gato("Kira", 6, "Corto");
		Animal g3 = new Gato("Gataca", 2, "Largo");
		Animal g4 = new Gato("Shiba", 7, "Corto");
		Animal g5 = new Gato("Michi", 4, "Largo");
		
		root.addPerro(p1);
		root.addPerro(p2);
		root.addPerro(p3);
		root.addPerro(p4);
		root.addPerro(p5);
		root.addGato(g1);
		root.addGato(g2);
		root.addGato(g3);
		root.addGato(g4);
		root.addGato(g5);
		
		for(Animal x:root.perro) {
			System.out.println("Nombre: "+x.getNombre());
			System.out.println("Edad: "+x.getEdad());
			x.getTipo(x);
		}
	}
}
