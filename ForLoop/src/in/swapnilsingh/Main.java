package in.swapnilsingh;

public class Main {

    public static void main(String[] args) {
        System.out.println("10,000 at 2% interest = " + calculateInterest(10000.0, 2.0));
        System.out.println("10,000 at 3% interest = " + calculateInterest(10000.0, 3.0));
        System.out.println("10,000 at 4% interest = " + calculateInterest(10000.0, 4.0));
        System.out.println("10,000 at 5% interest = " + calculateInterest(10000.0, 5.0));

        System.out.println();

        for (int i = 0; i < 5; ++i) {
            System.out.println("Loop " + i + " hello!");
        }

        System.out.println();

        for (int i = 2; i < 9; ++i) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000, i)));
        }

        System.out.println();

        for (int i = 8; i > 1; --i) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000, i)));
        }

        System.out.println();

//        check prime in a range program
        int count = 0;
        for (int i = 1; i <= 100; ++i) {
            if (isPrime(i)){
                count += 1;
                System.out.println(i + " is a prime number.");
            }
            if (count == 3)
                break;
        }
    }

    private static double calculateInterest(double amount, double interestRate) {
        return(amount * (interestRate / 100));
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
