package Arrays;

public class for_each {
	public static void main(String[] args) {
		int[] numeros = {0,1,2,3,4,5,6,7,8,9,10};
		int suma = 0;
		double media;
		
		for(int n:numeros) {
			suma+=n;
		}
		media=(double)suma/numeros.length;
		System.out.printf("La suma es %d y la media es %.2f",suma,media);
		
	}
}
