package Ejercicio3;


public class Alumno{
	private String nombre;
	private int primera;
	private int segunda;
	private int tercera;
	private int media;
	
	Alumno(String n, int p, int s, int t){
		this.nombre = n;
		this.primera = p;
		this.segunda = s;
		this.tercera = t;
		this.media = (this.primera+this.segunda+this.tercera)/3;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrimera() {
		return primera;
	}

	public void setPrimera(int primera) {
		this.primera = primera;
	}

	public int getSegunda() {
		return segunda;
	}

	public void setSegunda(int segunda) {
		this.segunda = segunda;
	}

	public int getTercera() {
		return tercera;
	}

	public void setTercera(int tercera) {
		this.tercera = tercera;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}
	
	
}
