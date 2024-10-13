package Ejemplos;

class App {
public static void main(String[] args) {
    int pesoPaquete;
    try{ 
        System.out.println("antes de que se genere la excepción");
        pesoPaquete=10/0;
        System.out.println("esto jamás se imprime");
    
    }catch(ArithmeticException miExcepcion){
        System.out.println("muy, muy, mu mal: no se puede dividir por cero");
    }
}
}

