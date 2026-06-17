import java.util.Scanner;

public class Main {

    static class CollatzSequence {

       
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
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int n;

        
        while (true) {
            System.out.print("Digite um número inteiro positivo: ");
            n = teclado.nextInt();

            if (n > 0) {
                break;
            } else {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            }
        }

        
        System.out.print("Sequência de Collatz: ");
        int temp = n;

        while (true) {
            System.out.print(temp);

            if (temp == 1) {
                break;
            }

            System.out.print(" → ");
            temp = CollatzSequence.nextCollatz(temp);
        }

        
        int soma = CollatzSequence.calculateCollatzSum(n);

        System.out.println("\nSoma dos termos: " + soma);

        teclado.close();
    }
}