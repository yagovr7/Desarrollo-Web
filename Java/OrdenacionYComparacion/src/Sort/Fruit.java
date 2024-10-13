package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fruit implements Comparable<Object>{
    private int id;
    private String name;
    private String taste;

    Fruit(int id, String name, String taste){
        this.id=id;
        this.name=name;
        this.taste=taste;
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

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	@Override 
    public int compareTo(Object o) {
        Fruit f = (Fruit) o; 
        return this.id - f.id ;
    }
    public static void main(String[] args) {
    	List<String> fruitList = new ArrayList<String>();
    	fruitList.add("Apple");
    	fruitList.add("Orange");
    	fruitList.add("Banana");
    	fruitList.add("Grape");
    	//Uso el mismo
    	Collections.sort(fruitList);
    	//fruitList.forEach(fruit -> {
    	    //System.out.println(fruit.get + " " + fruit.getName() + " " + 
    	    		//fruit.getTaste()));
    	}
	}
//}




