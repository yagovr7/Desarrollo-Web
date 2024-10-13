package laClaseString;

public class creacionDeObjetosString {
	public static void main(String[] args) {
		 String s1="hola";
		 String s2="hola";
		 String s3= new String("hola");
		 if(s1==s2)
		 System.out.println("s1 y s2 referencian al mismo objeto");
		 if(s1==s3)
		 System.out.println("s1 y s3 referencian al mismo objeto");
		 if(s2==s3)
		 System.out.println("s3 y s3 referencian al mismo objeto");
	 }
}
