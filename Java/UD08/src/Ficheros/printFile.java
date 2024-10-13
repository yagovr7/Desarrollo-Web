package Ficheros;
import java.io.FileInputStream;
import java.io.IOException;

public class printFile {
	private static void printFile() throws IOException {
	    try(FileInputStream input = new FileInputStream("Prueba.txt")) {
	        int data = input.read();
	        while(data != -1){
	            System.out.print((char) data);
	            data = input.read();
	        }
	    }
	 }
	public static void main(String[] args) throws IOException {
		printFile();
	}
}
