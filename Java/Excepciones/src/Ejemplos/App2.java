package Ejemplos;

class App2 {
public static void main(String[] args) {
    int pesoPaquete=10;
    int divisor=0;
    try{ 
        System.out.println("antes de que se genere la excepción");
        pesoPaquete=pesoPaquete/divisor;
        pesoPaquete= Integer.parseInt("10.5");
        System.out.println("esto jamás se imprime");
    }catch(ArithmeticException miExcepcion){
        System.out.println("muy, muy, muy, mal no se puede dividir por cero");
    }catch(NumberFormatException miExcepcion){
        System.out.println("imposible convertir en entero ése string");
    }
    System.out.println("el programa sigue su ejecución se recupero de la excepción ...");
}
}
