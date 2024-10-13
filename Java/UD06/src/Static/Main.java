package Static;

/*
class Cohete{
	 static int numCohetes=14;
	 String nombre;
	 Cohete(String nombre){
	 numCohetes++;
	 this.nombre=nombre;
	 }
}
class Main{
	public static void main(String[] args) {
	System.out.println(" total de cohetes "+Cohete.numCohetes);
	Cohete c1 = new Cohete("C1");
	Cohete c2 = new Cohete("C2");
	Cohete c3 = new Cohete("C3");
	System.out.println(" total de cohetes "+Cohete.numCohetes);
	}
}*/


/*
class Cohete{
	static int numCohetes=14;
	String nombre;
	Cohete(String nombre){
	numCohetes++;
	this.nombre=nombre;
	}
}
class Main {
	public static void main(String[] args) {
	Cohete c1=new Cohete("Apollo 1");
	System.out.println("nombre de cohete c1:"+c1.nombre+" y numero total de cohetes "+c1.numCohetes);
	Cohete c2=new Cohete("Apollo 2");
	System.out.println("nombre de cohete c2:"+c2.nombre+" y numero total de cohetes "+c1.numCohetes);
	Cohete c3=new Cohete("Apollo 3");
	System.out.println("nombre de cohete c3:"+c3.nombre+" y numero total de cohetes "+c1.numCohetes);
	}
}*/


/*
class Cohete{
	static int numCohetes=14;
	String nombre;
	Cohete(String nombre){
	numCohetes++;
	this.nombre=nombre;
	}
}
class Main {
	public static void main(String[] args) {
	Cohete c1=new Cohete("Apollo 1");
	System.out.println("nombre de cohete c1:"+c1.nombre+" y numero total de cohetes "+c1.numCohetes);
	Cohete c2=new Cohete("Apollo 2");
	System.out.println("nombre de cohete c2:"+c2.nombre+" y numero total de cohetes "+c1.numCohetes);
	Cohete c3=new Cohete("Apollo 3");
	System.out.println("nombre de cohete c3:"+c3.nombre+" y numero total de cohetes "+c1.numCohetes);
	System.out.println("numero total de cohetes con c1: "+c1.numCohetes);
	System.out.println("numero total de cohetes con c2: "+c2.numCohetes);
	System.out.println("numero total de cohetes con c3: "+c3.numCohetes);
	System.out.println("numero total de cohetes con Cohete: "+Cohete.numCohetes);
	}
}*/


/*
class Impuesto{
	static int valormax=200;
	static int valormaxDiv2(){
	return valormax/2;
	}
}
public class Main {
		public static void main(String[] args) {
		System.out.println("valormax: "+ Impuesto.valormax);
		System.out.println("valormax dividido por 2: "+ Impuesto.valormaxDiv2());
		Impuesto.valormax=6000;
		System.out.println("valormax: "+ Impuesto.valormax);
		System.out.println("valormax dividido por 2: "+ Impuesto.valormaxDiv2());
		}
}*/


/*
class Impuesto{
	static int valormax=200;
	static int contadorImpuestos=0;
	int plusValorMaximo; //este valor dependerá de una instancia concreta de Impuesto, debe ser STATIC
	Impuesto(){
	contadorImpuestos++;
	}
	static int valormaxDiv2(){
	return (valormax+plusValorMaximo)/2;
	}
}
public class Main {
	public static void main(String[] args) {
	Impuesto impuesto1= new Impuesto();
	System.out.println("valormax: "+ Impuesto.valormax);
	System.out.println("valormax dividido por 2: "+ Impuesto.valormaxDiv2());
	System.out.println("Impuestos creados: "+ Impuesto.contadorImpuestos);
	}
}*/

//EJERCICIO2
/*
class Main{
	public static void main(String[] args) {
	Racional r1=new Racional(3,4);
	Racional r2=new Racional(1,2);
	Racional r3;
	r3=Racional.multiplicar(r1, r2);
	System.out.println("MUTIPLICACIÓN DE NÚMEROS RACIONALES");
	System.out.println("r1 vale: "+r1.numerador+"/"+r1.denominador);
	System.out.println("r2 vale: "+r2.numerador+"/"+r2.denominador);
	System.out.println("r3 vale: "+r3.numerador+"/"+r3.denominador);
	}
}*/

/*
class Potencia{
	 static int pot(int base,int exponente){
	 int resultado=1;
	 for(;exponente>0;exponente--){
	resultado=resultado*base;
	 }
	 return resultado;
	 }


 public static void main(String[] args) {
 //Potencia p = new Potencia();
 /*System.out.println(p.pot(2,1));
 System.out.println(p.pot(5,3));
 System.out.println(p.pot(9,0));*/
 /*
 System.out.println(Potencia.pot(2,1));
 System.out.println(pot(5,3));
 System.out.println(Potencia.pot(9,0));

 }
 }
 */
/*
class Utilidades{
	static void imprimir(int a) {
		System.out.println(a);
	}
	static void imprimir(double a) {
		System.out.println(a);
	}
	static void imprimir(char a) {
		System.out.println(a);
	}
	static void imprimir(String a) {
		System.out.println(a);
	}
	char sumar(char a, int b) {
		return (char)(a+b);
	}
	
	int sumar(int a, int b) {
		return a+b;
	}
	
	String sumar(String a, String b) {
		return a+b;
	}
}

public class Main{
	 public static void main(String[] args) {
	 Utilidades.imprimir(1);
	 Utilidades.imprimir(1.8);
	 Utilidades.imprimir('a');
	 Utilidades.imprimir("un string");
	 Utilidades u1=new Utilidades();
	 //Utilidades.imprimir(Utilidades.sumar('a',2)); ¡ERROR!
	 Utilidades.imprimir(u1.sumar('a',2));
	 u1.imprimir(u1.sumar(4,5));
	 Utilidades.imprimir(u1.sumar("hola", " y adios"));
	 }
	}*/

/*
class MiClase {
	 private int conAccesoPrivado;
	 public int conAccesoPublico;
	 int conAccesoPaquete; //sin modificador de control de acceso, es acceso nivel paquete
	 void setConAccesoPrivado(int i){
	 conAccesoPrivado=i;
	 }
	 int getConAccesoPrivado(){
	 return conAccesoPrivado;
	 }
	 
	 

	}
	class Main{
	 public static void main(String[] args) {
	 MiClase obj = new MiClase();
	 obj.conAccesoPublico=10;
	 obj.conAccesoPaquete=20;
	 obj.conAccesoPrivado=30;
	 System.out.println("el atributo privado vale: " + obj.conAccesoPrivado);
	 System.out.println("el atributo privado vale: " + obj.getConAccesoPrivado());
	 }
	}
*/



/*
class Main{
	 public static void main(String[] args) {
		Coche coche1 = new Coche();
		
		coche1.setPasajeros(5);
		coche1.setDeposito(60);
		coche1.setKpl(20);
		
		System.out.println("Pasajeros coche1: "+coche1.getPasajeros());
		System.out.println("Deposito coche1: "+coche1.getDeposito());
		System.out.println("Kpl coche1: "+coche1.getKpl());
		coche1.autonomia();
		}
}
*/

/*
class Main{
	 public static void main(String[] args) {
	 Racional r1=new Racional(3,4);
	 Racional r2=new Racional(1,2);
	 Racional r3=new Racional(1,1);
	 r3=Racional.multiplicar(r1, r2);
	 System.out.println("MUTIPLICACIÓN DE NÚMEROS RACIONALES");
	 System.out.println("r1 vale: "+r1.getNumerador()+"/"+r1.getDenominador());
	 System.out.println("r2 vale: "+r2.getNumerador()+"/"+r2.getDenominador());
	 System.out.println("r3 vale: "+r3.getNumerador()+"/"+r3.getDenominador());
	 }
}
*/

class Main {
	 public static void main(String[] args) {
	 Rectangulo r1= new Rectangulo(2,3,10,20);

	 System.out.println("Rectángulo referenciado por r1: "+r1.datosRectangulo());
	 r1.desplazar(3,2);
	 System.out.println("Rectángulo referenciado por r1 desplazado +3 en ejeX y +2 en eje y: "+r1.datosRectangulo());
	 Rectangulo r2 = r1.duplicar();
	 System.out.println("Rectangulo referenciado por r2, es un duplicado del objeto referenciado por r1 y vale"+r2.datosRectangulo());
	 r2.desplazar(-3,2);
	 System.out.println("Rectángulo referenciado por r2 fue desplazado -3 en ejeX y +2 en eje y: "+r2.datosRectangulo());
	 System.out.println("Rectángulo referenciado por r1 sigue valiendo: "+r1.datosRectangulo());
	 r1.setAncho(11);
	 System.out.println("Modificamos el ancho de r1 a 11: "+ r1.datosRectangulo());
	 System.out.println("Suponemos que dados dos rectángulos el mayor es el de mayor área, ¿el referenciado por r1 es mayor que el referenciado por r2?: "+ r1.esMayor(r2));
	 }
	}








