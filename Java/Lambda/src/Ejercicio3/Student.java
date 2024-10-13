package Ejercicio3;

public class Student {
	private int id;
	private String name;
	private String gender;
	private int age;
	
	Student(int i, String n, String g, int a){
		this.id = i;
		this.name = n;
		this.gender = g;
		this.age = a;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
