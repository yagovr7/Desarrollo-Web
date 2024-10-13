package PolimorfismoAnimal;

public class Fauna {
	Animal animal;
	public static void main(String[] args) {
		    Animal[] lista = new Animal[3]; //referencias a la superclase
		    lista[0] = new Gato("Tom", 7);
		    lista[1] = new Perro("Scooby", 10);
		    lista[2] = new Estudiante("Rigby", 14); //Añadimos al array varias instancias de las distintassubclases
		    
		    for(Animal a: lista)
		        System.out.println(a.habla());
		 }
		   
}
