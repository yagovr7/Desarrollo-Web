package CentroCultural;

public class Cliente {
	private int dni;
	private String nombre;
	private int cantClientes = 0;
	Prestamo prestamosLibros[] = new Prestamo[3];
	Prestamo prestamosDiscos[] = new Prestamo[3];
	

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantClientes() {
		return cantClientes;
	}

	public void setCantClientes(int cantClientes) {
		this.cantClientes = cantClientes;
	}


	Cliente(){
		cantClientes++;
		this.dni = 0;
		this.nombre = "";
		
	}
	Cliente(int dni, String nombre){
		cantClientes++;
		this.setDni(dni);
		this.setNombre(nombre);
	}
	
	
	public void obtenerLetra(int dni) {
		String letras ="TRWAGMYFPDXBNJZSQVHLCKE";
		int resto =dni%23;
		char resultado = letras.charAt(resto);
		System.out.println("DNI: "+dni+""+resultado);
	}
	
	public void alta() {
		System.out.println("ALTA COMPLETADA");
		System.out.println("Nombre: "+this.nombre);
		this.obtenerLetra(dni);
	}
	
}


