package Ejercicio2F_Texto;

public interface Interfaz {
	
	void crearProducto(String codProd, String tipo, String nombre, double precio, String pais)throws Exception;
	
	void imprimirProveedores();
    
	void imprimirProductos();
	    
	boolean asignarProveedor(String codProd, String codProv) throws Exception;
	    
	Proveedores getProveedorByCod(String codProv);
	    
	void facturacion(String codProv) throws Exception;
}
