package CentroCultural;
import java.util.Scanner;
import java.time.LocalDate;

public class Centro {
	Cliente clientes[] = new Cliente[5];
	Libro librosC[] = new Libro[15];
	Disco discosC[] = new Disco[15];
	//Centro estanteria [][]= new Centro [2][15]; Non necesaria creo
	private static Scanner sc;
	
	public void menu() {
		System.out.println("Menu de opciones");
		System.out.println("1.Dar de alta Cliente");
		System.out.println("2.Dar de alta Materiales");
		System.out.println("3.Realizar prestamo");
		System.out.println("4.Consultar prestamos del Cliente");
		System.out.println("5.Comparar libros");
		System.out.println("6.Salir");
	}
	
	
	public static void main(String[] args) {
		int opcion;
		sc = new Scanner(System.in);
		
		LocalDate inicio = LocalDate.now();
		LocalDate fin = LocalDate.now().plusDays(15);
		
		Centro centro = new Centro();
		
		Cliente c1 = new Cliente();
		Cliente c2 = new Cliente(12345678,"Claudia");
		Cliente c3 = new Cliente(23456789,"Maria");
		Cliente c4 = new Cliente(34567890,"Vila");
		Cliente c5 = new Cliente(45678901,"Mateo");
		
		centro.clientes[0]=c1;
		centro.clientes[1]=c2;
		centro.clientes[2]=c3;
		centro.clientes[3]=c4;
		centro.clientes[4]=c5;
		
		
		Libro l1 = new Libro();
		Libro l2 = new Libro(1,"El Resplandor",1,2,"Stephen King",599);
		Libro l3 = new Libro(2,"Cementerio de animales",1,3,"Stephen King",488);
		Libro l4 = new Libro(3,"La niebla",1,4,"Stephen King",320 );
		Libro l5 = new Libro(4,"La Cupula",1,5,"Stephen King",1132);
		
		centro.librosC[0]=l1;
		centro.librosC[1]=l2;
		centro.librosC[2]=l3;
		centro.librosC[3]=l4;
		centro.librosC[4]=l5;
		
		Disco d1 = new Disco();
		Disco d2 = new Disco(1,"Meteora",2,2,"Linkin Park","Machine Shop Records" );
		Disco d3 = new Disco(2,"One More Light",2,3,"Linkin Park","Machine Shop Records" );
		Disco d4 = new Disco(3,"Live in Texas",2,4,"Linkin Park","Machine Shop Records" );
		Disco d5 = new Disco(4,"The Hunting Party",2,5,"Linkin Park","Machine Shop Records" );
		
		centro.discosC[0]=d1;
		centro.discosC[1]=d2;
		centro.discosC[2]=d3;
		centro.discosC[3]=d4;
		centro.discosC[4]=d5;
		
		
		centro.menu();
		opcion = sc.nextInt();
		
		while(opcion!=6) {
			
			switch(opcion) {
				
				case 1:
					System.out.println("ALTA CLIENTE");
					System.out.println("DNI: ");
					c1.setDni(sc.nextInt());
					System.out.println("Nombre: ");
					c1.setNombre(sc.next());
					c1.alta();
					break;
					
				case 2:
					System.out.println("ALTA MATERIAL");
					System.out.println("1.Libro");
					System.out.println("2.Disco");
					opcion = sc.nextInt();
					switch(opcion) {
						case 1:
							System.out.println("ALTA LIBRO");
							System.out.println("Codigo:");
							l1.setCodigo(sc.nextInt());
							System.out.println("Titulo:");
							l1.setTitulo(sc.next());
							System.out.println("Estanteria:");
							l1.setEstanteria(sc.nextInt());
							System.out.println("Altura:");
							l1.setAltura(sc.nextInt());
							System.out.println("Autor:");
							l1.setAutor(sc.next());
							System.out.println("Numero de paginas:");
							l1.setNum_paginas(sc.nextInt());
							break;
						case 2:
							System.out.println("ALTA DISCO");
							System.out.println("Codigo:");
							d1.setCodigo(sc.nextInt());
							System.out.println("Titulo:");
							d1.setTitulo(sc.next());
							System.out.println("Estanteria:");
							d1.setEstanteria(sc.nextInt());
							System.out.println("Altura:");
							d1.setAltura(sc.nextInt());
							System.out.println("Autor:");
							d1.setAutor(sc.next());
							System.out.println("Discografia:");
							d1.setDiscografia(sc.next());
							break;
							
					}
					break;
				case 3:
					System.out.println("PRESTAMOS");
					System.out.println("DNI CLiente: ");
					int dniC = sc.nextInt();
					System.out.println("Selecciona el material 1 Libro o 2 Discos: ");
					int eleccion = sc.nextInt();
					System.out.println("ID Material: ");
					int idMaterial = sc.nextInt();
					Libro auxLibro = new Libro();
					Disco auxDisco = new Disco();
					
					if(eleccion==1) {
						for(int i = 0;i<centro.clientes.length;i++) {
							if(centro.clientes[i].getDni()==dniC) {
								for(int j =0;j<centro.librosC.length;j++) {
									if(centro.librosC[j]!=null&&centro.librosC[j].getCodigo()==idMaterial) {
										auxLibro=centro.librosC[j];
										for(int z = 0;z<c1.prestamosLibros.length;z++) {
											if(centro.clientes[i].prestamosLibros[z]==null) {
												centro.clientes[i].prestamosLibros[z]=new Prestamo(dniC,auxLibro.getCodigo(), inicio, fin );
												break;
											}
										}
										
									}
								}
								}
							}
						
						break;
					}else if(eleccion==2) {
						for(int i = 0;i<centro.clientes.length;i++) {
							if(centro.clientes[i].getDni()==dniC) {
								for(int j =0;j<centro.discosC.length;j++) {
									if(centro.discosC[j]!=null&&centro.discosC[j].getCodigo()==idMaterial) {
										auxDisco=centro.discosC[j];
										for(int z = 0;z<c1.prestamosDiscos.length;z++) {
											if(centro.clientes[i].prestamosDiscos[z]==null) {
												centro.clientes[i].prestamosDiscos[z]=new Prestamo(dniC,auxDisco.getCodigo(), inicio, fin );
												break;
											}
										}
									}
								}
								}
							}				
					}
				break;
				
				case 4:
						System.out.println("DNI Cliente: ");
						int dni = sc.nextInt();
						
						for(int i = 0;i<centro.clientes.length;i++) {
							if(centro.clientes[i].getDni()==dni){
								System.out.println("Nombre: "+centro.clientes[i].getNombre());
								centro.clientes[i].obtenerLetra(dni);
								System.out.println();
								System.out.println("PRESTAMOS LIBROS");
								System.out.println();
								for(int j = 0;j<centro.librosC.length;j++) {
									if(centro.librosC[j]!=null) {
										for(int x = 0;x<c1.prestamosLibros.length;x++) {
											if(centro.clientes[i].prestamosLibros[x]!=null) {
												if(centro.clientes[i].prestamosLibros[x].getCodigoMaterial()==centro.librosC[j].getCodigo()) {
													centro.librosC[j].informacion();
													System.out.println("Fecha Inicio: "+centro.clientes[i].prestamosLibros[x].getInicio());
													System.out.println("Fecha Fin: "+centro.clientes[i].prestamosLibros[x].getFin());
													System.out.println();		
											}
										}
									}
								}	
							}	
								System.out.println("PRESTAMOS DISCOS");
								System.out.println();
								for(int j = 0;j<centro.discosC.length;j++) {
									if(centro.librosC[j]!=null) {
										for(int x = 0;x<c1.prestamosDiscos.length;x++) {
											if(centro.clientes[i].prestamosDiscos[x]!=null) {
												if(centro.clientes[i].prestamosDiscos[x].getCodigoMaterial()==centro.discosC[j].getCodigo()) {
													centro.discosC[j].informacion();
													System.out.println("Fecha Inicio: "+centro.clientes[i].prestamosDiscos[x].getInicio());
													System.out.println("Fecha Fin: "+centro.clientes[i].prestamosDiscos[x].getFin());
													System.out.println();
													
													
											}
										}
									}
								}	
							}
						}	
					}
						System.out.println();
					break;
				case 5:
					int primero;
					int segundo;
					Libro aux1 = new Libro();
					Libro aux2 = new Libro();
					System.out.println("COMPARAR LIBROS");
					System.out.println("ID primer libro: ");
					primero = sc.nextInt();
					System.out.println("ID segundo libro: ");
					segundo = sc.nextInt();
					System.out.println();
					
					for(int i = 0;i<centro.librosC.length;i++) {
						if(centro.librosC[i]!=null&&centro.librosC[i].getCodigo()==primero) {
							aux1=centro.librosC[i];
						}
					}
					
					for(int i = 0;i<centro.librosC.length;i++) {
						if(centro.librosC[i]!=null&&centro.librosC[i].getCodigo()==segundo) {
							aux2=centro.librosC[i];
						}
					}
					System.out.println("Resultado: "+aux1.equals(aux2));
					
					
					break;
			
			}
			centro.menu();
			opcion = sc.nextInt();
		}
		
	}
	
}
