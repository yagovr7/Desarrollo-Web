package Ejercicio4;

class Nodo<G>{
	  private Nodo sig;
	  private G dato;
	  public Nodo(G dato) {
	    this.dato = dato;
	    this.sig=null;
	  }
	  public Nodo(G dato, Nodo sig) {
	    this.dato = dato;
	    this.sig = sig;
	  }
	  public void setSiguiente(Nodo sig) {
	    this.sig = sig;
	  }
	  public Nodo getSiguiente() {
	    return sig;
	  }
	  public G getDato() {
	    return dato;
	  }
	}

