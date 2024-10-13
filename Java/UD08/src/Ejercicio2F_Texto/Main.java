package Ejercicio2F_Texto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	static void menu() {
		System.out.println("1.Crear producto");
		System.out.println("2.Imprimir Provedores");
		System.out.println("3.Imprimir Productos");
		System.out.println("4.Asignar Proveedor");
		System.out.println("5.Get Proveedor By Code");
		System.out.println("6.Facturacion");
		System.out.println("7.Exit");
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		Tienda tienda = new Tienda();
		tienda.cargarDatos();
		
		while(opcion!=7) {
			menu();
			opcion = sc.nextInt();
			switch(opcion) {
				case 1:
					System.out.print("Codigo: ");
					String cod = sc.next();
					System.out.print("Tipo: ");
					String tipo = sc.next();
					System.out.print("Nombre: ");
					String nombre = sc.next();
					System.out.print("Precio: ");
					double precio = sc.nextDouble();
					System.out.print("Pais: ");
					String pais = sc.next();
					try {
						tienda.crearProducto(cod, tipo, nombre, precio, pais);
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					tienda.imprimirProveedores();
					break;
				case 3:
					tienda.imprimirProductos();
					break;
				case 5:
					System.out.print("Codigo del proveedor: ");
					String keys = sc.next();
					tienda.getProveedorByCod(keys);
					break;
			}
		}
		
		
		
		
		
		
	}
}
