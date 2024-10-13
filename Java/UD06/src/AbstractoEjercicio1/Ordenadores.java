package AbstractoEjercicio1;

public abstract class Ordenadores {
		String cpu;
		int ram;
		String marca;
		int disco;
		
		Ordenadores(String cpu, int ram, String marca, int disco){
			this.cpu = cpu;
			this.ram = ram;
			this.marca = marca;
			this.disco = disco;
		}
		
		abstract int discoReal();
}
