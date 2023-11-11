package ejercicios;

import java.math.BigInteger;

public class Ejercicio1 {

	public static Double ejercicio1RecursivoD(Double a) {
		Double ac;
		if (a < 6) {
			ac = 10.;
		} else {
			ac = Math.pow(a, 3) * ejercicio1RecursivoD(a - 1);
		}
		return ac;
	}

	public static BigInteger ejercicio1RecursivoBI(BigInteger a) {
		BigInteger ac;
		BigInteger seis = new BigInteger("6");
		if (a.compareTo(seis) == -1) {
			ac = BigInteger.TEN;
		} else {
			ac = a.pow(3).multiply(ejercicio1RecursivoBI(a.subtract(BigInteger.ONE)));
		}
		return ac;
	}

	public static Double ejercicio1IterativoD(Double a) {
		Double ac;

		if (a < 6) {
			ac = 10.0;
		} else {
			ac = 1.0;
			while (a >= 6) {
				ac *= Math.pow(a, 3);
				a--;
			}
		}
		return ac;
	}
	public static BigInteger ejercicio1IterativoBI(BigInteger a) {
		BigInteger ac;
		BigInteger seis = new BigInteger("6");

		if (a.compareTo(seis) == -1) {
			ac = BigInteger.TEN;
		} else {
			ac = BigInteger.ONE;
			while (a.compareTo(seis) != -1) {
				ac =ac.multiply(a.pow(3));
				a=a.subtract(BigInteger.ONE);
			}
		}
		return ac;
	}
}


