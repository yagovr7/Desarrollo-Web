package Serializacion;

import java.io.*;

class Rectangulo implements Serializable{
    Punto origen;
    int base;
    int altura;
    Rectangulo(int x, int y, int base, int altura){
        origen=new Punto(x,y);
        this.base=base;
        this.altura=altura;
    }
    public String toString(){
        return origen.x+","+origen.y+","+base+","+altura;
    }

}
