package Ejercicio2;


public class Main{
	public static void main(String[] args) {
		
		Reverse rev = str -> {
			String reverse = "";
			for(int i = str.length()-1; i >= 0; i--) {
				reverse+=str.charAt(i);
			}return reverse;
		};
		System.out.println(rev.reverse("Hola Mundo"));
	}
}
