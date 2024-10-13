package Ejercicio1F_Bytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copia_Byte {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fix = null;
		DataInputStream entrada = null;
		DataOutputStream salida = null;
		byte n;
		try {
			fix = new FileOutputStream("copia_proba.txt");
			fis = new FileInputStream("proba.txt");
			entrada = new DataInputStream(fis);
			salida = new DataOutputStream(fix);
			while(true) {
				n = entrada.readByte();
				salida.write(n);
			}
		}catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
