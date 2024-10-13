package Ejercicio3;

class Circulo extends Figura {
    private double radio;
    public Circulo(double radio, String color) throws Exception  {
        super(color);
        this.radio = radio;
    }
    @Override
    public double area() {
        return Math.PI * radio * radio;
    }
}
