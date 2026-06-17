import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();
        long result = calcularFibonacci(n);
        System.out.println(formatarSaida(result, n));
        scanner.close();
    }

    public static long calcularFibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("O número deve ser não negativo.");
        if (n == 0) return 0L;
        if (n == 1) return 1L;
        long a = 0L, b = 1L;
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static String formatarSaida(long valor, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, valor);
    }
}
