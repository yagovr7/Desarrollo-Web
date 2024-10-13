package Centro;

public interface CentroInterfaz {
	boolean crearAlumno(String expediente, String nombre) throws Exception;
	boolean crearAsignatura(String codigo, String nombre, String creditos) throws Exception;
	boolean matricular(String expediente, String codigo) throws Exception;
	void imprimirAlumno(String expediente);
	void imprimirAlumnos();
	void imprimirAsignatura(String codigo) throws ExcepcionesCA;
	boolean agregarCalificacion(String expediente, String codigo, double calificacion) throws Exception;
	void compararAlumno (String expediente1, String expediente2);
}
