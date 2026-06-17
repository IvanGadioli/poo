
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo:"); 
        int n = scanner.nextInt();

        long Fibonacci = calcularFibonacci(n);

        System.out.print(formatarSaida(n,Fibonacci));

        scanner.close();
    }

    public static long calcularFibonacci(int n){

        if(n == 0) return 0;

        if(n == 1 || n == 2) return 1;

        return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
    }

    public static String formatarSaida(int n, long Fibonacci){
        return String.format("O %dº número de Fibonacci é: %d",Fibonacci,n);
    }
}
