package ejercicioObligatorio1;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void Menu() {
		System.out.println("1·Alta de un empleado");
		System.out.println("2·Mostrar información del empleado");
		System.out.println("3·Entrada de datos por cadena especial y mostrar el nuevo empleado");
		System.out.println("4·Salir");
	}
		public static void main(String []args) throws IOException {
			Scanner teclado = new Scanner(System.in);
			
			//Creamos el objeto Empresa y Trabajador con el constructor con parámetros
			Trabajador empleado = new Trabajador();
			Empresa empresa = new Empresa();
			//Llamamos al Menú
			for(;;) {
			Main.Menu();
			int opcion = teclado.nextInt();
			
			//Opcion 1

			if(opcion==1) {
				
				//DNI
				System.out.println("DATOS EMPLEADO");
				System.out.print("DNI(solo numeros): ");
				empleado.DNI = teclado.nextInt();
				while(Integer.toString(empleado.DNI).length()<8 || Integer.toString(empleado.DNI).length()>8){
					System.out.print("Error el DNI debe tener 8 digitos y no debe estar vacio: ");
					empleado.DNI = teclado.nextInt();
				}
				
				//Nombre
				do {
					System.out.print("Nombre(Obligatorio): ");
					empleado.nombre  = teclado.next();
				}while(empleado.nombre==null||empleado.nombre==" ");
				
				//Apellidos
				do {
					System.out.print("Apellidos(Obligatorio): ");
					teclado.nextLine();
					empleado.apellidos = teclado.nextLine();
				}while(empleado.apellidos==null||empleado.apellidos==" ");
					
				
				
				
				//Lugar de nacimiento
				do {
					System.out.print("Lugar e nacimiento(Obligatorio): ");
					empleado.lugar_nacimiento = teclado.nextLine();
				}while(empleado.lugar_nacimiento==null||empleado.lugar_nacimiento==" ");
				
				
				//Edad
				System.out.print("Edad(Obligatoria): ");
				empleado.edad = teclado.nextInt();
				while(empleado.edad>70 || empleado.edad<16) {
					System.out.print("Edad incorrecta: ");
					empleado.edad = teclado.nextInt();
				}
				
				
				empleado.empresa= empresa;
				
				//Empresa
				System.out.println("\nDATOS EMPRESA");
				
				System.out.print("CIF: ");
				empresa.CIF = teclado.next();
				
				System.out.print("Nombre: ");
				teclado.nextLine();
				
				empresa.nombre = teclado.nextLine();
				System.out.print("Direccion: ");
				
				empresa.direccion= teclado.nextLine();
				
				System.out.print("Numero de empleados: ");
				empresa.num_empleados = teclado.nextInt();
				
				
				
				
					System.out.println();
					System.out.println("Empleado dado de ALTA\n");
					empleado.obtenerTrabajador();
					System.out.println();
					empresa.obtenerEmpresa();
					System.out.println();
					
					
					System.out.println();
					
			}else if(opcion==2) {
				
				empleado.obtenerTrabajador();
				System.out.println();
				System.out.println();
				
				}else if(opcion==3) {
					
				StringTokenizer st = new StringTokenizer("45666783&Juan&Lopez&45&Ourense&A80192727&Los hermanos S.L.&Calle Principal 5, Lugo&22","&");
				while(st.hasMoreTokens()) {
					empleado.DNI = Integer.parseInt(st.nextToken());
					empleado.nombre = st.nextToken();
					empleado.apellidos = st.nextToken();
					empleado.edad = Integer.parseInt(st.nextToken());
					empleado.lugar_nacimiento = st.nextToken();
				
					empresa.CIF = st.nextToken();
					empresa.nombre = st.nextToken();
					empresa.direccion = st.nextToken();
					empresa.num_empleados = Integer.parseInt(st.nextToken());
					
					empleado.empresa = empresa;
				}
				
				empleado.obtenerTrabajador();
				System.out.println();
				empresa.obtenerEmpresa();
				System.out.println();
		}else if(opcion==4) {
			System.exit(0);
			};	
		}
	}
}
