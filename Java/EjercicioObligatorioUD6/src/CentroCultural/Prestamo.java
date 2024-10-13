package CentroCultural;
import java.time.LocalDate;

class Prestamo{
	
	private int dniCliente;
	private int codigoMaterial;
	private LocalDate inicio;
	private LocalDate fin;
	private Libro libro;
	private Disco disco;
	private Cliente cliente;
	
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Disco getDisco() {
		return disco;
	}
	public void setDisco(Disco disco) {
		this.disco = disco;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	Prestamo(){
		this.dniCliente = 0;
		this.codigoMaterial = 0;
	}
	Prestamo(int dni, int codigo, LocalDate inicio, LocalDate fin){
		this.inicio = inicio;
		this.fin = fin;
		this.dniCliente = dni;
		this.codigoMaterial = codigo;
		
	}
	
	public int getCodigoMaterial() {
		return codigoMaterial;
	}
	public void setCodigoMaterial(int codigoMaterial) {
		this.codigoMaterial = codigoMaterial;
	}
	public int getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	
		
}


