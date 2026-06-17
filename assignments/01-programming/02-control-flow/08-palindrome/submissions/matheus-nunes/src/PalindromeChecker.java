import java.util.Scanner;

public class Main {

    static class PalindromeChecker {

        
        public static boolean isValidInput(String input) {
            return input != null && !input.trim().isEmpty();
        }

        
        public static boolean isPalindrome(String input) {
            input = input.toLowerCase();

            int inicio = 0;
            int fim = input.length() - 1;

            while (inicio < fim) {
                if (input.charAt(inicio) != input.charAt(fim)) {
                    return false;
                }
                inicio++;
                fim--;
            }
            return true;
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String input;

        
        while (true) {
            System.out.print("Digite uma sequência: ");
            input = teclado.nextLine();

            if (PalindromeChecker.isValidInput(input)) {
                break;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        
        if (PalindromeChecker.isPalindrome(input)) {
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }

        teclado.close();
    }
}