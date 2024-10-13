package Ejercicios1;
import java.util.Comparator;

public class ComparadorArticulo implements Comparator<Articulo>{
	/*
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		return o1.codArticulo.compareTo(o2.codArticulo);
	}*/
	
	public int compare(Articulo o1, Articulo o2) {
		// TODO Auto-generated method stub
		return Integer.valueOf(o1.cantidad).compareTo(o2.cantidad);
	}
	
	
}

