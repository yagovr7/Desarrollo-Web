package Ficheros_de_Texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerLineasScanner {
    public static void main(String[] args) { 
        //obxecto file para Scanner
        File f = new File("prueba.txt");
        String cadena;
        Scanner entrada = null;
        try {
            entrada = new Scanner(f);         //crease un Scanner asociado o ficheiro
            while (entrada.hasNext()) {       //mentres non se alcance o final do ficheiro                       
                cadena = entrada.nextLine();  //lese unha liña do ficheiro
                System.out.println(cadena);   //mostrase por pantalla                                           
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            entrada.close();                                                                                      
        }}}
