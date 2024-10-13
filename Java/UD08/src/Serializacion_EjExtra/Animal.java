package Serializacion_EjExtra;

import java.io.Serializable;

public class Animal implements Serializable{
	private String nombre;
	private int edad;
	Perro[] perro = new Perro[5];
	Gato[] gato = new Gato[5];
	int contadorP = 0;
	int contadorG = 0;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Perro[] getPerro() {
		return perro;
	}

	public void setPerro(Perro[] perro) {
		this.perro = perro;
	}

	public Gato[] getGato() {
		return gato;
	}

	public void setGato(Gato[] gato) {
		this.gato = gato;
	}

	public int getContadorP() {
		return contadorP;
	}

	public void setContadorP(int contadorP) {
		this.contadorP = contadorP;
	}

	public int getContadorG() {
		return contadorG;
	}

	public void setContadorG(int contadorG) {
		this.contadorG = contadorG;
	}

	Animal(){
		this.nombre = null;
		this.edad = 0;
	}
	
	Animal(String n, int e){
		this.nombre = n;
		this.edad = e;
	}
	
	void getTipo(Animal a) {
		if(a instanceof Perro) {
			System.out.println("Tipo: Perro\n");
		}else if(a instanceof Gato) {
			System.out.println("Tipo: Gato\n");
		}else {
			System.out.println("No es un animal");
		}
	}
	
	boolean addPerro(Animal perro) {
		if(perro instanceof Perro) {
			Perro p = (Perro)perro;
			if(this.perro[4]!= null) {
				System.out.println("Array de perros completo");
				return false;
			}
			this.perro[this.contadorP] = p;
			contadorP++;
		}else {
			return false;
		}
		
		return true;
	}
	
	boolean addGato(Animal gato) {
		if(gato instanceof Gato) {
			Gato g = (Gato)gato;
			if(this.gato[4]!= null) {
				System.out.println("Array de gatos completo");
				return false;
			}
			this.gato[this.contadorG] = g;
			contadorG++;
		}else {
			return false;
		}
		
		return true;
	}
}
