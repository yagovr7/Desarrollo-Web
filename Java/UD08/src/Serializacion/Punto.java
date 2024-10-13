package Serializacion;

import java.io.*;
class Punto implements Serializable{
    int x;
    int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
