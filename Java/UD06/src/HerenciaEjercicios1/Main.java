package HerenciaEjercicios1;

public class Main {
	
	public static void main(String[] args) {
		Ordenador s1 = new Sobremesa ("i7", 16, "Micro-ATX");
		Ordenador p1 = new Portatil("i5", 8, 1);
		
		System.out.println(s1.toString());
		System.out.println(p1.getProcesador());
		
	
	}
}
