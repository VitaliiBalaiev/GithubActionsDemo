package primenumbers;

import java.math.BigInteger;
import java.util.Random;

public class PrimeChecker {

    private static final Random rand = new Random();

    public boolean isValidNumber(String input) throws IllegalArgumentException {
        long number;

        try {
            number = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input is not a natural number");
        }

        if (number < 2 || number > 1_000_000_000_000L) {
            throw new IllegalArgumentException("Number must be positive and in (2 - 10^12) range");
        }

        return isPrimeNumber(number);
    }

    public boolean isPrimeNumber(long number) {
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeNumber_improved(long number) {
        int s = 0;
        long d = number - 1;

        while (d % 2 == 0) {
            d /= 2;
            s += 1;
        }

        // Perform k rounds of testing, k is a user-defined parameter for accuracy
        // Performing only one round of testing for fastest result
        int k = 1;
        for (int i = 0; i < k; i++) {
            if (!millerRabinTest(d, number)) {
                return false;
            }
        }
        return true;
    }

    private boolean millerRabinTest(long d, long n) {
        BigInteger a = BigInteger.valueOf(2)
                .add(BigInteger.valueOf(rand.nextInt())
                        .mod(BigInteger.valueOf(n - 2)));

        BigInteger x = a.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));

        if (x.equals(BigInteger.ONE) || x.equals(BigInteger.valueOf(n - 1))) {
            return true;
        }

        while (d != n - 1) {
            x = x.modPow(BigInteger.TWO, BigInteger.valueOf(n));
            d *= 2;

            if (x.equals(BigInteger.ONE)) return false;
            if (x.equals(BigInteger.valueOf(n - 1))) return true;
        }

        return false;
    }
}

