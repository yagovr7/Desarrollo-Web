package condicionalSwitch;

public class main {
	public static void main(String []args) {
		dia day = dia.L;
		switch (day) {
			 case L, V, D -> System.out.println(6);
			 case M -> System.out.println(7);
			 case J, S -> System.out.println(8);
			 case X -> System.out.println(9);
			}

	}
}
