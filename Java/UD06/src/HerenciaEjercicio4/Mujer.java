package HerenciaEjercicio4;

public class Mujer extends Persona{
	private boolean fueMadre;

	public boolean isFueMadre() {
		return fueMadre;
	}

	public void setFueMadre(boolean fueMadre) {
		this.fueMadre = fueMadre;
	}
	
	Mujer(int edad, boolean fueMadre){
		super(edad);
		this.fueMadre = fueMadre;
	}
}
