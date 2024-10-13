package Ejercicio1File;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static void main(String[] args) {
		File file = new File("src");
		
		boolean fileIsFile  = file.isDirectory();
		boolean fileWriteable = file.canWrite();
		
		Path path = Paths.get("src");
		
		boolean fileIsFile2  = Files.isRegularFile(path);
		boolean fileWriteable2 = Files.isWritable(path);
		
		System.out.println(fileIsFile+" "+fileWriteable+" "+fileIsFile2+" "+fileWriteable2);
	}
}
