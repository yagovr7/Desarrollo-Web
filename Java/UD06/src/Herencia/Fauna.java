package Herencia;

public class Fauna {
	
	public static void main(String[] args) {
		
		Animal mi_animal = new Animal();
		System.out.println(mi_animal);
		mi_animal.setNombre("Dude");
		mi_animal.setEdad(3);
		
		System.out.println(mi_animal);
		
		Gato yin = new Gato();
		yin.setNombre("YinYang");
		yin.setEdad(2);
		System.out.println(yin);
		System.out.println(yin.habla());
		
		Perro blob = new Perro();
		blob.setNombre("Blob");
		blob.setEdad(5);
		System.out.println(blob);
		System.out.println(blob.habla());
	}
}
