import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int n = input.nextInt();

        
        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        } else {
            
            String sequence = CollatzSequence.generateSequence(n);

            
            int sum = CollatzSequence.calculateCollatzSum(n);

            
            System.out.println("Sequência de Collatz: " + sequence);
            System.out.println("Soma dos termos: " + sum);
        }

        input.close();
    }
}