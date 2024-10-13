package Comparable;

public class Main {
	public static void main(String[] args) {
		User user1 = new User(1, "yagovr");
		User user2 = new User(2, "claudiagl");
		
		System.out.println("compareTo: "+user1.compareTo(user2));
		user1.regSystemLogin();
		System.out.println("getLastLogin: "+user1.getlLastLogin());
		System.out.println(user1.toString());
		System.out.println(user1.equals(user2));
		System.out.println(user1.hashCode());
		
	}
}
