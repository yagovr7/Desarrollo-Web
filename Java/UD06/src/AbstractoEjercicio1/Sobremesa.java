package AbstractoEjercicio1;

public class Sobremesa extends Ordenadores {
	
	Sobremesa(String cpu, int ram, String marca, int disco){
		super( cpu, ram, marca, disco);
	}

	
	int discoReal(int disco) {
		int resultado = (disco/1024)*1000;
		
		return resultado;
	}


	@Override
	int discoReal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
