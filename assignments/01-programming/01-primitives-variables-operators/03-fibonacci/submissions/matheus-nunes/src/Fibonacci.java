import java.util.Scanner;

public class Fibonacci {

    public static long calcularFibonacci(int n){

        long anterior = 0;
        long atual = 1;
        long proximo;

        if(n == 0){
            return 0;
        }

        for(int i = 2; i <= n; i++){
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;

    }

    public static String formatarSaida(long fibonacci, int n){
        return "O " + n + "º número de Fibonacci é: " + fibonacci;
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int n;
        long resultado;

        System.out.print("Digite um número inteiro não negativo: ");
        n = teclado.nextInt();

        resultado = calcularFibonacci(n);

        String saida = formatarSaida(resultado, n);

        System.out.println(saida);

        teclado.close();

    }
}