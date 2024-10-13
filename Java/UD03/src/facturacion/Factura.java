package facturacion;

public class Factura {
	
	String num_pieza;
	String desripcion;
	int cantidad;
	double precio;
	
	Factura(){
		this.num_pieza="";
		this.desripcion="";
		this.cantidad=0;
		this.precio=0;
}
	
	Factura (String n, String d, int c, int p){
		this.num_pieza = n;
		this.desripcion = d;
		this.cantidad = c;
		this.precio = p;
	}
	
	public void setNum_piezas(String num_piezas) {
		this.num_pieza = num_piezas;
	}
	public void setDesripcion(String desripcion) {
		this.desripcion = desripcion;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String getNum_piezas() {
		return num_pieza;
	}
	public String getDesripcion() {
		return desripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	
	Double obtenerMonto(){
		return cantidad*precio;
	}
}


