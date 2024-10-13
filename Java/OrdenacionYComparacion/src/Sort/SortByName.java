package Sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByName implements Comparator<Fruit> {
    @Override
    public int compare(Fruit a, Fruit b) {
        return a.getName().compareTo(b.getName());
    }
    public static void main(String[] args) {
    	List<Fruit> fruits = new ArrayList<Fruit>();
		Fruit f1 = new Fruit(6,"b","2");
		Fruit f2 = new Fruit(2,"c","3");
		Fruit f3 = new Fruit(1,"a","1");
		fruits.add(f1);
		fruits.add(f2);
		fruits.add(f3);
    	//Uso
    	Collections.sort(fruits, new SortByName());
    	
    	fruits.forEach(s -> System.out.println(s.getId()));
	}
}


