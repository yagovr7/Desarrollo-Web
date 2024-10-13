package Centro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Alumnos extends CentroAcademico{
	private String expediente;
	private String nombre;
	private Integer media;
	List<Asignaturas> asignaturasM = new ArrayList<>();
	HashMap<Asignaturas, Double> calificaciones = new HashMap<>();
	
	Alumnos(String e, String n){
		this.expediente = e;
		this.nombre = n;
	}

	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getMedia() {
		return media;
		
	}

	public void setMedia(Integer media) {
		this.media = media;
		
	}
	
	public int notaMedia() {
		int resultado = 0;
		Set<Asignaturas> calificaciones = this.calificaciones.keySet();
		Iterator<Asignaturas> it = calificaciones.iterator();
		 
		while (it.hasNext()) {
			Asignaturas key = it.next();
		    Double calificacion = this.calificaciones.get(key);
		    resultado = resultado+=calificacion.doubleValue();
		    
		}
		if(this.calificaciones.size()==0) {
			return this.media = 0;
		}else {
			this.media = resultado/this.calificaciones.size();
			return this.media;
		}
		
	}
	
	
}
