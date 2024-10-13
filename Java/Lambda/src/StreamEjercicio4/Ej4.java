package StreamEjercicio4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ej4 {
	public static void main(String[] args) {
		Factura f1 = new Factura(1, "PcComponentes", 201);
		Factura f2 = new Factura(2, "Amazon", 766.4);
		Factura f3 = new Factura(3, "G2A", 299.43);
		Factura f4 = new Factura(4, "Froiz", 126.4);
		Factura f5 = new Factura(5, "DAZN", 18.99);
		
		List<Factura> facturas = Arrays.asList(f1, f2, f3, f4, f5);
		Stream<Factura> filtrado = facturas.stream().filter(x -> x.getImporte()> 200);
		
		System.out.println("****Facturas mayores a 200€****");
		filtrado.forEach(x -> System.out.println("Numero: "+x.getNumero()+"\nConcepto: "+x.getConcepto()+"\nImporte: "+x.getImporte()+"€\n"));
		List<Factura> facturas2 = facturas.stream().filter(x -> x.getImporte()>=200 && x.getImporte()<=300)
				.collect(Collectors.toList());
		
		System.out.println("****Facturas entre 200€ y 300€****");
		facturas2.forEach(x -> System.out.println("Numero: "+x.getNumero()+"\nConcepto: "+x.getConcepto()+"\nImporte: "+x.getImporte()+"€\n"));
	}
}
