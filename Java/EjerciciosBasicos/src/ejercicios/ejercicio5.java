package ejercicios;


public class ejercicio5 {
	public static void main(String []args) {
		
		double peso=71.5;
		double altura=1.67;
		double IMC = peso/Math.pow(altura, 2);
		
		IMC = Math.round(IMC * 1000000)/1000000D;
		
		System.out.println(
				"Peso: "+peso+
				"\nAltura: "+altura+
				"\nIMC: "+IMC);
		
		System.out.println();
		
		System.out.println(
				"TABLA IMC"+
				"\nDelgado: <18.5"+
				"\nNormal: entre 18.5 y 24.9"+
				"\nSobrepeso: entre 25 y 29.9"+
				"\nObeso: 30 o más");
		
	}
}
