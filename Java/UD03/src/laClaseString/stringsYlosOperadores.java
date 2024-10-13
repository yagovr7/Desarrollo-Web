package laClaseString;

public class stringsYlosOperadores {
	public static void main(String[] args) {
		 String s1=new String("hola");
		 String s2=new String("hola");
		 if(s1==s2)
		 System.out.println("s1 y s2 referencian al mismo objeto");
		 else
		 System.out.println("s1 y s2 NO referencian al mismo objeto");
		 if(s1.equals(s2))
		 System.out.println("s1 y s2 contien el mismo texto");
		 else
		 System.out.println("s1 y s2 NO contienen el mismo texto");

		 } 
}
