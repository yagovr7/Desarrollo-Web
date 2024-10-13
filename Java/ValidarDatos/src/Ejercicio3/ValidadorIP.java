package Ejercicio3;

class ValidadorIP{
	public static boolean validarIP(String direccionIP) {
	    String[] grupos = direccionIP.split("\\.");

	    if (grupos.length != 4) {
	        return false;
	    }

	    for (String grupo : grupos) {
	        try {
	            int valor = Integer.parseInt(grupo);
	            if (valor < 0 || valor > 255) {
	                return false;
	            }
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }

	    return true;
	}
	public static void main(String[] args) {
		System.out.println(validarIP("192.168.1.1"));
		
	}
}

