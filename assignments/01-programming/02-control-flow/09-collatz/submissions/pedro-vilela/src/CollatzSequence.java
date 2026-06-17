public class CollatzSequence {

    
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = n;

        while (n != 1) {
            n = nextCollatz(n);
            sum += n;
        }

        return sum;
    }

    
    public static String generateSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        sequence.append(n);

        while (n != 1) {
            n = nextCollatz(n);
            sequence.append(" → ").append(n);
        }

        return sequence.toString();
    }
}
