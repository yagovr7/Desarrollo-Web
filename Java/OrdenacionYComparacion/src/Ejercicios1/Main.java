package Ejercicios1;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		//Objetos
		Articulo a1 = new Articulo("9","Consoladores", 30);
		Articulo a2 = new Articulo("1","Dildos", 60);
		Articulo a3 = new Articulo("4","Vaginas", 10);
		Articulo a4 = new Articulo("7","Condones", 25);
		Articulo a5 = new Articulo("0","Látigos", 80);
		
		//Lista
		LinkedList<Articulo> art = new LinkedList<Articulo>();
		
		//Agregando objetos a la lista
		art.add(a1);
		art.add(a2);
		art.add(a3);
		art.add(a4);
		art.add(a5);
		
		//Odenamos por id y luego por cantidad
		Collections.sort(art, new ComparadorArticulo());
		
		//Bucle para recorrer la lista
		for(Articulo x: art) {
			System.out.println("Código: "+x.codArticulo);
			System.out.println("Descripción: "+x.descripcion);
			System.out.println("Cantidad: "+x.cantidad);
			System.out.println();
		}
	}
}
