package Ejercicio1;

class Numeros<T, V> {
	 private T first;
	 private V second;
	 public T getFirst() {
	 return first;
	 }
	 public V getSecond() {
	 return second;
	 }
	 public void setFirst(T first) {
	 this.first = first;
	 }
	 public void setSecond(V second) {
	 this.second = second;
	 }
	 
	 Numeros(T t, V v){
		 this.first = t;
		 this.second = v;
	 }
	}
