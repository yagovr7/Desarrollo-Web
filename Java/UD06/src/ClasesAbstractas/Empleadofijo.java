package ClasesAbstractas;

class EmpleadoFijo extends Empleado{
	public EmpleadoFijo(String nombre, int ant) {
		super(nombre, ant);
	}
		
		int calcularNomina(){
			return sueldoBase + 100*ant;
			}
}
