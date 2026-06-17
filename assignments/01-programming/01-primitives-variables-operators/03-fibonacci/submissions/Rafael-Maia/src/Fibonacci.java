import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero inteiro nao negativo: ");
        int n = scanner.nextInt();

        long fibonacci = calcularFibonacci(n);
        System.out.println(formatarSaida(fibonacci, n));

        scanner.close();
    }

    public static long calcularFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long anterior = 0;
        long atual = 1;

        for (int i = 2; i <= n; i++) {
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;
    }

    public static String formatarSaida(long fibonacci, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, fibonacci);
    }
}