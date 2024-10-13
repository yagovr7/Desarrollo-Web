package Ejercicio2;

import java.util.Objects;

public class Persona {
	private int tlf;
	private String nombre;
	int currencyCode;
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	Persona(int t, String n){
		this.tlf = t;
		this.nombre = n;
		this.currencyCode = 0;
	}
	
public boolean equals(Object o) {
        
        if (o == this)
            return true;
        if (!(o instanceof Persona))
            return false;
        Persona other = (Persona)o;
        boolean check = (this.nombre == null && other.nombre == null)
          || (this.nombre != null && this.nombre.equals(other.nombre));
        return this.tlf == other.tlf && check;
    }
	
	public int hashCode() {
        return Objects.hash(nombre, tlf);
    }
}
