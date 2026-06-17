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
        int soma = 0;

        while (true) {
            soma += n;

            if (n == 1) {
                break;
            }

            n = nextCollatz(n);
        }

        return soma;
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Digite um número inteiro positivo: ");
            int n = input.nextInt();

            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
                return;
            }

            System.out.print("Sequência de Collatz: ");
            int atual = n;

            while (true) {
                System.out.print(atual);

                if (atual == 1) {
                    break;
                }

                System.out.print(" → ");
                atual = nextCollatz(atual);
            }

            System.out.println();

            int soma = calculateCollatzSum(n);
            System.out.println("Soma dos termos: " + soma);
        }
    }
}