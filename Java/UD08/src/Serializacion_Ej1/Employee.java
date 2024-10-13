package Serializacion_Ej1;

import java.io.Serializable;
//Sempre aínda que se introduza nunha colección
public class Employee implements Serializable {
 String id;
 String firstName;
 String lastName; 
 public Employee(String id, String firstName, String lastName) {
     super();
     this.id = id;
     this.firstName = firstName;
     this.lastName = lastName;
 }
 @Override
 public String toString() {
     return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
 }
}
