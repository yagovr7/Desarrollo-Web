class Pair<T, V> {
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
 Pair(T t, V v){
	 this.first = t;
	 this.second = v;
 }
 public static void main(String[] args) {
	Pair<String, Integer> p1 = new Pair("12",12);
	System.out.println(p1.getFirst());
}
}
