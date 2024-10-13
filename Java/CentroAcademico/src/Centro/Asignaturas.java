package Centro;
import java.util.ArrayList;
import java.util.List;

public class Asignaturas extends CentroAcademico{
	private String codigo;
	private String nombre;
	private String creditos;
	List<Alumnos> matriculados = new ArrayList<>();
	
	Asignaturas(String k, String n, String c){
		this.codigo = k;
		this.nombre = n;
		this.creditos = c;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}
	
	
}
