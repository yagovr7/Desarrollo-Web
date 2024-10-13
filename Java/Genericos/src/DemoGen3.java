// En ejecución hay que indicar que tipos vamos a usar con esa clase genérica
public class DemoGen3 {
	public static void main(String[] args) {
	    ClaseGen<Double> obj1 = new ClaseGen<Double>(23.75);
	    double v1 = obj1.getMiVal();
	    System.out.println("obj1 miVal = " + v1);
	    ClaseGen<String> obj2 = new ClaseGen<String>("Hello!");
	    String v2 = obj2.getMiVal();
	    System.out.println("obj2 miVal = " + v2);
	    System.out.println("obj1 = " + obj1);
	    System.out.println("obj2 = " + obj2);
	 }
}
