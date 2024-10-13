package EjercicioPokemon;

public class Pokemon {
	String nombre;
	enum tipo {Squirtle, Charmander, Bulbasaur, Pikachu};
	String clase;
	int vida;
	int nivel;
	Pokemon pokemonF;
	
	Pokemon(){
	this.nombre=Pokemon.nombrePokemon();
	this.clase=Pokemon.probabilidad();
	this.vida=100;
	this.nivel=(int)(Math.random()*100+1);
	}
	
	public static String probabilidad() {
		int random = (int)(Math.random()*100+1);
		if(random > 0 && random <= 30) {
			return Pokemon.tipo.Squirtle.toString();
		}else if(random > 30 && random <= 60){
			return tipo.Charmander.toString();
		}else if(random > 60 && random <= 90){
			return tipo.Bulbasaur.toString();
		}
		
		return tipo.Pikachu.toString();
	}
	
	public static String nombrePokemon() {
		String[] nombres = {"Ivysaur","Venusaru","Charizard","Wartortle","Blastoise","Caterpie","Metapod","Butterfree",
				"Weedle","Kakuna","Beedrill","Pidgey","Pidgeotto","Rattata","Raticate","Spearow"};
		String nombreFinal = " ";
		int posicion = (int)(Math.random()*15+1);
		for(int i =0;i<nombres.length;i++) {
			 nombreFinal=nombres[posicion];
		}
		return nombreFinal;
	}
	
	
	public void sanarTotalmente() {
		 this.vida=100;
	}
	
	public void tomarPocion(int vida) {
		 this.vida=this.vida+vida;
	}
	
	public void tomarPocionF(float porcentaje) {
		int por=(100*(int)porcentaje)/100;
		 this.vida=this.vida+por;
	}
	
	public void reducirVida(int cantidad) {
		this.vida=this.vida-cantidad;
		
	}
	
	
	public void mostrarDatos() {
		
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Tipo: "+this.clase);
		System.out.println("Vida: "+this.vida);
		System.out.println("Nivel: "+this.nivel);
		
	}
	
	public void pokemonFusion(Pokemon pokemon) {
		this.pokemonF=pokemon;
	}
}
