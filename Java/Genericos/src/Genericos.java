import java.io.IOException;

public class Genericos {
	
	public static <T> void imprimeArray(T[] arr) {
	for (T val: arr) System.out.printf("%s ", val);
	System.out.println();
	}
	public static void imprimeArray(double[] arr) {
	for (double val: arr) System.out.printf("%s ", val);
	System.out.println();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Double[] a1 = { 3.5, 2.0, 4.0, -1.67 };
		Integer[] a2 = { 5, 0, 4, -1 };
		String[] a3 = { "mi", "casa, ", "teléfono " };
		imprimeArray(a1);
		imprimeArray(a2);
		System.out.print("\b");
		System.out.flush();
		imprimeArray(a3);
		
	}
}
