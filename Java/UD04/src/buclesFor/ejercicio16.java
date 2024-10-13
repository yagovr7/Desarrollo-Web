package buclesFor;

public class ejercicio16 {
	public static void main(String[] args) {
		int b = 0;
		for (int num = 28;;) {
			if(num%2==0) {
				b=0;
			}else {
				b=1;
			}System.out.println(b+" ");
			num=num/2;
			if(num==0) {
				break;
			};
		}
	}
}
