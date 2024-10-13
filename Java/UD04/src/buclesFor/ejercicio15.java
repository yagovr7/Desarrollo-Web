package buclesFor;

public class ejercicio15 {
	public static void main(String[] args) {
		int num1 = 2;
		int num2 = 1;
		for(int a = 1;a<=10;a++) {
			System.out.println("2 x "+num2+" = "+(num1*num2));
			num2++;
			if (a==10) {
				System.out.println();
				num1=3;
				num2=1;
				for(int e = 1;e<=10;e++) {
					System.out.println(num1+" x "+num2+" = "+(num1*num2));
					num2++;
					if (e==10) {
						System.out.println();
						num1=4;
						num2=1;
						for(int i = 1;i<=10;i++) {
							System.out.println(num1+" x "+num2+" = "+(num1*num2));
							num2++;
							}
					}
					}
			}
		}
	}
}
