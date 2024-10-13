package Serializacion;

import java.io.*;

class Unidad6{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rectangulos.dat"));
        Rectangulo r;
        r = new Rectangulo(0,0,2,3);
        oos.writeObject(r);
        r = new Rectangulo(2,3,10,10);
        oos.writeObject(r);
        oos.close();
        
    }
}
