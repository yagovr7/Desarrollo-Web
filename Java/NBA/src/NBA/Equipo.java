package NBA;

import java.io.Serializable;
import java.util.TreeMap;

public class Equipo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String localidad;
	private String conferencia;
	TreeMap<Integer,Jugadores> jugadores = new TreeMap<>();
	
	Equipo(String nombre, String localidad, String conferencia) throws Exception{
		this.nombre = nombre;
		this.localidad = localidad;
		if(conferencia == "Oeste" || conferencia == "Este" || conferencia == "oeste" || conferencia == "este") {
			this.conferencia = conferencia;
			
		}else {
			throw new Exception("La conferencia debe ser 'Oeste' o 'Este'");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getConferencia() {
		return conferencia;
	}

	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}
	
	void compararJugador(Jugadores j1, Jugadores j2) {
		if(j1.getSalario()>j2.getSalario()) {
			System.out.println(j1.getNombre()+" tiene un salario mas alto que "+j2.getNombre());
		}else if(j1.getSalario()==j2.getSalario()){
			System.out.println(j1.getNombre()+" y "+j2.getNombre()+" tienen el mismo salario");
		}else {
			System.out.println(j2.getNombre()+" tiene un salario mas alto que "+j1.getNombre());
		}
	}
	
	
	
}
