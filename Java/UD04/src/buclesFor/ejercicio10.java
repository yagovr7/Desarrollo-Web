package buclesFor;

public class ejercicio10 {
	public static void main(String[] args) {
		int i = 1;
		System.out.println(i);
		for(i = 1;i<1024;) {
			System.out.println(i*2);
			i=i+i;
		}
	}
}
