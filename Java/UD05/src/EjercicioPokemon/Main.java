package EjercicioPokemon;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void Menu() {
		System.out.println("MENU:");
		System.out.println("1.Menu Pokemon");
		System.out.println("2.Menu Entrenador");
		System.out.println("3.Tabla Resumen");
		System.out.println("4.Exit");
	}
	public static void MenuPokemon() {
		System.out.println("MENU POKEMON:");
		System.out.println("1.Sanar Totalmente");
		System.out.println("2.Tomar Pocion");
		System.out.println("3.Tomar Pocion (porcentaje)");
		System.out.println("4.Reducir Vida");
		System.out.println("5.Mostrar Datos Pokemon");
		System.out.println("6.Asignar PokemonFusion");
		System.out.println("7.Exit");
	}
	
	public static void MenuEntrenador() {
		System.out.println("MENU ENTRENADOR:");
		System.out.println("1.Crear Equipo");
		System.out.println("2.Agregar Pokemon");
		System.out.println("3.Eliminar Pokemon por posición");
		System.out.println("4.Eliminar pokemon por nombre");
		System.out.println("5.Asignar PokemonFusion");
		System.out.println("6.Mostrar Equipo");
		System.out.println("7.Exit");
	}
	public static void main(String[] args) {
		int opcion;
		Pokemon pokemonF;
		//Pokemons generados de forma aleatoria
		Pokemon p1 = new Pokemon();
		Pokemon p2 = new Pokemon();
		Pokemon p3 = new Pokemon();
		Pokemon p4 = new Pokemon();
		Pokemon p5 = new Pokemon();
		
		Pokemon p6 = new Pokemon();
		Pokemon p7 = new Pokemon();
		Pokemon p8 = new Pokemon();
		Pokemon p9 = new Pokemon();
		Pokemon p10 = new Pokemon();
		
		Pokemon p11 = new Pokemon();
		Pokemon p12 = new Pokemon();
		Pokemon p13 = new Pokemon();
		Pokemon p14 = new Pokemon();
		Pokemon p15 = new Pokemon();
		
		Pokemon p16 = new Pokemon();
		Pokemon p17 = new Pokemon();
		Pokemon p18 = new Pokemon();
		Pokemon p19 = new Pokemon();
		Pokemon p20 = new Pokemon();
		
		Pokemon p21 = new Pokemon();
		Pokemon p22 = new Pokemon();
		Pokemon p23 = new Pokemon();
		Pokemon p24 = new Pokemon();
		Pokemon p25 = new Pokemon();
		
		
		//Entrenadores
		Entrenador e1 = new Entrenador("Yago");
		Entrenador e2 = new Entrenador("Claudia");
		Entrenador e3 = new Entrenador("Mateo");
		Entrenador e4 = new Entrenador("Izan");
		Entrenador e5 = new Entrenador("Mia");
		
		
		//Menú Inicial
		for(;;) {
			Main.Menu();
			opcion = sc.nextInt();
			
			//Menú Pokemon
			if(opcion==1) {
				for(;opcion!=7;) {
				Main.MenuPokemon();
				opcion=sc.nextInt();
				switch (opcion) {
					
					//Sanar Totalmente
					case 1:
						p1.sanarTotalmente();
						p1.mostrarDatos();
						System.out.println();
						break;
						
					//Tomar Pocion INT	
					case 2:
						if(p1.vida<100) {
							p1.tomarPocion(20);
							if(p1.vida>100) {
								p1.sanarTotalmente();
							}
							p1.mostrarDatos();
						}else if(p1.vida==100) {
							System.out.println("Vida al Máximo");	
						}
						System.out.println();
						break;
						
					//Tomar Pocion Float Porcentaje	
					case 3:
						if(p1.vida<100) {
							p1.tomarPocionF(30);
							if(p1.vida>100) {
								p1.sanarTotalmente();
							}
							p1.mostrarDatos();
						}else if(p1.vida==100) {
							System.out.println("Vida al Máximo");
						}
						System.out.println();
						break;
					//Reducir Vida
					case 4:
						if(p1.vida<=0) {
							System.out.println("El Pokemon "+p1.nombre+" a muerto");
							System.out.println();
							p1=null;
							System.exit(0);
						}else {
							p1.reducirVida(20);
						}
						p1.mostrarDatos();
						System.out.println();
						break;
						
					//Mostrar Datos
					case 5:
						p1.mostrarDatos();
						System.out.println();
						break;
					
					//Asignar PokemonFusion
					case 6:
						System.out.println("Datos Pokemon P1 y P2");
						System.out.println();
						p1.mostrarDatos();
						System.out.println();
						p2.mostrarDatos();
						p1=p2;
						System.out.println();
						System.out.println("Pokemon P1 fusionado con Pokemon P2");
						System.out.println();
						p1.mostrarDatos();
						System.out.println();
						break;
					
					//Exit
					case 7:
						opcion=7;
				}
			}
			//Menú entrenador
			}else if(opcion==2) {
				
				for(;opcion!=7;) {
					Main.MenuEntrenador();
					System.out.println();
					opcion=sc.nextInt();
					
					switch(opcion) {
						
						//Crear Equipo
						case 1:
							e1.crearEquipo();
							System.out.println("¡Equipo Creado!");
							System.out.println();
							break;
						
						//Agregar Pokemon a Equipo
						case 2:
							e1.agregarPokemon(p1, 0);
							e1.agregarPokemon(p2, 1);
							e1.agregarPokemon(p3, 2);
							e1.agregarPokemon(p4, 3);
							e1.agregarPokemon(p5, 4);
							
							System.out.println("¡Pokemons agregados al equipo!");
							System.out.println();
							break;

						//Eliminar Pokemon por posicion
						case 3:
							e1.eliminarPokemon(0);
							System.out.println("Pokemon Eliminado");
							System.out.println();
							break;
							
						//Eliminar Pokemon por Nombre
						case 4:
							e1.eliminarPokemonNombre(e1);
							e1.mostrarEquipo(e1);
							System.out.println();
							break;
							
						//Asignar Pokemon Fusión
						case 5:
							e1.pokemonFusion(p1, 3);
							break;
							
						//Mostrar Equipo
						case 6:
							e1.mostrarEquipo(e1);
							System.out.println();
							break;
							
						//Exit
						case 7:
							opcion=7;
							break;
					}
				}
				
			}else if(opcion==3) {
				
				//Exit
			}else if(opcion==4) {
				System.exit(0);
				
			//Ningunha de las opciones
			}else {
			System.out.println("Seleccione una opción");
		}
	}
		

		
	}
}
