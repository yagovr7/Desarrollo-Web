package RowSetE1;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class MainRowSet {
	static public void menu() {
		System.out.println("1.Mostrar Registros");
		System.out.println("2.Número de Personal");
		System.out.println("3.Mostrar Registro por posicion");
		System.out.println("4.Actualizar edad por posicion");
		System.out.println("5.Eliminar último registro");
		System.out.println("6.Insertar Persona");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		Commands root = new Commands();
		JdbcRowSet rowset = null;
		try {
        	rowset = RowSetProvider.newFactory().createJdbcRowSet();
        	rowset.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/yvr_empresa");
        	rowset.setUsername("alumno");
        	rowset.setPassword("abc123..");
        }catch(SQLException e) {
        	System.out.println("Error al conectar");
        }
		
		
		
		do {
			menu();
			opcion=sc.nextInt();
			switch(opcion) {
				case 1:
					try {
						root.mostrarRegistros(rowset);
					}catch(Exception e) {
						System.out.println("Imposible mostrar registros");
					}break;
				case 2:
					try {
						root.Personal(rowset);
					}catch(Exception e) {
						System.out.println("Imposible mostrar registros");
					}break;
				case 3:
					int position;
					System.out.print("Posicion: ");
					position = sc.nextInt();
					try {
						root.posicion(rowset, position);
					}catch(Exception e) {
						System.out.println("Error al encontrar el registro");
					}break;
				case 4:
					try {
						System.out.print("Posicion: ");
						int posicion = sc.nextInt();
						System.out.print("Edad: ");
						int edad = sc.nextInt();
						root.actualizarEdad(rowset, posicion, edad);
					}catch(Exception e) {
						e.printStackTrace();
					}break;
				case 5:
					try {
						root.eliminarRegistro(rowset);
					}catch(Exception e) {
						System.out.println("Error al eliminar el registro");
					}break;
				case 6:
					System.out.print("Nombre: ");
					String nombre = sc.next();
					System.out.print("Apellido: ");
					String apellido = sc.next();
					System.out.print("Edad: ");
					int edad = sc.nextInt();
					try {
						root.insertarPersona(rowset, nombre, apellido, edad);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}break;
			}
			
		}while(opcion!=0);        
        
        
        
        
        
        
        
	}
}
