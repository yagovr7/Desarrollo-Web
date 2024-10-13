package Serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class SobreEscrituraSer{ 
    public static void main(String[] args) throws IOException, ClassNotFoundException{      
        //Primeira escritura normal
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persoas.dat"));
        Persona p;
        p = new Persona("Juan Lopez", 30);
        oos.writeObject(p);
        oos.close();     
        //Aa segunda e de adelante usamos noso MiobjectOutputStream
        //Parametro true para a agregación de objetos
         MiObjectOutputStream moos = new MiObjectOutputStream(new FileOutputStream("persoas.dat",true));
        p = new Persona("Jose Fernandez", 28);
        moos.writeObject(p);
        moos.close();
        MiObjectOutputStream moos1 = new MiObjectOutputStream(new FileOutputStream("persoas.dat",true));
        p = new Persona("Yago Vila", 26);
        moos1.writeObject(p);
        moos1.close();
        MiObjectOutputStream moos11 = new MiObjectOutputStream(new FileOutputStream("persoas.dat",true));
        p = new Persona("Claudia Garrido", 23);
        moos11.writeObject(p);
        moos11.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persoas.dat"));
        p=(Persona)ois.readObject();
        System.out.println(p.nombre+", "+p.edad);
        p=(Persona)ois.readObject();
        System.out.println(p.nombre+", "+p.edad);
        p=(Persona)ois.readObject();
        System.out.println(p.nombre+", "+p.edad);
        p=(Persona)ois.readObject();
        System.out.println(p.nombre+", "+p.edad);
        ois.close();
 }
}
