import java.util.Scanner;

public class CollatzSequenceApp{

    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            CollatzSequence collatzSequence = new CollatzSequence();

            System.out.print("Digite um número inteiro positivo: ");
            int n = scanner.nextInt();

            if(n <= 0){ 
                System.out.printf("Erro: O número deve ser um inteiro positivo.\n");
                return;
            }

            collatzSequence.setN(n);
            int atual = collatzSequence.getN();

            System.out.print("Sequência de Collatz: ");
            int soma = CollatzSequence.calculateCollatzSum(atual);
            System.out.println("\nSoma dos termos: " + soma);
        }
    }
}