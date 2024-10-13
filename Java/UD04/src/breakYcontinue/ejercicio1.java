package breakYcontinue;

public class ejercicio1 {
	public static void main(String[] args) {
		 for(int i=1; i<=3;i++){
			 System.out.println("Bucle externo, COMIENZA iteración:"+i);
			 for(int j=1;j<=5;j++){
				 	if(j==3)
				 		continue;
				 	System.out.println("\tBucle interno en iteración:"+j);
		 }
			 		System.out.println("Bucle externo, FINALIZA iteración:"+i +"\n");
		}
	}
}
