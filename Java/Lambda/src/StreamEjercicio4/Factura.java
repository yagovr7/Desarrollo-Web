package StreamEjercicio4;

import java.util.Objects;

public class Factura {
	private int numero;
	private String concepto;
	private double importe;
	
	public Factura(int numero, String concepto, double importe) {
		this.numero = numero;
		this.concepto = concepto;
		this.importe = importe;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
	public int hashCode() {
		return Objects.hash(numero, concepto, importe);
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(concepto, other.concepto)
				&& Double.doubleToLongBits(importe) == Double.doubleToLongBits(other.importe) && numero == other.numero;
	}
	
	public String toString() {
		return "Factura numero: " + numero + "\nConcepto: " + concepto + "\nImporte: " + importe;
	}
	
	
	
	
}
