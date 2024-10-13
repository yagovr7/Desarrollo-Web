package PolimorfismoEjercicio3;


public class Main {
	public static void main(String[] args) {
		Tripulante tripulantes[] = new Tripulante[8];
		
		GPS gps[] = new GPS[9];
		gps[0] = new GPS(0,0,5);
		gps[1] = new GPS(1,1,6);
		gps[2] = new GPS(3,2,45);
		gps[3] = new GPS(4,3,45);
		gps[4] = new GPS(7,6,54);
		gps[5] = new GPS(2,4,5);
		gps[6] = new GPS(9,9,3);
		gps[7] = new GPS(7,7,2);
		gps[8] = new GPS(6,8,1);
		
		//Creamos el barco
		Barco barco = new Barco("Infinito", "Buque", 120, 1500);
		
		//Creamos al Capitan
		Tripulante capi = new Capitan(98765422,0,55, 5,"Paco", "666549874", 'H', 100000);
		tripulantes[7] = capi;
		
		//Creamos el jefe
		Tripulante jefe = new Jefe(49675297, 1,13, 45, "Terminator", "654654789", 'H', 1000, 250);
		
		//Creamos los 7 marineros
		Tripulante m1 = new Marinero(33433830,2,26,5,"Yago", "654733907", 'H', 70);
		Tripulante m2 = new Marinero(35898109,3,30,7,"Claudia", "654823978", 'M', 80);
		Tripulante m3 = new Marinero(55105310,4,19,2,"Mateo", "632547895", 'H', 50);
		Tripulante m4 = new Marinero(91567381,5,42,9,"Izan", "621457896", 'H', 120);
		Tripulante m5 = new Marinero(99217207,6,55,15,"Benzema", "632569856", 'H', 300);
		Tripulante m6 = new Marinero(85683368,7,1,11, "Pepe", "632147896", 'H', 15);
		Tripulante m7 = jefe;
		tripulantes[0] = m1;
		tripulantes[1] = m2;
		tripulantes[2] = m3;
		tripulantes[3] = m4;
		tripulantes[4] = m5;
		tripulantes[5] = m6;
		tripulantes[6] = m7;
		
		
		
		System.out.println("____DATOS BARCO____\n");
		System.out.println(barco.toString());
		System.out.println("\n____DATOS TRIPULACIÓN____\n");
		for(Tripulante t:tripulantes) {		
			t.datos();
			System.out.println("CoordenadaX: "+gps[tripulantes[t.getPosicion()].getPosicion()].getCoordenadaX());
			System.out.println("CoordenadaY: "+gps[tripulantes[t.getPosicion()].getPosicion()].getCoordenadaY());
			System.out.println("Fecha: "+gps[tripulantes[t.getPosicion()].getPosicion()].getFecha());
			System.out.println("Hora: "+gps[tripulantes[t.getPosicion()].getPosicion()].getHora());
			System.out.println("Dias tripulados: "+gps[tripulantes[t.getPosicion()].getPosicion()].getDiasTripulados());
			System.out.println();
		}
	}
}

