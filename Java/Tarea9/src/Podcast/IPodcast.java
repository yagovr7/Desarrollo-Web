package Podcast;

import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

public class IPodcast {
	
	Scanner sc = new Scanner(System.in);
	TreeMap<Integer,gen_pod> gen_pod = new TreeMap<>();
	List<gen_pod> gen_pod2 = new ArrayList<>();
	TreeMap<Integer,Generos> generos = new TreeMap<>();
	TreeMap<Integer,Podcast> podcast = new TreeMap<>();
	TreeMap<Integer,Autor> autores = new TreeMap<>();
	
	public void cargarBBDD(JdbcRowSet rowset) {
			try {
				rowset.setCommand("SELECT idPodcast,titulo,tipo,calidad,duracion,periocidad,formato_video,autor FROM Podcast");
				rowset.execute();
				while(rowset.next()) {
					Podcast p = new Podcast();
					p.setIdPodcast(rowset.getInt("idPodcast"));
					p.setTitulo(rowset.getString("titulo"));
					p.setTipo(rowset.getInt("tipo"));
					p.setCalidad(rowset.getString("calidad"));
					p.setDuracion(rowset.getInt("duracion"));
					p.setFormato_video(rowset.getString("formato_video"));
					p.setAutor(rowset.getInt("autor"));
					podcast.put(p.getIdPodcast(), p);
				}
				rowset.setCommand("SELECT * FROM Generos");
				rowset.execute();
				while(rowset.next()) {
					Generos g = new Generos();
					g.setIdGeneros(rowset.getInt(1));
					g.setNombre(rowset.getString(2));
					generos.put(g.getIdGeneros(), g);
				}
				rowset.setCommand("SELECT * FROM gen_pod");
				rowset.execute();
				int key = 1;
				while(rowset.next()) {
					gen_pod p = new gen_pod();
					p.setIdPodcat(rowset.getInt("idPodcat"));
					p.setIdGenero(rowset.getInt("idGenero"));
					gen_pod.put(key, p);
					gen_pod2.add(p);
					key+=1;
				}
				rowset.setCommand("SELECT * FROM Autor");
				rowset.execute();
				while(rowset.next()) {
					Autor a = new Autor();
					a.setIdAutor(rowset.getInt("idAutor"));
					a.setDni(rowset.getString("dni"));
					a.setApellidos(rowset.getString("apellidos"));
					a.setNombre(rowset.getString("nombre"));
					autores.put(a.getIdAutor(), a);
				}
			}catch(SQLException e) {
				System.out.println("Imposible actualizar el genero");
			}
	}
	
	public void agregarPodcast(JdbcRowSet rowset) {
		int idPodcast, tipo, duracion, autor;
		String titulo, calidad, periocidad, formato_video;
		
		try {
			rowset.setCommand("SELECT * FROM Podcast");
			rowset.execute();
			rowset.last();
			idPodcast = rowset.getInt("idPodcast")+1;
			System.out.print("Tipo 0 audio 1 video: ");tipo = sc.nextInt();
			if(tipo==0) {
				System.out.print("Titulo: ");titulo = sc.next();
				System.out.print("Calidad: ");calidad = sc.next();calidad = calidad+" Kbps";
				System.out.print("Duración: ");duracion = sc.nextInt();
				System.out.print("Periocidad: ");periocidad = sc.next();
				formato_video = null;
				System.out.print("ID Autor: ");autor = sc.nextInt();
				rowset.moveToInsertRow();
				rowset.updateInt(1, idPodcast);
				rowset.updateString(2, titulo);
				rowset.updateInt(3, tipo);
				rowset.updateString(4, calidad);
				rowset.updateInt(5, duracion);
				rowset.updateString(6, periocidad);
				rowset.updateString(7, formato_video);
				if(autores.containsKey(autor)) {
					rowset.updateInt(8, autor);
				}else {
					System.out.println("El autor no existe");
				}
				rowset.insertRow();
			}else if(tipo==1) {
				System.out.print("Titulo: ");titulo = sc.next();
				calidad = null;
				System.out.print("Duración: ");duracion = sc.nextInt();
				System.out.print("Periocidad: ");periocidad = sc.next();
				System.out.print("Formato/Video: ");formato_video = sc.next();
				System.out.print("ID Autor: ");autor = sc.nextInt();
				rowset.moveToInsertRow();
				rowset.updateInt(1, idPodcast);
				rowset.updateString(2, titulo);
				rowset.updateInt(3, tipo);
				rowset.updateString(4, calidad);
				rowset.updateInt(5, duracion);
				rowset.updateString(6, periocidad);
				rowset.updateString(7, formato_video);
				if(autores.containsKey(autor)) {
					rowset.updateInt(8, autor);
				}else {
					System.out.println("El autor no existe");
				}
				rowset.insertRow();
			}
		}catch(SQLException e) {
			System.out.println("Imposible agregar el podcast, es posible que exista");
		}
	}
	
	public void darAltaGenero(JdbcRowSet rowset, String nombre) {
		int idUltimo;
		try {
			rowset.setCommand("SELECT * FROM Generos");
			rowset.execute();
			rowset.last();
			idUltimo = rowset.getInt("idGeneros");
			rowset.moveToInsertRow();
			rowset.updateInt(1, idUltimo+1);
			rowset.updateString(2, nombre);
			rowset.insertRow();
		}catch(SQLException e) {
			System.out.println("Imposible dar del alta el género");
		}
	}
	
	public void actualizarGeneros(JdbcRowSet rowset) {
		int count = 1;
		int eleccion;
		System.out.print("1.Actualizar o 2 Insertar: ");
		eleccion = sc.nextInt();
		if(eleccion==1) {
			try {
				for(gen_pod x: gen_pod2) {
					System.out.println(count+".- idPodcat: "+x.getIdPodcat()+" idGenero: "+x.getIdGenero());
					count+=1;
				}
				System.out.println("Seleccione: ");
				int seleccion = sc.nextInt();
				if(gen_pod.containsKey(seleccion)) {
					rowset.absolute(seleccion);
				}
				System.out.print("Actualizar Genero: ");
				int genero = sc.nextInt();
				if(generos.containsKey(genero)) {
					rowset.updateObject(2, genero);
					rowset.updateRow();
				}
				rowset.updateInt(2, seleccion);
			}catch(SQLException e) {
				System.out.println("Imposible actualizar el genero");
			}
		}else if(eleccion==2) {
			try {
				rowset.moveToInsertRow();
				System.out.print("idPodcast: ");
				int idP = sc.nextInt();
				if(podcast.containsKey(idP)) {
					System.out.print("idGenero: ");
					int idG = sc.nextInt();
					if(generos.containsKey(idG)) {
						rowset.updateInt(1, idP);
						rowset.updateInt(2, idG);
						rowset.insertRow();
					}else {
						System.out.println("El genero no existe");
					}
				}else {
					System.out.println("El podcast no existe");
				}
			}catch(SQLException e) {
				System.out.println("Imposible insertar el genero al podcast, puede que ya exista");
			}
		}else {
			System.out.println("Eleccion incorrecta");
		}
		
	}
	
	public void eliminarPodcast(JdbcRowSet rowset) {
		try {
			rowset.setCommand("SELECT * FROM Podcast");
			rowset.execute();
			System.out.print("ID del podcast: ");
			int id = sc.nextInt();
			if(podcast.containsKey(id)) {
				rowset.setCommand("SELECT * FROM gen_pod WHERE idPodcat=?");
				rowset.setInt(1, id);
				rowset.execute();
				while(rowset.next()) {
					rowset.deleteRow();
				}
				rowset.setCommand("SELECT * FROM Podcast WHERE idPodcast=?");
				rowset.setInt(1, id);
				rowset.execute();
				while(rowset.next()) {
					rowset.deleteRow();
				}
			}else {
				System.out.println("El podcast no existe");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void visualizarAllPodcast(JdbcRowSet rowset) {
		try {
			rowset.setCommand("SELECT idPodcast,titulo,tipo,calidad,duracion,periocidad,formato_video,autor FROM Podcast");
			rowset.execute();
			
			while(rowset.next()) {
				if(rowset.getInt("tipo")==0) {
					System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
					System.out.println("Titulo: "+rowset.getString("titulo"));
					System.out.println("Tipo: Audio");
					System.out.println("Calidad: "+rowset.getString("calidad"));
					System.out.println("Duración: "+rowset.getInt("duracion"));
					System.out.println("Periocidad: "+rowset.getString("periocidad"));
					System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
				}else {
					System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
					System.out.println("Titulo: "+rowset.getString("titulo"));
					System.out.println("Tipo: Video");
					System.out.println("Duración: "+rowset.getInt("duracion"));
					System.out.println("Periocidad: "+rowset.getString("periocidad"));
					System.out.println("Formato/Video: "+rowset.getString("formato_video"));
					System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
				}
					
			}
		}catch(SQLException e) {
			System.out.println("Imposible visualizar los podcast");
		}
	}
	
	public void visualizarPodcast(JdbcRowSet rowset, int posicion) {
		Podcast p = new Podcast();
		try {
				if(podcast.containsKey(posicion)) {
					rowset.absolute(posicion);
				}else {
					System.out.println("El podcast no existe");
				}
				
				if(rowset.getInt("tipo")==0) {
					System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
					System.out.println("Titulo: "+rowset.getString("titulo"));
					System.out.println("Tipo: Audio");
					System.out.println("Calidad: "+rowset.getString("calidad"));
					System.out.println("Duración: "+rowset.getInt("duracion"));
					System.out.println("Periocidad: "+rowset.getString("periocidad"));
					System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
				}else {
					System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
					System.out.println("Titulo: "+rowset.getString("titulo"));
					System.out.println("Tipo: Video");
					System.out.println("Duración: "+rowset.getInt("duracion"));
					System.out.println("Periocidad: "+rowset.getString("periocidad"));
					System.out.println("Formato/Video: "+rowset.getString("formato_video"));
					System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
				}
				
				int opcion;
				do {
					System.out.print("Previo 1, Siguiente 2 o Ninguno 0 :");
					opcion = sc.nextInt();
					if(opcion==1){
						rowset.previous();
						if(rowset.getInt("tipo")==0) {
							System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
							System.out.println("Titulo: "+rowset.getString("titulo"));
							System.out.println("Tipo: Audio");
							System.out.println("Calidad: "+rowset.getString("calidad"));
							System.out.println("Duración: "+rowset.getInt("duracion"));
							System.out.println("Periocidad: "+rowset.getString("periocidad"));
							System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
						}else {
							System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
							System.out.println("Titulo: "+rowset.getString("titulo"));
							System.out.println("Tipo: Video");
							System.out.println("Duración: "+rowset.getInt("duracion"));
							System.out.println("Periocidad: "+rowset.getString("periocidad"));
							System.out.println("Formato/Video: "+rowset.getString("formato_video"));
							System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
						}
						}else if(opcion==2){
							rowset.next();
							if(rowset.getInt("tipo")==0) {
								System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
								System.out.println("Titulo: "+rowset.getString("titulo"));
								System.out.println("Tipo: Audio");
								System.out.println("Calidad: "+rowset.getString("calidad"));
								System.out.println("Duración: "+rowset.getInt("duracion"));
								System.out.println("Periocidad: "+rowset.getString("periocidad"));
								System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
							}else {
								System.out.println("idPodcast: "+rowset.getInt("idPodcast"));
								System.out.println("Titulo: "+rowset.getString("titulo"));
								System.out.println("Tipo: Video");
								System.out.println("Duración: "+rowset.getInt("duracion"));
								System.out.println("Periocidad: "+rowset.getString("periocidad"));
								System.out.println("Formato/Video: "+rowset.getString("formato_video"));
								System.out.println("idAutor: "+rowset.getInt("autor")+"\n");
							}
						}
				}while(opcion!=0);
		}catch(SQLException e) {
			System.out.println("Imposible visualizar el podcast");
		}
	}
}
