package Serializacion_Ej2;

import java.io.Serializable;

public class Ciudades implements Serializable{
	String ciudad;
	double latitud;
	double longitud;
	
	Ciudades(String c, double lat, double lon){
		this.ciudad = c;
		this.latitud = lat;
		this.longitud = lon;
	}
}
