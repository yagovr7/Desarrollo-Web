package NBA;

import java.io.Serializable;

public class Rookie extends Jugadores implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int num_draft;

	public Rookie(String nombre, int dorsal, double salario, int num_draft) throws Exception {
		super(nombre, dorsal, salario);
		this.num_draft = num_draft;
		this.setSalario(500000/this.num_draft);
		
	}
	
	
}
