package Ejercicio2F_Texto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tienda implements Interfaz{
TreeMap<String,Productos> prod = new TreeMap<>();
TreeMap<String,Proveedores> prov = new TreeMap<>();

	public void crearProducto(String codProd, String tipo, String nombre, double precio, String pais) throws Exception {
		if(prod.containsKey(codProd)) {
			throw new Exception("El producto ya esxiste");
		}else {
			prod.put(codProd, new Productos(codProd, tipo, nombre, precio, pais));
			FileWriter fw = new FileWriter("productos.txt",true);
			FileReader fr = new FileReader("productos.txt");
			try(fw;fr){
				fw.write("\n"+codProd+":"+tipo+":"+nombre+":"+precio+":"+pais);
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void imprimirProveedores() {
		Set<String> setCodes = prov.keySet();
		Iterator<String> iterator = setCodes.iterator();
		 
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    Proveedores proveedor = prov.get(code);
		 
		    System.out.println("Proveedor Codigo => "+code +"\nNombre: "+proveedor.getNome()+"\nEnderezo: "+proveedor.getEnderezo()+"\n");
		}
		
	}

	public void imprimirProductos() {
		Set<String> setCodes = prod.keySet();
		Iterator<String> iterator = setCodes.iterator();
		 
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    Productos producto = prod.get(code);
		 
		    System.out.println("Producto Codigo => "+code + "\nTipo: "+producto.getTipo()+"\nNombre: "+producto.getNome()
		    +"\nPrecio: "+producto.getPrezo()+"\nPais: "+producto.getPais());
		    System.out.print("Proveedores: "+producto.prov.toString()+"\n\n");
		    
		}
		
	}

	public boolean asignarProveedor(String codProd, String codProv) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public Proveedores getProveedorByCod(String codProv) {
		Set<String> keys = prov.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    Proveedores pro = prov.get(code);
		    if(code.equals(codProv)) {
		    	System.out.println("\nPROVEEDOR"+"\nNombre: "+pro.getNome()+"\nEnderezo: "+pro.getEnderezo()+"\n");
		    }

		}
		return null;
	}

	public void facturacion(String codProv) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public void cargarDatos() {
		File prove = new File("proveedores.txt");
		File produ = new File("productos.txt");
		try {
			BufferedReader lectura = new BufferedReader(new FileReader(prove));
			String lineas;
			String codProv;
			String nombre;
			String enderezo;
			
			while((lineas = lectura.readLine()) != null) {
				String[] datos = lineas.split(":");
				codProv = datos[0];
				nombre = datos[1];
				enderezo = datos[2];
				prov.put(codProv, new Proveedores(codProv, nombre, enderezo));
			}
			lectura.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		try {
			BufferedReader lectura = new BufferedReader(new FileReader(produ));
			String lineas;
			String codProd;
			String tipo;
			String nombre;
			double precio;
			String pais;
			TreeSet<String> prov = new TreeSet<String>();
			String numeros;
			while((lineas = lectura.readLine()) != null) {
				String cadena = lineas;
				Pattern pattern = Pattern.compile("^([^:]*:[^:]*:[^:]*:[^:]*):([^:]+)$");
				Matcher matcher = pattern.matcher(cadena);
				System.out.println(matcher.matches());
				if(matcher.matches()) {
					numeros = matcher.group(2);
					System.out.println(numeros);
					String[] datos2 = numeros.split(",");
					for(String s:datos2) {
						prov.add(s);
					}
				}
				
				String[] datos = lineas.split(":");
				codProd = datos[0];
				tipo = datos[1];
				nombre = datos[2];
				precio = Double.parseDouble(datos[3]);
				pais = datos[4];
				prod.put(codProd, new Productos(codProd, tipo ,nombre, precio, pais, prov));
			}
			lectura.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println(prod.get("2").prov);
	}
	
}
