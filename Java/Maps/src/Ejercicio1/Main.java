package Ejercicio1;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		//Creando objetos Coordenadas latitud y longitud
		Coordenadas c1 = new Coordenadas("43.01 N", "7.33 O");
		Coordenadas c2 = new Coordenadas("41.23 N", "2.11 E");
		Coordenadas c3 = new Coordenadas("40.24", "3.41 O");
		Coordenadas c4 = new Coordenadas("12.03 S", "77.03 O");
		
		//Creamos el HashMap
		HashMap<String, Coordenadas> mapa = new HashMap<>();
		
		//Agregamos los objetos al HashMap
		mapa.put("LUGO", c1);
		mapa.put("BARCELONA", c2);
		mapa.put("MADRID", c3);
		mapa.put("LIMA", c4);
		
		//Recorremos el Mapa
		Set<String> setCodes = mapa.keySet();
		Iterator<String> iterator = setCodes.iterator();
		System.out.println("**** keySet() ****");
		while (iterator.hasNext()) {
		    String code = iterator.next();
		    String latitud = mapa.get(code).getLatitud();
		    String longitud = mapa.get(code).getLongitud();
		    System.out.println(code + " => " + "Latitud: "+latitud+"Longitud: "+longitud);
		}
		
		System.out.println("**** values() ****");
		Collection<Coordenadas> values = mapa.values();
		for(Coordenadas x: values) {
			System.out.println("Latitud: "+x.getLatitud()+" Longitud: "+x.getLongitud());
		}
		
		System.out.println("**** entrySet() ****");
		Set<Map.Entry<String, Coordenadas>> entries = mapa.entrySet();
		for(Map.Entry<String, Coordenadas> entry: entries) {
			String key = entry.getKey();
			Coordenadas coordenadas = entry.getValue();
			
			System.out.println(key+" => Latitud: "+coordenadas.getLatitud()+" Longitud :"+coordenadas.getLatitud());
			}
		
		System.out.println("**** forEach ****");
		mapa.forEach((clave, Coordenadas) -> System.out.println(clave+" => Latitud: "+Coordenadas.getLatitud()+" Longitud: "+Coordenadas.getLongitud()));
		
		//Actualizando
		System.out.println("Actualizando objeto:");
		mapa.replace("LUGO", new Coordenadas("666","666"));
		mapa.forEach((clave, Coordenadas) -> System.out.println(clave+" => Latitud: "+Coordenadas.getLatitud()+" Longitud: "+Coordenadas.getLongitud()));
		//Eliminar
		System.out.println("Eliminando Objeto :"+mapa.remove("LUGO"));
		mapa.forEach((clave, Coordenadas) -> System.out.println(clave+" => Latitud: "+Coordenadas.getLatitud()+" Longitud: "+Coordenadas.getLongitud()));
	}
}
