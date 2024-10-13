package ejercicioObligatorio1;


public class Trabajador {
	int DNI;
	String nombre;
	String apellidos;
	int edad;
	String lugar_nacimiento;
	Empresa empresa;
	
	Trabajador(){
		this.DNI=0;
		this.nombre = "";
		this.apellidos = " ";
		this.edad = 0;
		this.lugar_nacimiento = " ";	
	}
	
	public void obtenerEmpresa(Empresa empresa) {
		this.empresa=empresa;
		System.out.println("CIF empresa: "+empresa.CIF);
	}
	
	public void obtenerLetra(int DNI) {
		String letras ="TRWAGMYFPDXBNJZSQVHLCKE";
		int resto =DNI%23;
		char resultado = letras.charAt(resto);
		System.out.println("DNI: "+DNI+""+resultado);
	}
	
	
	public void obtenerTrabajador(){
		System.out.println("DATOS DEL EMPLEADO");
		obtenerLetra(this.DNI);
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Apellidos: "+this.apellidos);
		System.out.println("Edad: "+this.edad);
		System.out.println("Lugar de nacimiento: "+this.lugar_nacimiento);
		obtenerEmpresa(empresa);

	}

	

}
