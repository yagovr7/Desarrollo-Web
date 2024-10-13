package Autoevaluacion;

public class Ejercicio10 {
	
	public static boolean contains(int[] a1, int[] a2) {
		if(a1.length<a2.length) {
			return false;
		}else{
			for(int j = 0;j<a2.length;j++) {
				for(int i = 0;i<a1.length;i++) {
					if(a1[i]==a2[j]&&a1[i+1]==a2[j+1]&&a1[i+2]==a2[j+2]) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a2 = {1, 2, 1};
		int[] a3 = {1, 2, 2, 2, 5, 7, 9, 9, 9};
		int[] a4 = {2, 1, 2};
		
		
		System.out.println(contains(a1,a2));
	}
}
