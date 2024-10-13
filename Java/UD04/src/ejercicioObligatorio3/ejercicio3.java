package ejercicioObligatorio3;

public class ejercicio3 {
	public static void main(String[] args) {
		String i = "ZYWXVUTSRQPONMLKJIHGFEDCBA";
		int min = 0;
		int max = i.length();
		 for(int contador = 0;contador<=26;contador++) {
			 String resultado = i.substring(min, max);
			 System.out.println(resultado);
			 min++;
		 }
	}

}
