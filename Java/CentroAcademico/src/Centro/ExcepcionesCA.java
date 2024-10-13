package Centro;
import java.util.Date;

public class ExcepcionesCA extends Exception{
	private Date fecha = new Date();
	
	ExcepcionesCA(Asignaturas asig, String msg) {
		super(msg);
	}
	public Date getFecha() {
		return fecha;
		
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
		
	}
}
