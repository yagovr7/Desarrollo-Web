package PolimorfismoEjercicio1;

public class Main {
	public static void main(String[] args) {
		Serie[] lista = new Serie[4];
		lista[0] = new MasDos();
		lista[1] = new MasDos();
		lista[2] = new MasTres();
		lista[3] = new MasTres();
		
        lista[1].establecerInicio(200);
        lista[3].establecerInicio(300);
        
        
        
        for(int i = 0;i<4;i++) {
        	System.out.println("Serie "+i);
        	for(int j = 0;j<5;j++) {
            	System.out.print(lista[i].obtenerSiguiente()+" ");
        	}
        	System.out.println();
        }
    }
}
