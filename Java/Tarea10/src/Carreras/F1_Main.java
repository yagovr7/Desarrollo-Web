package Carreras;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.InputMismatchException;

public class F1_Main {
	public static void menu() {
		System.out.println("1.Dar de Alta Equipo en Carrera");
		System.out.println("2.Alta Participante");
		System.out.println("3.Eliminar Equipo");
		System.out.println("4.Dar premio a equipo");
		System.out.println("5.Equipos");
		System.out.println("6.Listado Equipos(solo apellidos)");
		System.out.println("7.Unir equipos");
		System.out.println("8.Participante mas joven");
		System.out.println("9.Volcar resumen a la Base de Datos");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeMap<Integer, Participante> participantes = new TreeMap<>();
		TreeMap<Integer, Equipo> equipos = new TreeMap<>();
		TreeMap<Integer,Carrera> carreras = new TreeMap<>();
		//Participantes
		Participante p1 = new Participante("Max", "Verstapen", "H", 25);
		participantes.put(1, p1);
		Participante p2 = new Participante("Sergio", "Perez", "H", 30);
		participantes.put(2, p2);
		Participante p3 = new Participante("Daniel", "Ricciardo", "M", 5);
		participantes.put(3, p3);
		Participante p4 = new Participante("Liam", "Lawson", "H", 30);
		participantes.put(4, p4);
		Participante p5 = new Participante("Charles", "Leclerc", "M", 14);
		participantes.put(5, p5);
		Participante p6 = new Participante("Carlos", "Sainz", "H", 16);
		participantes.put(6, p6);
		Participante p7 = new Participante("Robert", "Shwartzman ", "H", 18);
		participantes.put(7, p7);
		Participante p8 = new Participante("Antonio ", "Giovinazzi ", "H", 24);
		participantes.put(8, p8);
		
		Participante p9= new Participante("Lewis ", "Hamilton", "M", 19);
		participantes.put(9, p9);
		Participante p10 = new Participante("George ", "Russell", "H", 12);
		participantes.put(10, p10);
		Participante p11 = new Participante("Mick", "Schumacher", "H", 30);
		participantes.put(11, p11);
		Participante p12 = new Participante("Stoffel ", "Vandoorne", "H", 7);
		participantes.put(12, p12);
		
		//Equipos
		Equipo eq1 = new Equipo("Red Bull", p1);
		eq1.participantes.put(1, p1);
		eq1.participantes.put(2, p2);
		eq1.participantes.put(3, p3);
		eq1.participantes.put(4, p4);
		Equipo eq2 = new Equipo("Ferrari", p5);
		eq2.participantes.put(5, p5);
		eq2.participantes.put(6, p6);
		eq2.participantes.put(7, p7);
		eq2.participantes.put(8, p8);
		Equipo eq3 = new Equipo("Mercedes", p9);
		eq3.participantes.put(9, p9);
		eq3.participantes.put(10, p10);
		eq3.participantes.put(11, p11);
		eq3.participantes.put(12, p12);
		equipos.put(1, eq1);
		equipos.put(2, eq2);
		equipos.put(3, eq3);
		//Carreras
		Carrera c1 = new Carrera("GP Baréin", "05/03/2023", 6.30);
		Carrera c2 = new Carrera("GP Arabia Saudí", "19/03/2023", 5.15);
		Carrera c3 = new Carrera("GP Australia", "02/04/2023", 5.3);
		c1.equipos.put(eq1.getNombre(), eq1);
		c1.equipos.put(eq2.getNombre(), eq2);
		c1.equipos.put(eq3.getNombre(), eq3);
		
		c2.equipos.put(eq1.getNombre(), eq1);
		c2.equipos.put(eq2.getNombre(), eq2);
		
		c3.equipos.put(eq2.getNombre(), eq2);
		c3.equipos.put(eq3.getNombre(), eq3);
		carreras.put(1, c1);
		carreras.put(2, c2);
		carreras.put(3, c3);
		//Puntos
		c1.asignarPuntos(eq1, 25);
		c1.asignarPuntos(eq2, 18);
		
		c2.asignarPuntos(eq1, 15);
		c2.asignarPuntos(eq2, 25);
		c2.asignarPuntos(eq3, 18);
		
		c3.asignarPuntos(eq1, 18);
		c3.asignarPuntos(eq3, 25);

		int opcion = 99;
		while(opcion!=0) {
			menu();
			try {
				opcion = sc.nextInt();
				switch(opcion) {
				
					case 1:
						Carrera auxC = null; Equipo auxE = null; String nameE; int carrera, capitan;
						System.out.println("****Carreras****");
						carreras.entrySet().stream()
						.map(Map.Entry::toString)
						.forEach(System.out::println);
						carrera = sc.nextInt();
						
						if(!carreras.containsKey(carrera)) {
							System.out.println("La carrera no existe");
							break;
						}else {
							int count = 1;
							auxC = carreras.get(carrera);
							System.out.print("Nombre: "); nameE = sc.next();
							System.out.println("Capitan: "); 
							for(Map.Entry<Integer, Participante> x: participantes.entrySet()) {
								System.out.println((count++)+"."+x.getValue().getNombre());
							}
							
							do {
								System.out.print("Elección: "); capitan = sc.nextInt();
							}while(!participantes.containsKey(capitan));
							auxE = new Equipo(nameE, participantes.get(capitan));
							for(Map.Entry<Integer, Equipo> x: equipos.entrySet()) {
								if(x.getValue().capitan.equals(participantes.get(capitan))) {
									System.out.println(participantes.get(capitan).getNombre()+" ya es capitán de un equipo");
									break;
								}
							}
							int ultimo = equipos.lastKey();
							equipos.put(ultimo+1, auxE);
							auxC.puntosCarrera.put(auxE, 0);
							try {
								auxC.AltaEquipo(auxE);
							}catch(Exception e){
								System.out.println(e.getMessage());
							}
						}
						
						break;
					case 2:
						Equipo auxE2 = null; int equipo2, dorsal;
						System.out.println("****Equipos****");
						equipos.entrySet().stream()
						.map(Map.Entry::toString)
						.forEach(System.out::println);
						equipo2 = sc.nextInt();
						if(!equipos.containsKey(equipo2)) {
							System.out.println("El equipo no existe");
							break;
						}else {
							auxE2 = equipos.get(equipo2);
						}
						
						System.out.print("Dorsal: "); dorsal = sc.nextInt();
						while(participantes.containsKey(dorsal)) {
							System.out.print("Dorsal registrado vuelve a introducirlo: ");dorsal = sc.nextInt();
						}
						
						String nombre, apellidos, sexo; int eleccion;
						System.out.print("Nombre: "); nombre = sc.next();
						System.out.print("Apellidos: "); apellidos = sc.next();
						System.out.print("Sexo  1.Hombre 2.Mujer: ");eleccion = sc.nextInt();
						if(eleccion == 1) {
							sexo = "H";
						}else if(eleccion == 2) {
							sexo = "M";
						}else {
							System.out.println("Eleccion incorrecta");
							break;
						}
						int edad;
						do {
					         System.out.print("Edad entre 5 y 30 años: ");
					         edad = sc.nextInt();
					      } while (edad < 5 || edad > 30);

						try {
							auxE2.AltaParticipante(dorsal, nombre, apellidos, sexo, edad);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						Carrera auxC2 = null; String eleccion3; int carreraX;
						System.out.println("****Carreras****");
						carreras.entrySet().stream()
						.map(Map.Entry::toString)
						.forEach(System.out::println);

						carreraX = sc.nextInt();
						if(!carreras.containsKey(carreraX)) {
							System.out.println("La carrera no existe");
							break;
						}else {
							auxC2 = carreras.get(carreraX);
						}
						System.out.println("****Equipos****");
						auxC2.equipos.entrySet().stream()
						.map(Map.Entry::getValue)
						.map(Equipo::getNombre)
						.forEach(System.out::println);
						System.out.print("\nEleccion: ");
						eleccion3 = sc.next();
						try {
							auxC2.eliminarEquipo(eleccion3);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						Carrera auxC3 = null; Equipo auxE3 = null; int carreraX2, equipo3;
						System.out.println("****Carreras****");
						carreras.entrySet().stream()
						.map(Map.Entry::toString)
						.forEach(System.out::println);

						carreraX2 = sc.nextInt();
						if(!carreras.containsKey(carreraX2)) {
							System.out.println("La carrera no existe");
							break;
						}else {
							auxC3 = carreras.get(carreraX2);
						}
						
						System.out.println("****Equipos****");
						equipos.entrySet().stream()
						.map(Map.Entry::toString)
						.forEach(System.out::println);
						equipo3 = sc.nextInt();
						if(!equipos.containsKey(equipo3)) {
							System.out.println("El equipo no existe");
							break;
						}else {
							auxE3 = equipos.get(equipo3);
						}
						
						try {
							auxC3.premios();
							auxC3.darPuntos(auxE3);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						System.out.println("****Equipos****");
						equipos.entrySet().stream()
						.map(Map.Entry::toString)
						.forEach(System.out::println);
						break;
					case 6:
						String result = eq1.participantes.entrySet().stream()
						.map(entry -> entry.getValue().getApellidos())
						.collect(Collectors.joining("|"));
						System.out.println(result);
						break;
					case 7:
						Map<Integer, Participante> unidos = 
						Stream.concat(eq1.participantes.entrySet().stream(), eq2.participantes.entrySet().stream())
						.filter(entry -> entry.getValue().getSexo().equals(Sexo.Hombre)&&entry.getValue().getCategoria().equals(Categoria.Senior))
						.collect(Collectors.toMap(
								Map.Entry::getKey,
		                        Map.Entry::getValue));
						System.out.println("Union de "+eq1.getNombre()+" y "+eq2.getNombre());
						unidos.forEach((x, j) -> System.out.println(j.toString()));
						System.out.println();
						break;
					case 8:
						Participante resultado = eq1.participantes.values().stream()
						.min(Comparator.comparing(Participante::getEdad))
						.orElse(null);
						System.out.println(resultado.toString()+"\n");
						break;
					case 9:
						JdbcRowSet rowset = null;
						int option = 0;
						try {
							rowset = RowSetProvider.newFactory().createJdbcRowSet();
							rowset.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/yvr_carreras");
							rowset.setUsername("alumno");
							rowset.setPassword("abc123..");
						}catch(SQLException e) {
							System.out.println(e.getMessage());
						}
						System.out.print("1.Crear Tabla o 2.Insertar registro: ");
						try {
							option = sc.nextInt();
						}catch(InputMismatchException e) {
							System.out.println("Se esperaba un entero");
							sc.next();
							break;
						}
						
						while(option != 1 && option != 2) {
							System.out.print("Opción incorrecta, 1.Crear Tabla o 2.Insertar registro: ");
							option = sc.nextInt();
						}
						if(option == 1) {
							Carrera rc = null; String equipoTop = null; long participaciones = 0;
							try {
								rowset.setCommand("create table resumen("
										+ " 	nombre_carrera varchar(15) not null primary key,"
										+ " 	equipo_top varchar(10) not null,"
										+ " 	participantes_totales int not null,"
										+ " 	fecha_registro date default current_date()"
										+ ")");
								rowset.execute();
								for(Map.Entry<Integer, Carrera> race: carreras.entrySet()) {
									int key = race.getKey();
									rc = carreras.get(key);
									equipoTop = rc.puntosCarrera.entrySet().stream()
											.max(Map.Entry.comparingByValue())
											.map(Map.Entry::getKey)
											.map(Equipo::getNombre)
											.orElse("No hay equipos en la carrera");
									participaciones = rc.puntosCarrera.entrySet().stream().count();
									rowset.setCommand("insert into resumen (nombre_carrera, equipo_top, participantes_totales)\r\n"
											+ "values (?, ?, ?)");
									rowset.setString(1, rc.getNombre());
									rowset.setString(2, equipoTop);
									rowset.setInt(3, (int) participaciones);
									rowset.execute();
								}
								
								
							}catch(SQLException e) {
								System.out.println("La tabla ya existe");
							}
						}else if(option == 2){
							
							try {
								String carreraN, equipoN; int participantesC;
								System.out.print("Nombre Carrera: "); carreraN = sc.next();
								System.out.print("Nombre Equipo: "); equipoN = sc.next();
								System.out.print("Participantes: "); participantesC = sc.nextInt();
								rowset.setCommand("insert into resumen "
										+ "(nombre_carrera, equipo_top, participantes_totales)"
										+ "values (?, ?, ?);");
								rowset.setString(1, carreraN);
								rowset.setString(2, equipoN);
								rowset.setInt(3, participantesC);
								rowset.execute();
							}catch(InputMismatchException e) {
								System.out.println("Se esperaba un entero");
								sc.next();
							}catch(SQLException e) {
								System.out.println(e.getMessage());
							}
						}
					break;				
				}
			}catch(InputMismatchException e) {
				System.out.println("Tipo de dato incorrecto, Saliendo...");
				break;
			}
		}
		sc.close();
	}
}

