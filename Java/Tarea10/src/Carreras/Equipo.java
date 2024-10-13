package Carreras;

import java.util.TreeMap;

public class Equipo implements Comparable<Equipo>{
	private String nombre;
	private int puntos = 0;
	Participante capitan;
	TreeMap<Integer, Participante> participantes = new TreeMap<>();
	
	
	public Equipo(String nombre, Participante capitan) {
		this.nombre = nombre;
		this.capitan = capitan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public int compareTo(Equipo otroEquipo) {
        return Integer.compare(this.puntos, otroEquipo.puntos);
    }
	
	public void AltaParticipante(int dorsal, String n, String a, String s, int e) throws Exception {
		Participante p = new Participante(n, a, s, e);
		if(this.participantes.containsKey(dorsal)) {
			throw new Exception("El participante "+p.getNombre()+" consta en el equipo "+this.getNombre());
		}else {
			this.participantes.put(dorsal, p);
			System.out.println("Participante dado de alta\n");
		}
	}

	public String toString() {
		return "\nNombre: " + nombre + "\nPuntos: " + this.puntos + "\nCapitan: " + capitan.getNombre() + "\n";
	}
	
	
}
