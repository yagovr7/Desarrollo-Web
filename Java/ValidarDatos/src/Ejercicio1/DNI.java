package Ejercicio1;

public class DNI {
	private String dni;
	
	DNI(String x) throws dniException{
		String str = new String(x);
		if(str.matches("([0-9]{8})([A-Za-z)])")==false) {
			throw new dniException ("Debe contener 8 digitos y una letra");
		}
		this.dni = x;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
