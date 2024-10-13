package EjercicioPokemon;

import java.util.Scanner;

public class Entrenador {
	String nombre = " ";
	Pokemon[] equipo;
	
	Entrenador(String nombre){
		this.nombre=nombre;
	}
	
	public void crearEquipo() {
		equipo = new Pokemon[5];
	}
	
	public void agregarPokemon(Pokemon pokemon, int pos) {
		equipo[pos]=pokemon;
	}
	

	
	public void eliminarPokemon(int posicion) {
		equipo[posicion]=null;
		//equipo[posicion].clase=null;
		//equipo[posicion].vida=0;
		//equipo[posicion].nivel=0;
	}
	
	public void eliminarPokemonNombre(Entrenador entrenador ) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe el nombre: ");
		String teclado = sc.next();
		for(int i = 0;i<equipo.length;i++) {
			if(entrenador.equipo[i]==null) {i++; continue;}
			if(entrenador.equipo[i].nombre==teclado) {entrenador.equipo[i]=null;}
		}
	}	
	
	public void pokemonFusion(Pokemon pokemon, int pos) {
		equipo[pos]=pokemon;
	}
	
	
	public void mostrarEquipo(Entrenador entrenador) {
		System.out.println("Equipo del Entrenador : "+nombre);
		for(int i = 0;i<this.equipo.length;i++) {
			if(equipo[i]==null) {
				continue;
			}
			System.out.print("Nombre: "+equipo[i].nombre+" Tipo: "+equipo[i].clase+" Vida: "+equipo[i].vida+" Nivel: "+equipo[i].nivel);
			System.out.println();
		}
	}
}
