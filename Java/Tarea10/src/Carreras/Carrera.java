package Carreras;

import java.util.Scanner;
import java.util.TreeMap;

public class Carrera {
	private String nombre;
	private String fecha;
	private double kilometros;
	TreeMap<Integer, Integer> premios = new TreeMap<>();
	TreeMap<String, Equipo> equipos = new TreeMap<>();
	TreeMap<Equipo, Integer> puntosCarrera = new TreeMap<>();
	Scanner sc = new Scanner(System.in);
	public Carrera(String nombre, String fecha, double kilometros) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.kilometros = kilometros;
		premios.put(1, 25);
		premios.put(2, 18);
		premios.put(3, 15);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	
	public void AltaEquipo(Equipo eq) throws Exception {
		if(!this.equipos.containsKey(eq.getNombre())) {
			this.equipos.put(eq.getNombre(), eq);
			System.out.println("Equipo "+eq.getNombre()+" dado de Alta en "+this.getNombre());
		}else {
			throw new Exception("El equipo ya está registrado");
		}
	}
	
	public int compareTo(Carrera otraCarrera) {
        return this.fecha.compareTo(otraCarrera.fecha);
    }
	
	public void eliminarEquipo(String eq) throws Exception {
		if(this.equipos.containsKey(eq)) {
			this.equipos.remove(eq);
			System.out.println("Equipo Eliminado");
		}else {
			throw new Exception("El equipo no está registrado");
		}
	}
	
	public void premios() {
		premios.entrySet().stream()
		.forEach((x) -> System.out.println("Premio "+x.getKey()+": "+x.getValue()+" Puntos"));
	}

	public String toString() {
		return "\nNombre: " + nombre + "\nFecha: " + fecha + "\nKilometros:  " + kilometros + " Km\n";
	}
	
	public void darPuntos(Equipo eq) {
		int actuales = 0;
		int nuevo;
		if(this.equipos.containsKey(eq.getNombre())) {
			actuales = this.puntosCarrera.get(eq);
				int premio;
				do {
					System.out.print("Premio elegido: ");
					premio = sc.nextInt();
					
				}while(premio!=1&&premio!=2&&premio!=3);
				nuevo = actuales + this.premios.get(premio);
				this.puntosCarrera.put(eq, nuevo);
				eq.setPuntos(eq.getPuntos()+this.premios.get(premio));
				
		}else {
			System.out.println("El equipo no está registrado");
		}
	}
	
	public void asignarPuntos(Equipo eq, int puntos) {
		int actuales = eq.getPuntos();
		int nuevos = actuales + puntos;
		eq.setPuntos(nuevos);
		this.puntosCarrera.put(eq, puntos);
	}
	
	
}
