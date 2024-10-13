package EjercicioPokemon;

public class Prueba {
	public static void main(String[] args) {
		Entrenador e1 = new Entrenador("Yago");
		Pokemon p1 = new Pokemon();
		Pokemon p2 = new Pokemon();
		Pokemon p3 = new Pokemon();
		Pokemon p4 = new Pokemon();
		Pokemon p5 = new Pokemon();
		
		e1.crearEquipo();
		
		e1.agregarPokemon(p1, 0);
		e1.agregarPokemon(p2, 1);
		e1.agregarPokemon(p3, 2);
		e1.agregarPokemon(p4, 3);
		e1.agregarPokemon(p5, 4);
		
		if(e1.equipo[0].nombre.equals("Venusaru")) {
			System.out.println("SI "+e1.equipo[0].nombre);
		}else {
			System.out.println("NO "+e1.equipo[0].nombre);
		}
	}
}
