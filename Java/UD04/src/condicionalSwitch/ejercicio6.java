package condicionalSwitch;

public class ejercicio6 {
	
	private static String obtenerTipoDiaDeLaSemana(String day) {
		return switch (day) {
			case "L", "M", "X", "J", "V" -> "Laborable";
			case "S", "D" -> "Finde Semana";
			default -> "Día no reconocido";
		};
	}
	
	public static void main(String []args) {
		System.out.println(obtenerTipoDiaDeLaSemana("L"));
		System.out.println(obtenerTipoDiaDeLaSemana("S"));
		System.out.println(obtenerTipoDiaDeLaSemana("R"));
	}
}
