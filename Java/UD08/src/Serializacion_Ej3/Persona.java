package Serializacion_Ej3;

import java.io.Serializable;

public class Persona implements Serializable{
	private transient static final long serialVersionUID = 1L;
	String nome;
	transient String pwd;
	
	Persona(String n, String p){
		this.nome = n;
		this.pwd = p;
	}	
}
