package Ficheros_de_Texto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerLineas {   
    public static void main(String[] args) throws FileNotFoundException, IOException {
     
        File doc = new File("prueba.txt");
        //Uso do try with resources, non fai falta usar o close 
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(doc))){
        String line = bufferedReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
}}}