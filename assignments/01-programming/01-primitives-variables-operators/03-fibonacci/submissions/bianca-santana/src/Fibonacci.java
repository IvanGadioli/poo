import java.util.Scanner;

public class Fibonacci {

public static void main (String[] arg){

    Scanner ler = new Scanner(System.in);

    System.out.println("Digite um número inteiro não negativo: ");
    int num = ler.nextInt();

   if (num >= 0) {
            long resultado = calcularFibonacci(num);
            String saida = formatarSaida(resultado, num);
            System.out.println(saida);
        } else {
            System.out.println("Opção inválida! O número deve ser não negativo.");
        }

}

public static long calcularFibonacci(int n){
   if (n <= 1) return n;
   long antp = 0;
   long p = 1;
    for(int i = 2; i <= n; i++){
        long prox = antp + p; 
        antp = p;
        p = prox;
    }

    return p;
}

public static String formatarSaida(long nf, int ns){
    return String.format("O %dº número de Fibonacci é: %d", ns, nf);

}
}
