package primenumbers;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        PrimeChecker checker = new PrimeChecker();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter natural number to check if its prime: ");
        String inputString = in.nextLine();

        try {
            System.out.println(checker.isValidNumber(inputString));
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}