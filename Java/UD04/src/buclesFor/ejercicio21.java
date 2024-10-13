package buclesFor;

public class ejercicio21{
	public static void main(String[] args) {
		int asterisco = 1;
		int anchura = 10;
		int espacios = anchura - 1;
		
		for(int i = 0;i<anchura;i++) {
			
			for(int iespacios= 0;iespacios<espacios;iespacios++) {
				System.out.print(" ");
			}
			for(int iasteriscos = 0;iasteriscos<asterisco;iasteriscos++) {
				System.out.print("*");
			}
			
			System.out.println();
			asterisco++;
			espacios--;
		}
		
}
}
