package NBA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class NBA {
	ArrayList<Jugadores> jugadores = new ArrayList<>();
	TreeMap<String, Equipo> equipos = new TreeMap<>();
	TreeMap<String, Equipo> oeste = new TreeMap<>();
	TreeMap<String, Equipo> este = new TreeMap<>();
	
	public void mostrarEquipos() {
		Set<String> setCodes = equipos.keySet();
		Iterator<String> it = setCodes.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			Equipo equipo = equipos.get(key);
			System.out.println("\n****EQUIPO****");
			System.out.print("Nombre: "+equipo.getNombre()
			+" Localidad: "+equipo.getLocalidad()
			+" Conferencia: "+equipo.getConferencia());
			
			Set<Integer> setCode = equipo.jugadores.keySet();
			Iterator<Integer> iterator = setCode.iterator();
			System.out.println("\n****JUGADORES****");
			while(iterator.hasNext()) {
				int clave = iterator.next();
				if(equipo.jugadores.get(clave) instanceof Veterano) {
					Veterano auxV = (Veterano) equipo.jugadores.get(clave);
					System.out.print("Nombre: "+auxV.getNombre()+" Dorsal: "+auxV.getDorsal()
					+" Salario: "+String.format("%.2f", auxV.getSalario())+" €"+" Experiencia: "+auxV.anos+" Último equipo: "
					+auxV.ultimo_equipo.getNombre()+"\n");
				}else {
					Rookie auxR = (Rookie) equipo.jugadores.get(clave);
					System.out.print("Nombre: "+auxR.getNombre()+" Dorsal: "+auxR.getDorsal()
					+" Salario: "+String.format("%.2f", auxR.getSalario())+" €"+" Numero del Draft: "+auxR.num_draft+"\n");
				}
			}
			System.out.println();
		}
	}
	
	public void agregarJugador(String nomE, String nombre, int dorsal, double salario, int anos, Equipo ultimo_equipo) throws Exception {
		Veterano veterano = new Veterano(nombre, dorsal, salario, anos, ultimo_equipo);
		Equipo aux = equipos.get(nomE);
		if(aux.jugadores.size() == 15) {
			throw new Exception("\nEQUIPO COMPLETO\n");
		}
		if(equipos.get(nomE).jugadores.containsKey(veterano.getDorsal())) {
			throw new Exception("El jugador ya pertenece al equipo");
		}else {
			equipos.get(nomE).jugadores.put(veterano.getDorsal(), veterano);
		}
		if(jugadores.contains(veterano)) {
			throw new Exception("Este jugador ya existe");
		}else {
			jugadores.add(veterano);
		}
		
	}
	
	public void agregarJugador(String nomE, String nombre, int dorsal, double salario, int num_draft) throws Exception {
		int rookies = 0;
		Equipo aux = equipos.get(nomE);
		if(aux.jugadores.size() == 15) {
			throw new Exception("\nEQUIPO COMPLETO\n");
		}
		Set<Integer> setCodes = equipos.get(nomE).jugadores.keySet();
		Iterator<Integer> it = setCodes.iterator();
		
		while(it.hasNext()) {
			int key = it.next();
			Jugadores player = equipos.get(nomE).jugadores.get(key);
			if(player instanceof Rookie) {
				rookies+=1;
			}
		}
		if(rookies == 3) {
			throw new Exception("Máxima cantidad de Rookies");
		}
		Rookie rookie = new Rookie(nombre, dorsal, salario,num_draft);
		if(equipos.get(nomE).jugadores.containsKey(rookie.getDorsal())) {
			throw new Exception("El jugador ya pertenece al equipo");
		}else {
			equipos.get(nomE).jugadores.put(rookie.getDorsal(), rookie);
		}
		if(jugadores.contains(rookie)) {
			throw new Exception("Este jugador ya existe");
		}else {
			jugadores.add(rookie);
		}
	}
	
	public void consultarEquipo(String nombre) throws Exception {
		Equipo aux = equipos.get(nombre);
		double salarioTotal = 0;
		if(equipos.containsKey(nombre)) {
			System.out.println("\n****EQUIPO****");
			System.out.print("Nombre: "+aux.getNombre()
			+" Localidad: "+aux.getLocalidad()
			+" Conferencia: "+aux.getConferencia());
			Set<Integer> setCode = aux.jugadores.keySet();
			Iterator<Integer> iterator = setCode.iterator();
			System.out.println("\n****JUGADORES****");
			while(iterator.hasNext()) {
				int clave = iterator.next();
				if(aux.jugadores.get(clave) instanceof Veterano) {
					Veterano auxV = (Veterano) aux.jugadores.get(clave);
					System.out.print("Nombre: "+auxV.getNombre()+" Dorsal: "+auxV.getDorsal()
					+" Salario: "+String.format("%.2f", auxV.getSalario())+" €"+" Experiencia: "+auxV.anos+" Último equipo: "
					+auxV.ultimo_equipo.getNombre());
					salarioTotal+=auxV.getSalario();
				}else {
					Rookie auxR = (Rookie) aux.jugadores.get(clave);
					System.out.print("Nombre: "+auxR.getNombre()+" Dorsal: "+auxR.getDorsal()
					+" Salario: "+String.format("%.2f", auxR.getSalario())+" €"+" Numero del Draft: "+auxR.num_draft);
					salarioTotal+=auxR.getSalario();
				}
				System.out.println();
			}
			System.out.println("Total de jugadores: "+aux.jugadores.size());
			System.out.printf("Salario total: %.2f €\n\n", salarioTotal);
		}else {
			throw new Exception("El equipo no existe");
		}
	}
	
	public void dividirConferencia() {
		
		Set<String> setCodes1 = equipos.keySet();
		Iterator<String> it1 = setCodes1.iterator();
		while(it1.hasNext()) {
			String key = it1.next();
			Equipo equipo = equipos.get(key);
			
			if(equipo.getConferencia() == "Oeste") {
				oeste.put(key, equipo);
			}else if(equipo.getConferencia() == "Este") {
				este.put(key, equipo);
			}
		}
		System.out.println("****CONFERENCIA ESTE****");
		Set<String> setCodes2 = este.keySet();
		Iterator<String> it2 = setCodes2.iterator();
		
		while(it2.hasNext()) {
			String key = it2.next();
			Equipo eq = este.get(key);
			System.out.println("Nombre: "+eq.getNombre()+" Localidad: "
			+eq.getLocalidad()+" Conferencia: "+eq.getConferencia());	
		}
		
		System.out.println("****CONFERENCIA OESTE****");
		Set<String> setCodes3 = oeste.keySet();
		Iterator<String> it3 = setCodes3.iterator();
		
		while(it3.hasNext()) {
			String key = it3.next();
			Equipo eq = oeste.get(key);
			System.out.println("Nombre: "+eq.getNombre()+" Localidad: "
			+eq.getLocalidad()+" Conferencia: "+eq.getConferencia());	
		}
	}
	
	public void generarFichero() throws IOException {
		File f = new File("resumen.txt");
		try (FileWriter fw = new FileWriter(f)) {
			Set<String> setCodes = equipos.keySet();
			Iterator<String> it = setCodes.iterator();
			
			while(it.hasNext()) {
				String key = it.next();
				Equipo equipo = equipos.get(key);
				fw.write(equipo.getNombre());
				fw.write(":");
				fw.write(equipo.getLocalidad());
				fw.write(":");
				fw.write(equipo.getConferencia());
				fw.write("\n");
			}
		}
	}
}
