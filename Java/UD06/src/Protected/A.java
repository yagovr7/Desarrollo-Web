package Protected;

public class A {
	public static void main(String[] args) {
		B b = new B();
		//System.out.println(b.w); Error por ser acceso private
		System.out.println(b.x);
		System.out.println(b.y);
		System.out.println(b.z);
	}
}
