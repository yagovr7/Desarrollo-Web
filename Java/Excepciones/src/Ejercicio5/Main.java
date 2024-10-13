package Ejercicio5;

public class Main {
	public static void venderProducto(Producto p, int cant) throws Exception{
		if(p.getCantidad()==0||cant>p.getCantidad()) {
			throw new FaltaStock("Falta de Stock");
			
		}
		if(p.getCantidad()>=cant) {
			
			System.out.println("ID: "+p.getId());
			System.out.println("Precio: "+p.getPrecio()+"€");
			p.setCantidad(p.getCantidad()-cant);
			System.out.println("Stock: "+p.getCantidad());
		}
		
	}
	public static void main(String[] args) throws Exception {
		Producto p1 = new Producto("1", 50, 0);
		try {
			venderProducto(p1, 40);
			venderProducto(p1, 10);
			venderProducto(p1, 10);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
