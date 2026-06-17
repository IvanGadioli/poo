import java.util.Scanner;

public class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;

        while (true) {
            sum += n;

            if (n == 1) {
                break;
            }

            n = nextCollatz(n);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Digite um número inteiro positivo: ");
        n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }

        int original = n;
        int sum = 0;

        System.out.print("Sequência de Collatz: ");

        while (true) {
            System.out.print(n);
            sum += n;

            if (n == 1) {
                break;
            }

            System.out.print(" → ");
            n = nextCollatz(n);
        }

        System.out.println();
        System.out.println("Soma dos termos: " + sum);

        scanner.close();
    }
}