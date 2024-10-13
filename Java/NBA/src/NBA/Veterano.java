package NBA;

import java.io.Serializable;

public class Veterano extends Jugadores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int anos;
	Equipo ultimo_equipo;
	
	Veterano(String nombre, int dorsal, double salario, int anos, Equipo ultimo_equio) throws Exception{
		super(nombre, dorsal, salario);
		this.anos = anos;
		this.ultimo_equipo = ultimo_equio;
	}
}
