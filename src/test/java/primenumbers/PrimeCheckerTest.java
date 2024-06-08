package primenumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class PrimeCheckerTest {

    private PrimeChecker checker;

    @BeforeEach
    void setUp() {
        checker = new PrimeChecker();
    }

    @Test
    void isPrimeNumber_prime() {
        boolean prime = checker.isPrimeNumber(67);
        Assertions.assertTrue(prime);

    }

    @Test
    void isPrimeNumber_not_prime() {
        boolean notPrime = checker.isPrimeNumber(89);
        Assertions.assertTrue(notPrime);
    }

    @Test
    void isPrimeNumber_with_two() {
        boolean prime = checker.isPrimeNumber(2);
        Assertions.assertTrue(prime);
    }

    @Test
    void isPrimeNumber_with_2_147_483_647() {
        boolean prime = checker.isPrimeNumber(2147483647);
        Assertions.assertTrue(prime);
    }
    @Test
    void isPrimeNumber_with_999999000001L() {
        boolean prime = checker.isPrimeNumber(999999000001L);
        Assertions.assertTrue(prime);
    }

    @Test
    void isPrimeNumber_with_1000000000000() {
        boolean prime = checker.isPrimeNumber(1_000_000_000_000_000L);
        Assertions.assertFalse(prime);
    }

    @Test
    void isValidNumber_with_one() {
        boolean prime = checker.isPrimeNumber(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.isValidNumber("1"));
    }

    @Test
    void isValidNumber_with_valid_prime() {
        boolean prime = checker.isValidNumber("5");
        Assertions.assertTrue(prime);
    }

    @Test
    void isValidNumber_with_valid_non_prime() {
        boolean prime = checker.isValidNumber("4");
        Assertions.assertFalse(prime);
    }

    @Test
    void isValidNumber_with_negative_number() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.isValidNumber("-1"));
    }

    @Test
    void isValidNumber_with_non_numeric() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.isValidNumber("QWERTYabc"));
    }

    @Test
    void isValidNumber_with_out_of_range_number() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> checker.isValidNumber("1000000000001"));
    }

    @Test
    void isPrimeNumber_with_67280421310721L() {
        boolean prime = checker.isPrimeNumber(67280421310721L);
        Assertions.assertTrue(prime);
    }

    @Test
    void isPrimeNumber_improved_with_67280421310721L() {
        boolean prime = checker.isPrimeNumber_improved(67280421310721L);
        Assertions.assertTrue(prime);
    }

    @Test
    public void isPrimeNumber_with_67280421310721L_timed() {
        long[] executionTimes = new long[10];

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            boolean prime = checker.isPrimeNumber(67280421310721L);
            executionTimes[i] = System.nanoTime() - startTime;
            Assertions.assertTrue(prime);
        }

        Arrays.sort(executionTimes);
        System.out.println("\nisPrimeNumber() Execution Times (nanoseconds):");
        System.out.println("Min: " + executionTimes[0] + " (" + executionTimes[0] / 1000000 + "ms)");
        System.out.println("Max: " + executionTimes[9] + " (" + executionTimes[9] / 1000000 + "ms)");
        System.out.println("Median: " + executionTimes[5] + " (" + executionTimes[5] / 1000000 + "ms)");
    }

    @Test
    public void isPrimeNumber_improved_with_67280421310721L_timed() {
        long[] executionTimes = new long[10];

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            boolean prime = checker.isPrimeNumber_improved(67280421310721L);
            executionTimes[i] = System.nanoTime() - startTime;
            Assertions.assertTrue(prime);
        }

        Arrays.sort(executionTimes);
        System.out.println("\nisPrimeNumber_improved() Execution Times (nanoseconds):");
        System.out.println("Min: " + executionTimes[0] + " (" + executionTimes[0] / 1000000 + "ms)");
        System.out.println("Max: " + executionTimes[9] + " (" + executionTimes[9] / 1000000 + "ms)");
        System.out.println("Median: " + executionTimes[5] + " (" + executionTimes[5] / 1000000 + "ms)");
    }
}