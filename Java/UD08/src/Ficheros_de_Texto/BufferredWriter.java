package Ficheros_de_Texto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferredWriter {
	public static void main(String[] args) throws IOException {
		 // A partir de Java 9 hai unha mellora do try-with-resources
        // Desta forma cerrase o buffer cando termina, reducese a try
        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
            try (writer) {         
                writer.write("Esto e unha linea");
                writer.newLine();
                writer.write("Esto e unha linea");
            }     
   }}

