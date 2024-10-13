package PolimorfismoEjercicio3;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GPS{
	private int coordenadaX;
	private int coordenadaY;
	private LocalDate fechaHoy = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	private LocalTime horaHoy = LocalTime.now();
	DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("H:mm:ss");
	String fecha;
	private String hora;
	private int diasTripulados;
	
	
	public GPS(int X, int Y, int dias) {
		this.coordenadaX = X;
		this.coordenadaY = Y;
		this.fecha = fechaHoy.format(formatter);
		this.hora = horaHoy.format(formatterr);
		this.diasTripulados = dias;
		
	}
	
	
	public int getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public int getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getDiasTripulados() {
		return diasTripulados;
	}
	public void setDiasTripulados(int diasTripulados) {
		this.diasTripulados = diasTripulados;
	}
	
	
}

