package recursividad;

public class Recursividad {
	void imprimir(int x) {
		//Ejemplo 1
		/* imprimir(x);
		 System.out.println(x);*/
		
		//Ejemplo 2
		/*if(x>0){//hay una condición de parada
			 System.out.println(x);
			 imprimir(x-1);//observa que x evoluciona
			 }*/
		
		//Ejemplo 3
		if(x>0){
			imprimir(x-1);
			 System.out.println(x);
			 }


		 } 
}
