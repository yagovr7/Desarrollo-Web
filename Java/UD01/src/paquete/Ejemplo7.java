package paquete;

public class Ejemplo7 {
	public static void main(String[] args) {
		 float valor;
		 //la siguiente instrucción da error si la descomentas
		 //valor = 2.6;
		 //la siguiente instrucción es correcta
		 valor = 2.6f;
		 System.out .println("Valor del \"dato\" = " + valor);
		 System.out.println("Probando secuencias \b de escape con \\b");
		 System.out.println("Probando secuencias \n de escape con \\n");
		 System.out.println("Probando secuencias \t de escape con \\t");
		 System.out.println("Probando secuencias \\ de escape con \\");
		 System.out.println("Probando secuencias \' de escape con \\\'");
		 System.out.println("Probando secuencias \" de escape con \\\"");
		 System.out.print('A');
		 System.out.print('\t');
		 System.out.print('B');
		 System.out.print('\t');
		 System.out.print('C');
		 System.out.print('\\');
		 //System.out.print('\');
		 System.out.print('\'');

		 }
}
