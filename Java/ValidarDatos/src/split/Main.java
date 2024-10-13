package split;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Pattern p = Pattern.compile(" ");
		String tmp = "this is a test";
		String[] tokens = p.split(tmp);
		for (int i = 0; i < tokens.length; i++) {
		    System.out.println(tokens[i]);
		}
		
		Pattern pat; 
		Matcher mat; 
		pat = Pattern.compile("-?\\d+"); 
		mat=pat.matcher("-1234"); 
		System.out.println(mat.matches());
	}
}
