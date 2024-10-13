package condicionalSwitch;

public class ejercicio5 {
	public static void main(String []args) {
		int month = 2;
		int year = 2024;
		System.out.println("Este programa calcula si un año es bisiesto\n");
		
		if(year % 4 ==0) {
			System.out.println("Año Bisiesto");
			switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 9:
				case 11:
					System.out.println("30 días");
					break;
				case 2:
					System.out.println("29 días");
					break;
				case 4:
				case 6:
				case 8:
				case 10:
				case 12:
					System.out.println("31 días");
					break;
			}
					
			}else if(year % 100 == 0) {
				System.out.println("Año no Bisiesto");
				switch (month) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 9:
					case 11:
						System.out.println("30 días");
						break;
					case 2:
						System.out.println("28 días");
						break;
					case 4:
					case 6:
					case 8:
					case 10:
					case 12:
						System.out.println("31 días");
						break;
				}
			}else if(year % 400 == 0) {
				System.out.println("Año Bisiesto");
				switch (month) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 9:
					case 11:
						System.out.println("30 días");
						break;
					case 2:
						System.out.println("29 días");
						break;
					case 4:
					case 6:
					case 8:
					case 10:
					case 12:
						System.out.println("31 días");
						break;
				}
			}else {
				System.out.println("Año no Bisiesto");
				switch (month) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 9:
					case 11:
						System.out.println("30 días");
						break;
					case 2:
						System.out.println("28 días");
						break;
					case 4:
					case 6:
					case 8:
					case 10:
					case 12:
						System.out.println("31 días");
						break;
				}
			}
		}
	}

