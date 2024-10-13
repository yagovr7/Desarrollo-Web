package ejercicioObligatorio1;

public class Empresa {
	
	String CIF;
	String nombre;
	String direccion;
	int num_empleados;
	
	Empresa (){
		this.CIF = " ";
		this.nombre = " ";
		this.direccion = " ";
		this.num_empleados = 0;
	}
	
	 void obtenerEmpresa(){
		System.out.println("DATOS EMPRESA");
		System.out.println("CIF: "+this.CIF);
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Dirección: "+this.direccion);
		System.out.println("Numero de empleados: "+this.num_empleados);
	
}

}
