package Ejercicio3;

abstract class Figura {
    protected String color;
    public Figura(String color) throws Exception {
    	if (color.equals("blanco")) {
            throw new Exception("No se puede crear una figura de color blanco.");
        }
        this.color = color;
    }
    abstract public double area();
}