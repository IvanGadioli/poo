public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }

        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }

        int sum = 0;

        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
        }

        sum += 1;
        return sum;
    }

    public static String generateSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }

        String sequence = "";

        while (n != 1) {
            sequence += n + " → ";
            n = nextCollatz(n);
        }

        sequence += "1";
        return sequence;
    }
}