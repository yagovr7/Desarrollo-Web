package Ejercicio6;

public class Main {
	
	public static void main(String[] args) {
		Avion avion = new Avion("Santiago", "Ginebra", true );
		
		avion.plaza.add(new Pasajero(49675297, "Yago", "Vila", 26, "España"));
		avion.plaza.add(new Pasajero(12345678, "Claudia", "Garrido", 23, "España"));
		avion.plaza.add(new Pasajero(23456789, "Mateo", "Vila", 5, "España"));
		avion.plaza.add(new Pasajero(49675297, "Izan", "Vila", 5, "España"));
		avion.plaza.add(new Pasajero(49675297, "Brooklyn", "Del Norte", 9, "España"));
		Pasajero p1 = new Pasajero(45764587, "Fumanchu", "Pirolas", 30, "China");
		
		avion.insert(p1);
		avion.datos();
		
		avion.remove(p1);
		avion.datos();
		
		avion.removeCurrent();
		avion.datos();
		
		avion.goFirst();
		
		avion.advance();
		
		System.out.println("\nLista vacia: "+avion.isOnList());
		
		System.out.println(avion.getCurrent());
		System.out.println(avion.getPrevious());
	}
}
