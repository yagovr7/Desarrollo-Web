package HasCode;

public class Money {
	private int amount;
    private String currencyCode;
    
    public Money(int dinero, String code) {
        this.amount = dinero;
        this.currencyCode = code;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    
    @Override
    public boolean equals(Object o) {
        
        if (o == this)
            return true;
        if (!(o instanceof Money))
            return false;
        Money other = (Money)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
          || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        return this.amount == other.amount && currencyCodeEquals;
    }
    
    @Override
    public int hashCode() {
        //Todos los strings tienen este método
        if (currencyCode != null)
            return currencyCode.hashCode() + amount;
        return amount + 3;
    }
    
    public static void main(String[] args) {
		Money m1 = new Money(20, "300");
		Money m2 = new Money(20, "300");
		Money m3 = new Money(20, "400");
		
		System.out.println(m1.equals(m2));
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
	}
}
