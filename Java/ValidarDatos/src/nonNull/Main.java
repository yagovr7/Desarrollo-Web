package nonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
	public static void main(String[] args) {
		List<String> lista= new ArrayList<String>();
	    lista.add("juan");
	    lista.add("ana");
	    lista.add("gema");
	    lista.add(null);
	    lista.add("blanca");
	    lista.add(null);
	    lista.add("david");
	    for (String p:lista) { 
	      if (Objects.nonNull(p)) {
	        System.out.println(p);
	      }
	    }
	}
}
