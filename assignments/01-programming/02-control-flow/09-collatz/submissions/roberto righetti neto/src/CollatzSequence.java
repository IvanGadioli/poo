import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static long calculateCollatzSum(int n) {
        long sum = 0;
        StringBuilder sequence = new StringBuilder();

        if (n <= 0) {
            return -1; // Indicate error for invalid input
        }

        int currentNum = n;
        while (currentNum != 1) {
            sequence.append(currentNum).append(" → ");
            sum += currentNum;
            currentNum = nextCollatz(currentNum);
        }
        sequence.append(1);
        sum += 1;

        System.out.println("Sequência de Collatz: " + sequence.toString());
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true) {
            System.out.print("Digite um número inteiro positivo: ");
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {
                break;
            }
        }

        long sum = calculateCollatzSum(n);
        System.out.println("Soma dos termos: " + sum);

        scanner.close();
    }
}
