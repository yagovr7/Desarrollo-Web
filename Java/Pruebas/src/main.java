import java.text.DecimalFormat;

public class main {
	public static void main(String[] args) {
		DecimalFormat f = new DecimalFormat("#.###");
		System.out.println(f.format(5.344557348579));
	}
}
