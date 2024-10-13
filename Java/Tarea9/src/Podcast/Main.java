package Podcast;

import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class Main {
	static public void menu() {
		System.out.println("\n1.Agregar Podcast");
		System.out.println("2.Dar de alta nuevo género");
		System.out.println("3.Actualizar género de podcast");
		System.out.println("4.Eliminar podcast");
		System.out.println("5.Visualizar todos los podcast");
		System.out.println("6.Visualizar podcast");
		System.out.println("0.Exit");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		IPodcast root = new IPodcast();
		JdbcRowSet rowset = null;
		try {
			rowset = RowSetProvider.newFactory().createJdbcRowSet();
			rowset.setUrl("jdbc:mysql://dbalumnos.sanclemente.local:3319/yvr_podcast_bd");
			rowset.setUsername("alumno");
			rowset.setPassword("abc123..");
		}catch(SQLException e) {
			System.out.println("Error al conectar a la BBDD");
		}
		root.cargarBBDD(rowset);
		
		do {
			menu();
			opcion = sc.nextInt();
			
			switch(opcion) {
			case 0:
				try {
					rowset.close();
					System.exit(1);
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}break;
				case 1:
					try {
						root.agregarPodcast(rowset);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}break;
				case 2:
					System.out.print("Nombre del género: ");
					String nombre = sc.next();
					try {
						root.darAltaGenero(rowset, nombre);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}break;
				case 3:
					try {
						root.actualizarGeneros(rowset);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}break;
				case 4:
					try {
						root.eliminarPodcast(rowset);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}break;
				case 5:
					try {
						root.visualizarAllPodcast(rowset);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}break;
				case 6:
					int posicion;
					System.out.println("Posicion del podcast: ");
					posicion = sc.nextInt();
					try {
						root.visualizarPodcast(rowset, posicion);
					}catch(Exception e){
						System.out.println("Valor no esperado");
						break;
					}break;
			}
		}while(opcion!=0);
		
	}
}
