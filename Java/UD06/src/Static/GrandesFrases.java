package Static;

class Adios{
	static void chao(){
		System.out.println("chao a todos");
}
	static void bye(){
		System.out.println("bye bye a todos");
	}
}

class Misterios{
	static void profesor(){
		System.out.println("¿Usa champú el profesor?");
	}
}

public class GrandesFrases{
	public static void main(String args[]){
		Adios.chao();
		Adios.bye();
		Misterios.profesor();
	}
}
