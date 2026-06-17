// Atividade variáveis e operadores primitivos. Tarefa: Calcular o n-ésimo número da sequencia de fibonacci
/*
F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2) para n > 1

*/
import java.util.Scanner;
import java.util.Locale;



public class Fibonacci {

    public static long calcularFibonacci(int n){

        long num = 0;
        if (n == 0){
            num = 0;
        } else if (n == 1) {
            num = 1;
        } else if (n > 1){

            long ant = 0;
            long atual = 1;

            for (int i = 2; i <= n; i++){

                num = ant + atual;

                ant = atual;
                atual = num;
            }

        }

        return num;
    }

    public static String formatarSaida(int n,long num){

        return String.format("O %d º número de Fibonacci é %d", n, num);
    }

    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = leitor.nextInt();

        long num = calcularFibonacci(n); 
        System.out.println(formatarSaida(n, num));

    }
}