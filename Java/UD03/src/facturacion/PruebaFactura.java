package facturacion;

public class PruebaFactura {

	public static void main(String []args) {
		
		Factura f1 = new Factura("0A", "Procesador AMD", 2, 180);
		Factura f2 = new Factura("0B", "Memorias RAM DDR4", 4, 80);
		
		System.out.println(
				"\nNumero de producto: "+f1.getNum_piezas()+
				"\nDesciprición: "+f1.getDesripcion()+
				"\nCantidad: "+f1.getCantidad()+
				"\nPrecio: "+f1.getPrecio()+" €");
		System.out.println("Total: "+f1.obtenerMonto()+" €");
		
		System.out.println(
				"\nNumero de producto: "+f2.getNum_piezas()+
				"\nDesciprición: "+f2.getDesripcion()+
				"\nCantidad: "+f2.getCantidad()+
				"\nPrecio: "+f2.getPrecio()+" €");
		System.out.println("Total: "+f2.obtenerMonto()+" €");
	}
}
