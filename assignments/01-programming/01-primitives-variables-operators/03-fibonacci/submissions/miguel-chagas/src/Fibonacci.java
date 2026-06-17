import java.util.Scanner;

public class Fibonacci{

    static long atual = 1;
    static long n1 = 1;
    static long n2 = 0;
    static long aux = 0;

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scan.nextInt();

        if(n < 0){
            System.out.println("Número inválido (Não inteiro)");
            System.exit(1);
        } else {
            System.out.printf("\n%s",formatarSaida(calcularFibonacci(n),n));
        }

        scan.close();

    }

    public static long calcularFibonacci(long n){

        if(n == 0) return 0;
        else if(n == 1 || n == 2) return 1;

        return calcularFibonacci(n - 2) + calcularFibonacci(n - 1);
    }

    public static String formatarSaida(long fibonacci, int n){
        return String.format("O %dº número de Fibonacci é: %d", n, fibonacci);
    }
}