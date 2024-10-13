package Ejercicio2F_Texto;
import java.util.TreeSet;

public class Productos {
	private String codProd;
	private String tipo;
	private String nome;
	private double prezo;
	private String pais;
	TreeSet<String> prov;
	
	Productos(String codProd, String tipo, String nombre, double precio, String pais){
		this.codProd = codProd;
		this.tipo = tipo;
		this.nome = nombre;
		this.prezo = precio;
		this.pais = pais;
	}
	
	Productos(String codProd, String tipo, String nombre, double precio, String pais, TreeSet<String> prov){
		this.codProd = codProd;
		this.tipo = tipo;
		this.nome = nombre;
		this.prezo = precio;
		this.pais = pais;
		this.prov = prov;
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezo() {
		return prezo;
	}

	public void setPrezo(int prezo) {
		this.prezo = prezo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}
