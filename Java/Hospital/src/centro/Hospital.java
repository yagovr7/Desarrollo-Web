package centro;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;

public class Hospital implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		TreeMap<Integer, Medico> medicos = new TreeMap<>();
		TreeMap<Integer, Paciente> pacientes = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		int opcion = 99, dni;
		
		Medico med1 = new Medico(1, "Yago", "Vila Rama");
		Medico med2 = new Medico(2, "Claudia", "Garrido Lamas");
		medicos.put(med1.getDni(), med1);
		medicos.put(med2.getDni(), med2);
		
		Paciente p1 = new Paciente(3, Sexo.H, 1, 5);
		Paciente p2 = new Paciente(4, Sexo.H, 2, 2);
		Paciente p3 = new Paciente(5, Sexo.M, 3);
		Paciente p4 = new Paciente(6, Sexo.H, 1, 8);
		Paciente p5 = new Paciente(7, Sexo.M, 2);
		pacientes.put(p1.getDni(), p1);
		pacientes.put(p2.getDni(), p2);
		pacientes.put(p3.getDni(), p3);
		pacientes.put(p4.getDni(), p4);
		pacientes.put(p5.getDni(), p5);
		
		med1.pacientes.put(p1.getDni(), p1);
		med1.pacientes.put(p2.getDni(), p2);
		med1.pacientes.put(p3.getDni(), p3);
		
		med2.pacientes.put(p4.getDni(), p4);
		med2.pacientes.put(p5.getDni(), p5);
		while(opcion != 0) {
			System.out.println("1.Alta Médico");
			System.out.println("2.Alta Paciente");
			System.out.println("3.Asignar Paciente");
			System.out.println("4.Informe Médico");
			System.out.println("5.Cargar en BBDD");
			System.out.println("6.Fichero.txt");
			try {
				opcion = sc.nextInt();
				switch(opcion) {
					case 0:
						System.exit(1);
					case 1:
							String nombre, apellidos;
							System.out.print("DNI: ");
							dni = sc.nextInt();
							if(pacientes.containsKey(dni) || medicos.containsKey(dni)) {
								throw new Exception("El dni ya consta en la base de datos");
							}
							System.out.print("Nombre: ");
							nombre = sc.next();
							System.out.print("Apellidos: ");
							sc.nextLine();
							apellidos = sc.nextLine();
							medicos.put(dni, new Medico(dni, nombre, apellidos));
					break;
					case 2:
						int grado, habitacion;
						String aux;
						Sexo sexo = null;
						System.out.print("1.Urgente o 2. No Urgente");
						try {
							opcion = sc.nextInt();
							if(opcion == 1) {
								System.out.print("DNI: ");
								dni = sc.nextInt();
								if(pacientes.containsKey(dni) || medicos.containsKey(dni)) {
									throw new Exception("El dni ya consta en la base de datos");
								}
								do {
									System.out.print("Sexo H o M: ");
									aux = sc.next();
									if(aux.equals("H")) {
										sexo = Sexo.H;
									}else if(aux.equals("M")) {
										sexo = Sexo.M;
									}
								}while(!aux.equals("H") && !aux.equals("M"));
								do {
									System.out.print("Grado (1,2,3): ");
									grado = sc.nextInt();
								}while(grado != 1 && grado != 2 && grado != 3);
								pacientes.put(dni, new Paciente(dni, sexo, grado));
							}else if(opcion == 2) {
								System.out.print("DNI: ");
								dni = sc.nextInt();
								if(pacientes.containsKey(dni) || medicos.containsKey(dni)) {
									throw new Exception("El dni ya consta en la base de datos");
								}
								do {
									System.out.print("Sexo H o M: ");
									aux = sc.next();
									if(aux.equals("H")) {
										sexo = Sexo.H;
									}else if(aux.equals("M")) {
										sexo = Sexo.M;
									}
								}while(!aux.equals("H") && !aux.equals("M"));
								do {
									System.out.print("Grado (1,2,3): ");
									grado = sc.nextInt();
								}while(grado != 1 && grado != 2 && grado != 3);
								System.out.print("Habitación: ");
								habitacion = sc.nextInt();
								pacientes.put(dni, new Paciente(dni, sexo, grado, habitacion));
							}else {
								throw new Exception("Opción incorrecta!!!");
							}
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					break;
					case 3:
						int dniPaciente;
						System.out.println("****Médicos****");
						medicos.entrySet().stream()
						.map(e -> e.getValue().toString())
						.forEach(entrySet -> System.out.println(entrySet+"\n"));
						//medicos.entrySet().stream()
						//.map(Map.Entry::getValue)
						//.forEach(System.out::println);9
						System.out.print("\nDNI: ");
						dni = sc.nextInt();
						if(medicos.containsKey(dni)) {
							System.out.println("****Pacientes****");
							pacientes.entrySet().stream().map(x->x.getValue().toString())
							.forEach(x -> System.out.println(x+"\n"));
							System.out.print("\nDNI: ");
							dniPaciente = sc.nextInt();
							for(Map.Entry<Integer, Medico> x: medicos.entrySet()) {
								if(x.getValue().pacientes.containsKey(dniPaciente)) {
									throw new Exception("El paciente ya esta asignado");
								}else {
									if(pacientes.containsKey(dniPaciente)) {
										medicos.get(dni).pacientes.put(dniPaciente, pacientes.get(dniPaciente));
									}else {
										throw new Exception("El paciente no existe");
									}
								}
							}
							
						}else {
							throw new Exception("El medico no existe");
						}
					break;
					case 4:
						for(Map.Entry<Integer, Medico> x: medicos.entrySet()) {
							if(x.getValue().pacientes.isEmpty()){
								continue;
							}else {
								System.out.println("Medico: "+x.getValue().getNombre()+" nºpacientes: "+x.getValue().pacientes.size());
								System.out.println("Grado 1: ");
								x.getValue().pacientes.entrySet().stream()
								.filter(entry -> entry.getValue().getGrado()==1)
								.forEach(entry -> System.out.println(entry.getValue().toString()+"\n"));
								System.out.println("Grado 2: ");
								x.getValue().pacientes.entrySet().stream()
								.filter(entry -> entry.getValue().getGrado()==2)
								.forEach(entry -> System.out.println(entry.getValue().toString()+"\n"));
								System.out.println("Grado 3: ");
								x.getValue().pacientes.entrySet().stream()
								.filter(entry -> entry.getValue().getGrado()==3)
								.forEach(entry -> System.out.println(entry.getValue().toString()+"\n"));
							}
							
						}
					break;
					case 5:
						JdbcRowSet row;
						try {
							for(Map.Entry<Integer, Medico> x: medicos.entrySet()){
								row = RowSetProvider.newFactory().createJdbcRowSet();
								row.setUrl("jdbc:mysql://localhost:3306/hospital");
								row.setUsername("root");
								row.setCommand("insert into medicos (dni, nombre, apellidos) values (?,?,?)");
								row.setInt(1, x.getKey());
								row.setString(2, x.getValue().getNombre());
								row.setString(3, x.getValue().getApellidos());
								row.execute();
							}
							
						}catch(SQLException e) {
							System.out.println(e.getMessage());
						}
						try {
							row = RowSetProvider.newFactory().createJdbcRowSet();
							row.setUrl("jdbc:mysql://localhost:3306/hospital");
							row.setUsername("root");
							for(Map.Entry<Integer, Medico> x: medicos.entrySet()){
								for(Map.Entry<Integer, Paciente> p: x.getValue().pacientes.entrySet()) {
									if(p.getValue().getNivel().equals(Nivel.Urgente)) {
										row.setCommand("insert into resumen (dniPaciente, sexo, nivel, grado, habitacion, ingreso, dni, nombre) values (?,?,?,?,0,?,?,?)");
										row.setInt(1, p.getKey());
										row.setString(2, p.getValue().getSexo().toString());
										row.setString(3, p.getValue().getNivel().toString());
										row.setInt(4, p.getValue().getGrado());
										row.setDate(5, Date.valueOf(p.getValue().getIngreso()));
										row.setInt(6, x.getKey());
										row.setString(7, x.getValue().getNombre());
										row.execute();
									}else {
										row.setCommand("insert into resumen (dniPaciente, sexo, nivel, grado, habitacion, ingreso, dni, nombre) values (?,?,?,?,?,null,?,?)");
										row.setInt(1, p.getKey());
										row.setString(2, p.getValue().getSexo().toString());
										row.setString(3, p.getValue().getNivel().toString());
										row.setInt(4, p.getValue().getGrado());
										row.setInt(5, p.getValue().getNumHabitacion());
										row.setInt(6, x.getKey());
										row.setString(7, x.getValue().getNombre());
										row.execute();
									}
									
								}
								
							}
						}catch(SQLException e) {
							System.out.println(e.getMessage());
						}
					break;
					case 6:
						try(BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))){
							for(Map.Entry<Integer, Medico> x: medicos.entrySet()) {
								writer.write(x.getKey()+", "+x.getValue().getNombre()+", "+x.getValue().getApellidos());
								writer.newLine();
							}
						}
						try (BufferedReader read = new BufferedReader(new FileReader("test.txt"))){
							String line = read.readLine();
							while(line != null) {
								System.out.println(line);
								line = read.readLine();
							}
						}
							try {
								ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("test.tt"));								
								ObjectInputStream input = new ObjectInputStream(new FileInputStream("test.tt"));
								output.writeObject(med1);
								output.writeObject(med2);
								output.close();
								
								
								while(true) {
									try {
										Medico med = (Medico) input.readObject();
										System.out.println(med.getNombre());
									}catch(EOFException e) {
										break;
									}
									
								}
								input.close();
							}catch(IOException e) {
								System.out.println(e.getMessage());
							}
							try {
								row = RowSetProvider.newFactory().createJdbcRowSet();
								row.setUrl("jdbc:mysql://localhost:3306/hospital");
								row.setUsername("root");
								row.setCommand("SELECT * FROM resumen");
								row.execute();
								while(row.next()) {
									System.out.println("DNI Paciente: "+row.getInt("dniPaciente"));
								}
								System.out.println();
							}catch(SQLException e){
								System.out.println(e.getMessage());
							}
					break;
				}
			}catch(InputMismatchException imm) {
				System.out.println("Entrada de datos incorrecta");
				System.exit(1);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}
}
