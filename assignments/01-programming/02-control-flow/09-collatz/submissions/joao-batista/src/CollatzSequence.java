import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        return 3 * n + 1;
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;
        int current = n;
        while (true) {
            sum += current;
            if (current == 1) break;
            current = nextCollatz(current);
        }
        return sum;
    }

    public static List<Integer> generateSequence(int n) {
        List<Integer> seq = new ArrayList<>();
        int current = n;
        while (true) {
            seq.add(current);
            if (current == 1) break;
            current = nextCollatz(current);
        }
        return seq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            scanner.close();
            return;
        }

        List<Integer> sequence = generateSequence(n);
        System.out.print("Sequência de Collatz: ");
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i));
            if (i < sequence.size() -1) {
                System.out.print(" → ");
            }
        }
        System.out.println();
        System.out.println("Soma dos termos: " + calculateCollatzSum(n));
        scanner.close();
    }
}