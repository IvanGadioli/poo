import java.util.Scanner;

public class Fibonacci {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();
        scanner.close();

        long resultadoFibonacci = calcularFibonacci(n);
        
        String mensagem = formatarSaida(resultadoFibonacci, n);
        
        System.out.println(mensagem);
    }

    public static long calcularFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long ant = 0; 
        long atual = 1;    
        long prox = 0;  

        for (int i = 2; i <= n; i++) {
            prox = ant + atual; 
            ant = atual;           
            atual = prox;            
        }
        return atual; 
    }
    
    public static String formatarSaida(long resultado, int n) {
        return "O " + n + "º número de Fibonacci é: " + resultado;
    }
}