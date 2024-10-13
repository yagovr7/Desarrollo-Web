package RowSetE1;

public class Person {

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    
    public Person(){
    	this.id = 0;
    	this.name = null;
    	this.lastName = null;
    	this.age = 0;
    }
    
    public Person(String name, String lastName, int age){
    	this.id = 0;
    	this.name = name;
    	this.lastName = lastName;
    	this.age = age;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
    
    
}
