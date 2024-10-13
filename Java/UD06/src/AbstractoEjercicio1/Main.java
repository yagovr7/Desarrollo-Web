package AbstractoEjercicio1;

public class Main {
	public static void main(String[] args) {
		Sobremesa s1 = new Sobremesa("AMD", 32, "AORUS", 240);
		Portatil p1 = new Portatil("Intel", 16, "HP", 500);
		
		System.out.println("Procesador: "+s1.cpu);
		System.out.println("RAM: "+s1.ram+"GB");
		System.out.println("Marca: "+s1.marca);
		System.out.println("DiscoDuro: "+s1.disco+"GB");
		System.out.println();
		System.out.println("Procesador: "+p1.cpu);
		System.out.println("RAM: "+p1.ram+"GB");
		System.out.println("Marca: "+p1.marca);
		System.out.println("DiscoDuro: "+p1.disco+"GB");
	}
}
