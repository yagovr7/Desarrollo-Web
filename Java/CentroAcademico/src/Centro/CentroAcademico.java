package Centro;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class CentroAcademico implements CentroInterfaz{
	TreeMap<String,Alumnos> alumnos = new TreeMap<>();
	TreeMap<String,Asignaturas> asignaturas = new TreeMap<>();
	private static final String LETRAS_DNI= "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public char calcularLetra(int numero){
		//simplificamos y suponemos que que el valor es correcto y estÃƒÂ¡ entre 1 99999999
		return LETRAS_DNI.charAt(numero%23);
	 }
	
	public boolean crearAlumno(String e, String n) throws Exception {
		if(alumnos.containsKey(e)) {
			System.out.println("El id "+"'"+e+"'"+" ya existe");
			return false;
		}
		boolean comprobar = Pattern.matches("([0-9]{1,8})([A-Za-z])", e);
		boolean nombre = Pattern.matches("[a-zA-Z]+", n);
		Pattern pattern =Pattern.compile("([0-9]{1,8})([A-Za-z])");
	    Matcher matcher = pattern.matcher(e);
	    int numero=Integer.parseInt(e.substring(0, e.length()-1)); // Extrae el grupo de caracteres que coincide con el patrón
	    char letraStringEntrada=e.charAt(e.length()-1);
		if(comprobar!=true) {
			throw new Exception("Error: el DNI debe tener 8 numeros y una letra");
		}else if(letraStringEntrada!=calcularLetra(numero)) {
			throw new Exception("Error: la letra del DNI es incorrecta");
		}else if(nombre!=true) {
			throw new Exception("El nombre solo debe contener letras");
		}
		alumnos.put(e, new Alumnos(e, n));
		return true;
	}
	
	public boolean crearAsignatura(String k, String n, String c) throws Exception {
		if(asignaturas.containsKey(k)) {
			System.out.println("La asignatura con id "+"'"+k+"'"+" ya existe");
			return false;
		}else {
			boolean key = Pattern.matches("([A-Z])-([0-9]{1,3})", k);
			boolean nombre = Pattern.matches("[a-zA-Z]+", n);
			boolean credito = Pattern.matches("[\\d]+", c);
			if(key!=true) {
				throw new Exception("Error: el codigo debe tener este formato 'A-111'");
			}else if(nombre!=true) {
				throw new Exception("El nombre solo debe contener letras");
			}else if(Integer.parseInt(c)<0) {
				throw new Exception("Los creditos no pueden ser negativos");
			}else if(credito!=true) {
				throw new NumberFormatException("Los creditos no pueden contener letras");
			}
			asignaturas.put(k, new Asignaturas(k, n, c));
			return true;
		}
		
	}
	
	public boolean matricular(String e, String c) {
		Alumnos x = alumnos.get(e);
		if(!alumnos.containsKey(e)&&!asignaturas.containsKey(c)) {
			System.out.println("El alumno y la asignatura no existen");
			return false;
		}else if(!alumnos.containsKey(e)) {
			System.out.println("El alumno no existe");
			return false;
		}else if(!asignaturas.containsKey(c)) {
			System.out.println("La signatura no existe");
			return false;
		}else if(asignaturas.get(c).matriculados.contains(x)) {
			System.out.println("El alumno ya estÃ¡ matriculado en la asignatura");
			return false;
		}else {
			alumnos.get(e).asignaturasM.add(asignaturas.get(c));
			asignaturas.get(c).matriculados.add(alumnos.get(e));
			alumnos.get(e).calificaciones.put(asignaturas.get(c), 0.0);
			return true;
		}
		
		
	}
	
	public void imprimirAlumno(String e) {
		System.out.println("Datos Alumno");
		System.out.println("Nombre: "+alumnos.get(e).getNombre()+"	"+"Expediente: "+alumnos.get(e).getExpediente());
		System.out.println("**********");
		Set<Asignaturas> cal = alumnos.get(e).calificaciones.keySet();
		Iterator<Asignaturas> ite = cal.iterator();
		while (ite.hasNext()) {
		    Asignaturas key = ite.next();
		    Double calc = alumnos.get(e).calificaciones.get(key);
		    System.out.println(key.getNombre()+": "+calc.doubleValue());
		}
		System.out.println("Nota media: "+alumnos.get(e).notaMedia());
		
		
	}
	
	public void imprimirAlumnos() {
		System.out.println("ALUMNOS");
		Set<String> alumcode = alumnos.keySet();
		Iterator<String> iterator = alumcode.iterator();
		 
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    Alumnos alumno = alumnos.get(code);
		 
		    System.out.println("Nombre: "+alumno.getNombre()+" "+"Expediente: "+code);
		    System.out.println("**********");
		    alumno.asignaturasM.forEach(c -> System.out.println(c.getNombre()+": "+alumnos.get(code).calificaciones.get(c).doubleValue()));
		    
		    
			System.out.println("Nota media: "+alumno.notaMedia());
		}
		System.out.println();
	}
	
	public boolean agregarCalificacion(String e, String c, double calificacion) throws Exception {
		if(!alumnos.containsKey(e)&!asignaturas.containsKey(c)) {
			System.out.println("El alumno y la asignatura no existen");
			return false;
		}if(!alumnos.containsKey(e)){
			System.out.println("El alumno no existe");
			return false;
		}else if(!asignaturas.containsKey(c)) {
			System.out.println("La asignatura no existe");
			return false;
		}else if(!alumnos.get(e).asignaturasM.contains(asignaturas.get(c))) {
			System.out.println("El alumno no está matriculado en la asignatura");
			return false;
		}else {
			if(calificacion<0) {
				throw new Exception("La calificacion no puede ser negativa");
			}
			alumnos.get(e).calificaciones.put(asignaturas.get(c), calificacion);
			return true;
		}
		
	}
	
	public void imprimirAsignatura(String c) throws ExcepcionesCA {
		if(!asignaturas.containsKey(c)||asignaturas.get(c)==null) {
			System.out.println("La asignatura no existe");
		}else {
			int count = 0;
			System.out.println("Alumnos Matriculados en "+asignaturas.get(c).getNombre()+": ");
			for(Alumnos x: asignaturas.get(c).matriculados) {
				System.out.println(x.getNombre());
				count++;
			}
			if(count==0) {
				throw new ExcepcionesCA (asignaturas.get(c), "Asignatura sin alumnos");
			}
			System.out.println("TOTAL: "+count);
		}
		
	}
	
	public void compararAlumno(String e1, String e2) {
		double media1 = 0;
		double media2 = 0;
		Integer total1;
		Integer total2;
		Set<Asignaturas> calificaciones = alumnos.get(e1).calificaciones.keySet();
		Iterator<Asignaturas> it = calificaciones.iterator();
		while (it.hasNext()) {
		    Asignaturas key = it.next();
		    Double calificacion = alumnos.get(e1).calificaciones.get(key);
		    media1 = media1+=calificacion.doubleValue();
		}
		
		Set<Asignaturas> calc = alumnos.get(e2).calificaciones.keySet();
		Iterator<Asignaturas> ite = calc.iterator();
		while (ite.hasNext()) {
		    Asignaturas key = ite.next();
		    Double calificacion = alumnos.get(e2).calificaciones.get(key);
		    media2 = media2+=calificacion.doubleValue();
		}
		total1 = (int)media1/alumnos.get(e1).calificaciones.size();
		alumnos.get(e1).setMedia(total1);
		total2 = (int)media2/alumnos.get(e2).calificaciones.size();
		alumnos.get(e2).setMedia(total2);
		
		int x = alumnos.get(e1).getMedia().compareTo(alumnos.get(e2).getMedia());
		if(x>0) {
			System.out.println(alumnos.get(e1).getNombre()+" nota media: "+alumnos.get(e1).getMedia());
		}else if(x<0) {
			System.out.println(alumnos.get(e2).getNombre()+" nota media: "+alumnos.get(e2).getMedia());
		}else {
			System.out.println(alumnos.get(e1).getNombre()+" y "+alumnos.get(e2).getNombre()+" tienen la misma nota media: "+alumnos.get(e1).getMedia());
		}
	}
}
