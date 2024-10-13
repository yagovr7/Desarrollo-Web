package buclesFor;

public class ejercicio14 {
	public static void main(String[] args) {
		int x = 11;
		int y = 21;
		int z = 31;
		for(int a = 1;a<=3;a++) {
			System.out.println(x++);
			if(a==3) {
			for(int e = 1;e<=3;e++) {
				System.out.println(y++);
				if(e==3) {
					for(int i = 1;i<=3;i++) {
						System.out.println(z++);
					}}
			}}
			
		}
	}
}
