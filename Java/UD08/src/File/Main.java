package File;
import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		File prueba = new File("c:\\midirectorio\\prueba.txt");
        if(!prueba.exists())
            System.out.println("c:\\midirectorio\\prueba.txt NO existe");
        if(!new File("c:\\midirectorio").exists())
            System.out.println("c:\\midirectorio NO existe");
        if(!new File("m:").exists())
            System.out.println("m: NO existe");
        
        if(new File("l:\\midirectorio\\prueba.txt").exists())
            System.out.println("l:\\midirectorio\\prueba.txt existe");
        
        String directorio = "Pirolas";
        String varios = "carpeta1/carpeta2/carpeta3";

        // Crear un directorio
        boolean exito = (new File(directorio)).mkdir();
        if (exito)
            System.out.println("Directorio: " + directorio + " creado");
        // Crear varios directorios
        exito = (new File(directorio+"/"+varios)).mkdirs();
        if (exito)
            System.out.println("Directorios: " + varios + " creados");
	}
}
