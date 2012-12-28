package org.gabr.math;

import java.math.BigInteger;

public class Silnia {
	
	public static BigInteger silnia(int n){
		BigInteger bn = BigInteger.valueOf(1);
		for(int i = 1; i<=n; i++){
			bn = bn.multiply(BigInteger.valueOf(i));
		}
		return bn;
	}

}
