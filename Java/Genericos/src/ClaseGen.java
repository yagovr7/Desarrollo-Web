public class ClaseGen<T> {
 T miVal; //se declara una variable tipo parametrizado

 //tipo T lo podemos usar en métodos sin problemas
 public ClaseGen(T val) {
 this.miVal = val;
 }
 public T getMiVal() {
 return this .miVal;
 }
 public String toString() {
 return "ClaseGen<" + this.miVal.getClass().getName() + ">: miVal = " + this.miVal;
 }
}

