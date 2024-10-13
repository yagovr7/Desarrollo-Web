package numeros;

public class Complejo {
	double real;
	double imag;
	double sumar;
	
	public Complejo() {
		real = 0;
		imag = 0;
	}
	
	public Complejo(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public double getReal() {
		return real;
	}
	public double getImag() {
		return imag;
	}
	public void setReal(double real) {
		this.real = real;
	}
	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public String toString() {
		return String.format("%.0f + %.0fi", real, imag);
	}
	
	public void sumar(Complejo b) {
		double sumaReal = this.real+b.real;
		double sumaImag = this.imag+b.imag;
		System.out.printf("La suma real de %.0f + %.0f = %.0f",this.real, b.real, sumaReal);
		System.out.printf("\nLa suma imaginaria de %.0fi + %.0fi = %.0fi",this.imag, b.imag, sumaImag);
		this.real = sumaReal;
		this.imag = sumaImag;
		return;
		
	}

	public String convertirAString() {
		// TODO Auto-generated method stub
		return null;
	}
}

