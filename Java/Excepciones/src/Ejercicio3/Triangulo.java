package Ejercicio3;

class Triangulo extends Figura {
    private double base;
    private double altura;
    public Triangulo(double base, double altura, String color) throws Exception {
        super(color);
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double area() {
        return base * altura / 2;
    }

}
