package buclesFor;


public class ejercicio8 {
	
	public static void main(String []args) {
		for(int i = 0; i <=100;i++) {
			System.out.println(
					i+" Binario: "+Integer.toBinaryString(i)+
					" Octal: "+Integer.toOctalString(i)+
					" Hexadecimal "+Integer.toHexString(i));
		}
	}
}
