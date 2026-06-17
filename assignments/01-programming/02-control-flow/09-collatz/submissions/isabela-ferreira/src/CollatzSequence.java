import java.util.Scanner;

public class CollatzSequence {

    /**
     * Recebe um inteiro positivo e retorna o próximo número da sequência de Collatz.
     */
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    /**
     * Gera a sequência de Collatz a partir de 'n' e retorna a soma de todos os termos.
     */
    public static int calculateCollatzSum(int n) {
        int sum = 0;
        
        while (n != 1) {
            sum += n; // Adiciona o termo atual à soma
            n = nextCollatz(n); // Avança para o próximo termo
        }
        
        sum += 1; // Adiciona o último termo (1), que interrompe o loop
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número inteiro positivo: ");
        
        // Verifica se a entrada é de fato um número inteiro
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            // Validação de entrada inválida (menor que 1)
            if (n < 1) {
                System.out.println("Erro: O número deve ser um inteiro positivo.");
            } else {
                // 1. Exibir a sequência gerada
                System.out.print("Sequência de Collatz: ");
                int current = n;
                
                // Loop while para imprimir os números até chegar a 1
                while (current != 1) {
                    System.out.print(current + " → ");
                    current = nextCollatz(current);
                }
                System.out.println("1"); // Imprime o último elemento
                
                // 2. Calcular e exibir a soma total
                int sum = calculateCollatzSum(n);
                System.out.println("Soma dos termos: " + sum);
            }
        } else {
            // Caso o usuário digite texto, letras ou símbolos
            System.out.println("Erro: O número deve ser um inteiro positivo.");
        }
        
        scanner.close();
    }
}