import java.util.Scanner;

public class MedianCalculator {

    /**
     * Calcula a mediana de três números utilizando estruturas condicionais,
     * sem ordenação prévia e lidando com duplicatas.
     */
    public static int findMedian(int a, int b, int c) {
        // Verifica se 'a' é o valor do meio (entre 'b' e 'c', ou vice-versa)
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            return a;
        } 
        // Verifica se 'b' é o valor do meio (entre 'a' e 'c', ou vice-versa)
        else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            return b;
        } 
        // Se nem 'a' nem 'b' são a mediana, obrigatoriamente será 'c'
        else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita os três números ao usuário
        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        // Calcula a mediana chamando o método estático
        int mediana = findMedian(num1, num2, num3);

        // Exibe o resultado final
        System.out.println("A mediana dos números é: " + mediana);

        // Boa prática: fechar o scanner para evitar vazamento de recursos
        scanner.close();
    }
}
