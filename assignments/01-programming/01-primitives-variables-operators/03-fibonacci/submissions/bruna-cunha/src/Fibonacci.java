import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = input.nextInt();

        
        long resultado = calcularFibonacci(n);
        String saida = formatarSaida(n, resultado);

        
        System.out.println(saida);

        input.close();
    }

    
    public static long calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
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

    
    public static String formatarSaida(int n, long resultado) {
        return "O " + n + "º número de Fibonacci é: " + resultado;
    }
}