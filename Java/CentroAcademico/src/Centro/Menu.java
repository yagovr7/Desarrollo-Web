package Centro;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
	
	private static Scanner sc;
	
	public static void menu() {
		System.out.println("0.Exit");
		System.out.println("1.Crear Alumno");
		System.out.println("2.Crear Asignatura");
		System.out.println("3.Matricular Alumno");
		System.out.println("4.Imprimir Alumno");
		System.out.println("5.Imprimir Alumnos");
		System.out.println("6.Imprimir Asignatura");
		System.out.println("7.Agregar Calificaciones");
		System.out.println("8.Comparar Alumno");
	}
	
	public static void main(String[] args) throws Exception  {
		sc = new Scanner(System.in);
		int opcion;
		CentroAcademico centro = new CentroAcademico();
		
		opcion = 1;
		while(opcion!=0) {
			menu();
			opcion = sc.nextInt();
			switch(opcion) {
				case 0:
					System.exit(0);
					break;
				case 1:
					String expediente;
					String nombreAlumn;
					int num = 0;
						Pattern pattern1 = Pattern.compile("([0-9]){8}([a-zA-Z]{1})");
					    Matcher matcher1 = null;

					    while (true){
					    System.out.print("Número de Expediente: ");
					    
					    matcher1=pattern1.matcher(expediente = sc.next());
					    try {
					    	if(expediente.length()>9||expediente.length()<9&&matcher1.matches()){
								System.out.println("Error: DNI debe tener el siguiente formato '12345678A'");
							}else {
								num=Integer.parseInt(expediente.substring(0, expediente.length()-1));
							}
					    }catch(NumberFormatException e) {
					    	System.out.println("Formato incorrecto ej:'12345678A'");
					    }
						
						
					    char letra=expediente.charAt(expediente.length()-1);
							if(matcher1.matches()) {
								if(centro.calcularLetra(num)==letra) {
									System.out.println("OK");
									break;
								}else {
									System.out.println("La letra no coincide");
								}
							}
					    }
					
					    
					    Pattern pattern2 = Pattern.compile("[a-zA-Z]+");
					    Matcher matcher2;

					    while (true){
					    System.out.print("Nombre: ");
						matcher2=pattern2.matcher(nombreAlumn = sc.next());
						if(matcher2.matches()) {
							System.out.println("OK");
							break;
						}else {
				  			System.out.println("El nombre solo debe contener letras"); 
						}
					}
					    try {
					    	centro.crearAlumno(expediente, nombreAlumn);
					    }catch(Exception e) {
					    	System.out.println(e.getMessage());
					    }
						

					break;
				case 2:
					String codigo;
					String nombreAsig;
					String creditos;
					
					Pattern pattern3 = Pattern.compile("([A-Z])-([0-9]{3})");
				    Matcher matcher3;

				    while (true){
				    System.out.print("Código: ");
					matcher3=pattern3.matcher(codigo = sc.next());
					if(matcher3.matches()) {
						System.out.println("OK");
						break;
					}else {
			  			System.out.println("Error: el codigo debe tener este formato 'A-111'"); 
					}
				    }
				    
				    Pattern pattern4 = Pattern.compile("[a-zA-Z]+");
				    Matcher matcher4;

				    while (true){
				    System.out.print("Nombre: ");
					matcher4=pattern4.matcher(nombreAsig = sc.next());
					if(matcher4.matches()) {
						System.out.println("OK");
						break;
					}else {
			  			System.out.println("El nombre solo debe contener letras"); 
					}
				    }
				    
				    Pattern pattern5 = Pattern.compile("[\\d]+");
				    Matcher matcher5;

				    while (true){
				    System.out.print("Creditos: ");
					matcher5=pattern5.matcher(creditos = sc.next());
					if(matcher5.matches()) {
						System.out.println("OK");
						break;
					}else {
			  			System.out.println("Solo numeros enteros, no se permiten negativos"); 
					}
				    }
				    
					try {
						centro.crearAsignatura(codigo, nombreAsig, creditos);
					}catch(NumberFormatException e) {
						System.out.println(e.getMessage());
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 3:
					System.out.print("Número de expediente: ");
					String exp = sc.next();
					System.out.print("Código Asignatura: ");
					String code = sc.next();
					try {
						centro.matricular(exp, code);
					}catch(Exception e){
						System.out.println();
					}
					break;
				case 4:
					System.out.print("Número de expediente: ");
					String expeImprimir = sc.next();
					centro.imprimirAlumno(expeImprimir);
					break;
				case 5:
					centro.imprimirAlumnos();
					break;
				case 6:
					System.out.print("Código de la asignatura: ");
					String codeAsig = sc.next();
					try {
						centro.imprimirAsignatura(codeAsig);
					}catch(ExcepcionesCA e) {
						System.out.println(e.getMessage()+" - "+e.getFecha());
					}
					break;
				case 7:
					Double cal;
					System.out.print("Número de expediente: ");
					String expeAl = sc.next();
					System.out.print("Código de la asignatura: ");
					String codeAs = sc.next();
					System.out.print("Calificación: ");
					cal = sc.nextDouble();
					while(cal<0) {
						System.out.println("La nota no puede ser negativa");
						System.out.print("Calificación: ");
						cal = sc.nextDouble();
					}
					try {
						centro.agregarCalificacion(expeAl, codeAs, cal);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 8:
					System.out.print("Expediente del primer alumno: ");
					String exp1 = sc.next();
					System.out.print("Expediente del segundo alumno: ");
					String exp2 = sc.next();
					centro.compararAlumno(exp1, exp2);
					break;
			}
		}
		
	}
}
