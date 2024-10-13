package javaNIO;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		java.io.File file = new java.io.File("src");
		try {
			boolean result = file.createNewFile();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
