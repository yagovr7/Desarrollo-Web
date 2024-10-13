package Arrays;
public class ArraysDemo {
	public static void main(String[] args) {
		 int[] sq = new int[100]; // creación array
		 for(int i=0; i<100; i++) // bucle inicialización
		 sq[i] = i*i;
		 for(int i=0; i<100; i++) // bucle impresión
		 System.out.printf("%04d%c", sq[i], ((i+1)%10==0)?'\n':'\t');
		 }

}
