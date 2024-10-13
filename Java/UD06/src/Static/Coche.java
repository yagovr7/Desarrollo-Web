package Static;

class Coche{
	 private int pasajeros; //número de pasajeros
	 private int deposito; //capacidad del depositos en litros
	 private int kpl; //kilometros que se pueden recorrer con un litro,

	 public void autonomia(){
	 System.out.println("Autonomía:" + deposito*kpl);
	 }
	public int getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}
	public int getDeposito() {
		return deposito;
	}
	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}
	public int getKpl() {
		return kpl;
	}
	public void setKpl(int kpl) {
		this.kpl = kpl;
	}
	 
	 
	}
	
