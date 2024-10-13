package ejercicioAhorcado;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		char[] PALABRAOBJETIVO = "PROGRAMANDO".toCharArray();
		char[] aciertos = "___________".toCharArray();
		int fail = 0;
		int contador = 0;
		String resultado =" ";
		
		//System.out.print("Jugar la letra:");
		//String letra = sc.next();
		
		//for(int i = 0;i<PALABRAOBJETIVO.length;i++) {
			//System.out.print(PALABRAOBJETIVO[i]);
		//}
		
		//While
		while(fail!=10) {
			System.out.print("Jugar la letra:");
			char letra = sc.next().charAt(0);
			
				//FOR
				for(int i = 0;i<PALABRAOBJETIVO.length;i++) {
						if(letra==PALABRAOBJETIVO[i]) {
							aciertos[i]=letra;
						}else {
							contador++;
							if(contador==11) {
								fail++;
								break;
							}
						}
					
					
				}//Fin FOR
			
			
				contador=0;
				resultado = resultado+letra;
				switch(fail) {
					case 1:
						System.out.println("+------");
						break;
					case 2:
						System.out.println(
								"\n+"+
								"\n|"+
								"\n|"+
								"\n|"+
								"\n|\n"+
								"+------");
						break;
					case 3:
						System.out.println(
								"\n+----+"+
								"\n|"+
								"\n|"+
								"\n|"+
								"\n|\n"+
								"+------");
						break;
					case 4:
						System.out.println(
								"\n+----+"+
								"\n|    |"+
								"\n|"+
								"\n|"+
								"\n|\n"+
								"+------");
						break;
					case 5:
						System.out.println(
								"\n+----+"+
								"\n|    |"+
								"\n|    ()"+
								"\n|"+
								"\n|\n"+
								"+------");
						break;
					case 6:
						System.out.println(
								"\n+----+"+
								"\n|    |"+
								"\n|    ()"+
								"\n|    []"+
								"\n|\n"+
								"+------");
						break;
					case 7:
						System.out.println(
								"\n+----+"+
								"\n|    |"+
								"\n|    ()"+
								"\n|   /[]"+
								"\n|\n"+
								"+------");
						break;
					case 8:
						System.out.println(
								"\n+----+"+
								"\n|    |"+
								"\n|    ()"+
								"\n|   /[]\\"+
								"\n|\n"+
								"+------");
						break;
					case 9:
						System.out.println(
								"\n+----+"+
								"\n|    |"+
								"\n|    ()"+
								"\n|   /[]\\"+
								"\n|    /\n"+
								"+------");
						break;
					case 10:
						System.out.println(
								"\n+----+"+
								"\n|    |"+
								"\n|    ()"+
								"\n|   /[]\\"+
								"\n|    /\\\n"+
								"+------");
						break;
				}
				System.out.println("Letras jugadas: "+resultado);
				System.out.print("Letras acertadas: ");
				for(int j = 0;j<PALABRAOBJETIVO.length;j++) {
					System.out.print(aciertos[j]);
				}
				System.out.println();
				System.out.println("Fallos: "+fail);
				System.out.println();
				if(aciertos[0]=='P'&&aciertos[1]=='R'&&aciertos[2]=='O'&&aciertos[3]=='G'&&aciertos[4]=='R'
						&&aciertos[5]=='A'&&aciertos[6]=='M'&&aciertos[7]=='A'&&aciertos[8]=='N'
						&&aciertos[9]=='D'&&aciertos[10]=='O') {
					System.out.println("YOU WIN");
					System.exit(0);
				}
		}//Fin While
		System.out.println("GAME OVER");
	}	
}

