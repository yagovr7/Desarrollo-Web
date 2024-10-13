package CrearExcepcion;

public class DemoEx6 {
	public static void validaEdad(int edad) throws DatoNoValidoException {
	    if(edad < 18)
	        throw new DatoNoValidoException(Integer.toString(edad), 101, "Menor de edad");
	    }
	 public static void main(String[] args) {
	    try {
	        validaEdad(15);
	    }
	    catch(Exception e) {
	        System.out.println("Excepción recibida --> " + e);
	    }
	 }
}
