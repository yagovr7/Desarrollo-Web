package InterfaceSerie;

public class Main {
	public static void main(String[] args) {
        MasDos ob2 = new MasDos();
        MasTres ob3 = new MasTres();
        /*
        for(int i=0;i<5;i++)
            System.out.println("el siguiente valor es: "+ ob.obtenerSiguiente());
        System.out.println("restableciendo ...");
        ob.restablecer();
        for(int i=0;i<5;i++)
            System.out.println("el siguiente valor es: "+ ob.obtenerSiguiente());
        System.out.println("empezando en 100 ...");
        ob.establecerInicio(100);
        for(int i=0;i<5;i++)
            System.out.println("el siguiente valor es: "+ ob.obtenerSiguiente());
            */
        
        System.out.println("De dos en dos ...");
        for(int i=0;i<5;i++)
        System.out.println("el siguiente valor es: "+ ob2.obtenerSiguiente());

        System.out.println("De tres en tres ...");
        for(int i=0;i<5;i++)
        System.out.println("el siguiente valor es: "+ ob3.obtenerSiguiente());

    }

}
