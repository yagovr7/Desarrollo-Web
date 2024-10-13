package numeros;
public class DemoNum {
	
	public static void main(String []args) {
		
		Complejo c1 = new Complejo(3,4);
		Complejo c2 = new Complejo();
		c2.setReal(8);
		c2.setImag(9);
		Complejo c3 = new Complejo();
		
		System.out.println("Comlejo 1: "+c1.toString());//Constructor con parámetros
		System.out.println("Comlejo 2: "+c2.toString());//Constructor con parámetros
		System.out.println("Comlejo 3: "+c3.toString());//Constructor sin parámetros
		
		c1.sumar(c2);
		
		System.out.println("\n"+c1);
	}
}
