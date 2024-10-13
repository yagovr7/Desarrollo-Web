package HasCode;
import java.util.Objects;

public class PhoneNumber {
	int areaCode;
	int prefix;
	int lineNumber;
	
	public  int hashCode() {
        return Objects.hash(areaCode, prefix, lineNumber);
    }
	
	PhoneNumber(int area, int prefix, int line){
		this.areaCode = area;
		this.prefix = prefix;
		this.lineNumber = line;
	}
	
	public static void main(String[] args) {
		PhoneNumber n1 = new PhoneNumber(2,1,1);
		
		System.out.println(n1.hashCode());
		
	}
    
}
