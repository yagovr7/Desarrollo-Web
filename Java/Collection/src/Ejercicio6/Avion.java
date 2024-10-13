package Ejercicio6;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Avion implements Ejercicio6{
	private String origen;
	private String destino;
	LinkedList<Pasajero> plaza = new LinkedList<>();
	private boolean businnes;
	Pasajero aux;
	
	
	

	public Avion(String origen, String destino, boolean businnes) {
		this.origen = origen;
		this.destino = destino;
		this.businnes = businnes;
	}
	
	public String getOrigen() {
		return origen;
	}



	public void setOrigen(String origen) {
		this.origen = origen;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public boolean isBusinnes() {
		return businnes;
	}



	public void setBusinnes(boolean businnes) {
		this.businnes = businnes;
	}

	/*************************************************/

	public void insert(Object x) {
		System.out.println("****insert****");
		Pasajero p = (Pasajero) x;
		this.plaza.add(p);
	}

	public void remove(Object x) {
		System.out.println("****remove****");
		Pasajero p = (Pasajero) x;
		this.plaza.remove();
	}

	public void removeCurrent() {
		System.out.println("****removeCurrent****");
		ListIterator<Pasajero> it = plaza.listIterator();
		it.next();
		this.plaza.remove();
		
	}

	public boolean find(Object x) {
		System.out.println("****find****");
		Pasajero p = (Pasajero) x;
		ListIterator<Pasajero> it = plaza.listIterator();
		it.next();
		return true;
	}

	public void goFirst() {
		System.out.println("****goFirst****");
		System.out.println(this.plaza.getFirst().getNombre());
		aux = this.plaza.getFirst();
		
		
	}

	public void advance() {
		Iterator<Pasajero> it = plaza.iterator();
		it.next();
		aux = plaza.get(+1);
		System.out.println();
		System.out.println("****advance****");
		System.out.println("Nombre: "+aux.getNombre());

		
		
	}

	public boolean isOnList() {
		if(this.plaza.isEmpty()) {
			return true;
		}
		return false;
	}

	public Object getCurrent() {
		return aux.getNombre();
	}

	public Object getPrevious() {
		ListIterator<Pasajero> it = plaza.listIterator();
		while(it.hasNext()) {
			if(it.next().getNombre()==aux.getNombre()) {
				aux = it.previous();
			}
		}
			

		
		return aux.getNombre();
	}
	
	public void datos() {
		for(Pasajero p: this.plaza) {
			System.out.println(p.getNombre());
		}
		System.out.println();
	}

}
