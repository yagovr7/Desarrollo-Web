package Serializacion;

import java.io.*;
//clase de proba
class Persona implements Serializable{
  String nombre;
  int edad;

  public Persona(String nombre, int edad) {
      this.nombre = nombre;
      this.edad = edad;
  }
}
