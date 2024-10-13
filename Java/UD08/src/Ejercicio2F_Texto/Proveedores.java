package Ejercicio2F_Texto;

public class Proveedores {
	private String codProv;
	private String nome;
	private String enderezo;
	
	Proveedores (String cod, String nom, String end){
		this.codProv = cod;
		this.nome = nom;
		this.enderezo = end;
	}

	public String getCodProv() {
		return codProv;
	}

	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnderezo() {
		return enderezo;
	}

	public void setEnderezo(String enderezo) {
		this.enderezo = enderezo;
	}
	
	
}
