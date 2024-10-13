package HerenciaEjercicio4;

public class Hombre extends Persona{
	private boolean hizoMili;

	public boolean isHizoMili() {
		return hizoMili;
	}

	public void setHizoMili(boolean hizoMili) {
		this.hizoMili = hizoMili;
	}
	
	Hombre(int edad, boolean hizoMili){
		super(edad);
		this.hizoMili = hizoMili;
	}
}
