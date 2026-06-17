import java.util.Scanner;

public class CollatzSequence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        
        if (!input.hasNextInt()) {
            System.out.println("Erro: Você deve digitar um número inteiro.");
        } else {
            int semente = input.nextInt();

    
            if (semente < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {

                System.out.print("Sequência de Collatz: ");
                long somaTotal = calculateCollatzSum(semente);
                System.out.printf("%nSoma dos termos: %d%n", somaTotal);
            }
        }

        input.close();
    }

  
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }


    public static long calculateCollatzSum(int n) {
        long soma = 0;
        int atual = n;

    
        while (atual != 1) {
            System.out.print(atual + " → ");
            soma += atual;
            atual = nextCollatz(atual);
        }

        System.out.print(atual);
        soma += atual;

        return soma;
    }
}