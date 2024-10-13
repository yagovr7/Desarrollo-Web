package cadenas;

public class cadena {
	
	private static String cadena = "   esto es un ejemplo de una cadena de ejemplo   ";
	
		public static void main(String []args) {
			
			System.out.println("Valor de la variable :"+cadena);
			//Imprima cuántos caracteres tiene
			int caracteres = cadena.length();
			System.out.println("\nCantidad de caracteres: "+caracteres);
			
			//Elimine los espacios en blanco al principio y al final. ¿Cuántos caracteres tiene ahora?
			System.out.println("\nCadena sin espacios :"+cadena.trim());
			int sinEspacios = cadena.trim().length();
			System.out.println("\nCantidad de caracteres sin espacios: "+sinEspacios);
			
			//Extraiga la subcadena “cadena de ejemplo” y la guarde en una variable denominada cola
			String cola = cadena.substring(29, 46);
			System.out.println("\nExtraer subCadena: "+cola);
			
			//Reemplace en cola “ejemplo” por “muestra”
			System.out.println("\n"+cola.replaceAll("ejemplo","muestra"));
			
			//Extraiga la subcadena “esto es un ejemplo de una” y la guarde en una variable denominada principio
			String principio = cadena.substring(3, 29);
			String frase = principio+cola;
			System.out.println("\nConcatenacion de principio y frase: "+frase);
			
			//Modifique frase de forma que empiece con mayúsculas
			frase = frase.toUpperCase().charAt(0)+frase;
			System.out.println(frase);
}
}
