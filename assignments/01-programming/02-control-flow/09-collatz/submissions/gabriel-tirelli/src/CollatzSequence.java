import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        // Entrada do usuário com validação
        do {
            System.out.print("Digite um número inteiro positivo: ");
            numero = scanner.nextInt();
            if (numero < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            }
        } while (numero < 1);

        // Apresenta os resultados para o usuário
        int atual = numero;
        System.out.print("Sequência de Collatz: ");
        while (atual != 1) {
            System.out.print(atual + " → ");
            atual = nextCollatz(atual);
        }
        
        System.out.println("1");
        int soma = calculateCollatzSum(numero);
        System.out.println("Soma dos termos: " + soma);

        scanner.close();
    }

    // Retorna o próximo número da sequência
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2; // par
        } else {
            return (n * 3) + 1; // ímpar
        }
    }

    // Calcula a soma da sequência
    public static int calculateCollatzSum(int n) {
        int soma = 0;
        while (n != 1) {
            soma += n;
            n = nextCollatz(n);
        }
        soma += 1;
        return soma;
    }

}