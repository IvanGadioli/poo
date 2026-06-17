import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long resultado = calcularFibonacci(n);
        String saida = formatarSaida(resultado, n);

        System.out.println(saida);

        scanner.close();
    }

    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0;
        long b = 1;
        long proximo = 0;

        for (int i = 2; i <= n; i++) {
            proximo = a + b;
            a = b;
            b = proximo;
        }

        return b;
    }

    public static String formatarSaida(long fibonacci, int n) {
        return String.format("O %dº número de Fibonacci é: %d", n, fibonacci);
    }
}

