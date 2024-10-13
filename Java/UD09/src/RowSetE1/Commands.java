package RowSetE1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;

public class Commands {
	public void mostrarRegistros(JdbcRowSet rowset) {
		try {
        	rowset.setCommand("SELECT id,name,lastname,age FROM Person");
        	rowset.execute();
        	while(rowset.next()) {
            	System.out.println("ID: "+rowset.getInt("id")+
            			"\nName: "+rowset.getString("name")+
            			"\nLastName: "+rowset.getString("lastname")+
            			"\nAge: "+rowset.getInt("age")+"\n");
            }
        }catch(SQLException e) {
        	System.out.println("Error al conectar");
        }
	}
	
	public void Personal(JdbcRowSet rowset) {
		int count = 0;
		try {
			rowset.setCommand("SELECT COUNT(*) FROM Person");
			rowset.execute();
			while(rowset.next()) {
				count = rowset.getInt(1);
			}
			System.out.println("Total de personas: "+count+"\n");
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public void posicion(JdbcRowSet rowset, int posicion) {
		Scanner sc = new Scanner(System.in);
		try {
			rowset.setCommand("SELECT * FROM Person");
			rowset.execute();
			rowset.absolute(posicion);
			System.out.println("ID: "+rowset.getInt("id"));
			System.out.println("Nombre: "+rowset.getString("name"));
			System.out.println("Apellido: "+rowset.getString("lastname"));
			System.out.println("Edad: "+rowset.getInt("age"));
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.print("\nPrevio 1 o Siguiente 2: ");
			int eleccion = sc.nextInt();
			if(eleccion==1) {
				rowset.previous();
				System.out.println("ID: "+rowset.getInt("id"));
				System.out.println("Nombre: "+rowset.getString("name"));
				System.out.println("Apellido: "+rowset.getString("lastname"));
				System.out.println("Edad: "+rowset.getInt("age"));
			}else if(eleccion==2){
				rowset.next();
				System.out.println("ID: "+rowset.getInt("id"));
				System.out.println("Nombre: "+rowset.getString("name"));
				System.out.println("Apellido: "+rowset.getString("lastname"));
				System.out.println("Edad: "+rowset.getInt("age"));
			}else {
				System.out.println("Opcion incorrecta");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void actualizarEdad(JdbcRowSet rowset, int posicion, int edad) {
		try {
			rowset.absolute(posicion);
			rowset.updateInt("age", edad);
			rowset.updateRow();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void eliminarRegistro(JdbcRowSet rowset) {
		try {
			rowset.setCommand("SELECT * FROM Person");
			rowset.execute();
			rowset.last();
			rowset.deleteRow();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void insertarPersona(JdbcRowSet rowset, String nombre, String apellido, int edad) {
		int ultima_posicion;
		try {
			rowset.setCommand("SELECT * FROM Person");
			rowset.execute();
			rowset.last();
			ultima_posicion = rowset.getInt("id");
			rowset.moveToInsertRow();
			rowset.updateInt("id", ultima_posicion+1);
			rowset.updateString("name", nombre);
			rowset.updateString("lastname", apellido);
			rowset.updateInt("age", edad);
			rowset.insertRow();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
