package NBA;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Menu {
	public static void menu() {
		System.out.println("1.Mostrar Equipos");
		System.out.println("2.Agregar jugadores");
		System.out.println("3.Consultar Equipo");
		System.out.println("4.Generar Fichero");
		System.out.println("5.Comparar jugadores");
		System.out.println("6.Dividir por conferencia");
		System.out.println("7.Realizar Bakcup");
		System.out.println("9.Exit");
	}
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		NBA root = new NBA();
		//Creamos los equipos
			Equipo eq1 = new Equipo("Galaxy", "New York", "Oeste");
			Equipo eq2 = new Equipo("Lakers", "Los Angles", "Este");
			Equipo eq3 = new Equipo("Warriors", "Oklahoma", "Oeste");
			root.equipos.put(eq1.getNombre(), eq1);
			root.equipos.put(eq2.getNombre(), eq2);
			root.equipos.put(eq3.getNombre(), eq3);
			
			
			Rookie j1 = new Rookie("Yago", 1, 500, 6);
			Rookie j2 = new Rookie("Paco", 2, 500, 1);
			Rookie j3 = new Rookie("Paul", 3, 500, 8);
			//Creo 3 Rookies para los Galaxy, al intentar introducir otro por teclado
			//muestra el mensaje de "Máxima cantidad de Rookies"
			root.equipos.get("Galaxy").jugadores.put(j1.getDorsal(), j1);
			root.equipos.get("Galaxy").jugadores.put(j2.getDorsal(), j2);
			root.equipos.get("Galaxy").jugadores.put(j3.getDorsal(), j3);
			
			Veterano v1 = new Veterano("Olivie", 1, 5000, 12, root.equipos.get("Lakers"));
			Veterano v2 = new Veterano("Alfonso", 2, 2000, 15, root.equipos.get("Lakers"));
			Veterano v3 = new Veterano("Elias", 3, 6000, 9, root.equipos.get("Galaxy"));
			Veterano v4 = new Veterano("Juan", 4, 5678, 16, root.equipos.get("Warriors"));
			Veterano v5 = new Veterano("Pedro", 5, 9876, 8, root.equipos.get("Lakers"));
			Veterano v6 = new Veterano("Sergio", 6, 4857, 7, root.equipos.get("Galaxy"));
			Veterano v7 = new Veterano("Pier", 7, 2664, 12, root.equipos.get("Lakers"));
			Veterano v8 = new Veterano("Gianluca", 8, 9787, 10, root.equipos.get("Warriors"));
			Veterano v9 = new Veterano("Thomas", 9, 6785, 7, root.equipos.get("Lakers"));
			Veterano v10 = new Veterano("Aston", 10, 10987, 12, root.equipos.get("Galaxy"));
			Veterano v11 = new Veterano("Marcus", 11, 5748, 14, root.equipos.get("Warriors"));
			Veterano v12 = new Veterano("Haland", 12, 8764, 13, root.equipos.get("Lakers"));
			Veterano v13 = new Veterano("Gareth", 13, 7685, 12, root.equipos.get("Warriors"));
			Veterano v14 = new Veterano("Paul", 14, 3455, 16, root.equipos.get("Galaxy"));
			Veterano v15 = new Veterano("Oliver", 15, 5000, 12, root.equipos.get("Warriors"));
			
			root.equipos.get("Lakers").jugadores.put(v1.getDorsal(), v1);
			root.equipos.get("Lakers").jugadores.put(v2.getDorsal(), v2);
			root.equipos.get("Lakers").jugadores.put(v3.getDorsal(), v3);
			root.equipos.get("Lakers").jugadores.put(v4.getDorsal(), v4);
			root.equipos.get("Lakers").jugadores.put(v5.getDorsal(), v5);
			root.equipos.get("Lakers").jugadores.put(v6.getDorsal(), v6);
			root.equipos.get("Lakers").jugadores.put(v7.getDorsal(), v7);
			root.equipos.get("Lakers").jugadores.put(v8.getDorsal(), v8);
			root.equipos.get("Lakers").jugadores.put(v9.getDorsal(), v9);
			root.equipos.get("Lakers").jugadores.put(v10.getDorsal(),v10);
			root.equipos.get("Lakers").jugadores.put(v11.getDorsal(), v11);
			root.equipos.get("Lakers").jugadores.put(v12.getDorsal(), v12);
			root.equipos.get("Lakers").jugadores.put(v13.getDorsal(), v13);
			root.equipos.get("Lakers").jugadores.put(v14.getDorsal(), v14);
			root.equipos.get("Lakers").jugadores.put(v15.getDorsal(), v15);
		
		int opcion = 0;
		while(opcion!=8) {
			String nombreEquipo;
			menu();
			opcion = sc.nextInt();
			switch(opcion) {
				case 1:
					root.mostrarEquipos();
					break;
				case 2:
					System.out.print("Nombre del equipo: ");
					String nombreE = sc.next();
					if(!root.equipos.containsKey(nombreE)) {
						System.out.println("El equipo no existe");
						break;
					}
					System.out.println("1.Veterano");
					System.out.println("2.Rookie");
					int tipo = sc.nextInt();
					switch(tipo){
						case 1:
							System.out.print("Nombre: ");
							String nombreV = sc.next();
							System.out.print("Dorsal: ");
							int dorsalV = sc.nextInt();
							System.out.print("Salario: ");
							double salarioV = sc.nextDouble();
							System.out.print("Años jugador: ");
							int anos = sc.nextInt();
							System.out.print("Nombre del último equipo: ");
							String equipo = sc.next();
							Equipo aux = null;
							boolean fin = false;
							while(fin!=true) {
								if(root.equipos.containsKey(equipo)) {
									fin=true;
									aux = root.equipos.get(equipo);
								}else {
									System.out.print("El equipo no existe vuelve a introducirlo: ");
									equipo = sc.next();
								}
							}
							try {
								root.agregarJugador(nombreE, nombreV, dorsalV, salarioV, anos, aux);
							}catch(Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;
						case 2:
							System.out.print("Nombre: ");
							String nombreR = sc.next();
							System.out.print("Dorsal: ");
							int dorsalR = sc.nextInt();
							System.out.print("Salario: ");
							double salarioR = sc.nextDouble();
							System.out.print("Número del draft: ");
							int num_draft = sc.nextInt();
							try {
								root.agregarJugador(nombreE, nombreR, dorsalR, salarioR, num_draft);
							}catch(Exception e) {
								System.out.println(e.getMessage());
								break;
							}
							
						break;
						
							
					}
					break;
					case 3:
						System.out.print("Nombre del equipo: ");
						String nom = sc.next();
						try {
							root.consultarEquipo(nom);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						try {
							root.generarFichero();
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println("Nombre del Equipo: ");
						String equipo = sc.next();
						boolean fin = false;
						while(fin!=true) {
							if(root.equipos.containsKey(equipo)) {
								fin = true;
							}else {
								System.out.println("El equipo no existe vuelve a introducir el nombre: ");
								equipo = sc.next();
							}
						}
						System.out.print("Dorsal del primer jugador: ");
						int d1 = sc.nextInt();
						Jugadores player1 = root.equipos.get(equipo).jugadores.get(d1);
						System.out.print("Dorsal del segundo jugador: ");
						int d2 = sc.nextInt();
						Jugadores player2 = root.equipos.get(equipo).jugadores.get(d2);
						try {
							root.equipos.get(equipo).compararJugador(player1, player2);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 6:
						root.dividirConferencia();
						System.out.println();
						break;
					case 7:
						System.out.print("Nombre del equipo: ");
						String nombre = sc.next();
						boolean verdadero = false;
						if(root.equipos.containsKey(nombre)) {
							verdadero = true;
						}
						while(!verdadero) {
							System.out.println("El equipo no existe, vueleve a introducir el nombre: ");
							nombre = sc.next();
							if(root.equipos.containsKey(nombre)) {
								verdadero = true;
							}
						}
						String aux = nombre+".ser";
						nombreEquipo = aux;
						System.out.println(aux);
						Equipo eq = root.equipos.get(nombre);
						try {
							output = new ObjectOutputStream(Files.newOutputStream(Paths.get(aux)));
						}catch(IOException e) {
							System.out.println("No se puede acceder al archivo, cerrando.");
							System.exit(1);
						}
						boolean end = false;
						while(!end) {
							try {
								output.writeObject(eq);
								end = true;
							}catch (NoSuchElementException elementException)
					         {
					            System.err.println("Datos incorrectos.");
					         }catch(IOException e) {
								System.out.println("Error en la escritura ,cerrando.");
								System.exit(1);
							}
						}
						
						System.out.println("Quieres leer el archivo? true/false: ");
						boolean leer = sc.nextBoolean();
						if(leer == true) {
							try 
						      {
						         input = new ObjectInputStream(          
						            Files.newInputStream(Paths.get(nombreEquipo)));
						      } 
						      catch (IOException ioException)
						      {
						         System.err.println("Erro abrindo ficheiro.");
						         System.exit(1);
						      }
							System.out.printf("%-10s%-12s%-12s%n", "Nombre",
							         "Localidad", "Conferencia");
							try {
						            // lectura e cast
						            Equipo record = (Equipo) input.readObject();
						            // mostramos os datos
						            System.out.printf("%-10s%-12s%-12s",  
						               record.getNombre(), record.getLocalidad(), record.getConferencia());
						            Set<Integer> setCode = record.jugadores.keySet();
									Iterator<Integer> iterator = setCode.iterator();
									System.out.println("\n****JUGADORES****");
									while(iterator.hasNext()) {
										int clave = iterator.next();
										if(record.jugadores.get(clave) instanceof Veterano) {
											Veterano auxV = (Veterano) record.jugadores.get(clave);
											System.out.print("Nombre: "+auxV.getNombre()+" Dorsal: "+auxV.getDorsal()
											+" Salario: "+String.format("%.2f", auxV.getSalario())+" €"+" Experiencia: "+auxV.anos+" Último equipo: "
											+auxV.ultimo_equipo.getNombre());
										}else {
											Rookie auxR = (Rookie) record.jugadores.get(clave);
											System.out.print("Nombre: "+auxR.getNombre()+" Dorsal: "+auxR.getDorsal()
											+" Salario: "+String.format("%.2f", auxR.getSalario())+" €"+" Numero del Draft: "+auxR.num_draft);
										}
										System.out.println();
									}
						            
						      }
						      catch (EOFException endOfFileException)
						      {
						         System.out.printf("%nNon hai mais datos.%n");
						      } 
						      // Excepcion que xorde cando nos chega un obxecto que non esperamos
						      catch (ClassNotFoundException classNotFoundException)
						      {
						         System.err.println("Tipo de obxecto inválido.");
						      } 
						      catch (IOException ioException)
						      {
						         System.err.println("Erro lendo o ficheiro.");
						      }
							System.out.println();
							break;
						}else if(leer == false) {
							break;
						}
					case 8:
						System.exit(0);
						break;
						
			} 
		}
		sc.close();
	}
}
