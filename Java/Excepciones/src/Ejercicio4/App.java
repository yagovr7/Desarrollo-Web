package Ejercicio4;

public class App {
	public static void main(String[] args){
		try {
			Rectangulo miRectangulo=new Rectangulo(-2,3,4,5);
		}catch(Exception e){
			System.out.println("¡¡Error: numeros negativos en coordenadas de origen!!");
		}finally {
			System.out.println("Dejando try");
		}
        
}
}
