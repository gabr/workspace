import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNum {

	public static void main(String[] args) {
		int i = (int) 1e9;
		long l = (long) 1e18;
		l = 1000000000000000000L;
		double d = 1e308;

		BigInteger bi1, bi2;
		BigDecimal bd;
		
		bi1 = new BigInteger("1000000000000000000");
		bi2 = new BigInteger("1000000000000000000");
		
		bi1.valueOf(l);

		System.out.println(bi1.multiply(bi2));
	}

}
