package Ejercicio1;

public class Main {
	public static void main(String[] args) {
			try{
				new DNI("49675297N");
			}catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
			}finally {
				System.out.println("Saliendo");
			}
		
	}
	
}
