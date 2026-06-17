import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String s = input.toLowerCase().replace(" ", ""); 
        int inicio = 0;
        int fim = s.length() - 1;

        while (inicio < fim) {
            if (s.charAt(inicio) != s.charAt(fim)) {
                return false;
            }
            inicio++;
            fim--;
        }

        return true;
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            String texto;

            while (true) {
                System.out.print("Digite uma sequência: ");
                texto = input.nextLine();

                if (!isValidInput(texto)) {
                    System.out.println("Erro: A entrada não pode estar vazia.");
                } else {
                    break;
                }
            }

            if (isPalindrome(texto)) {
                System.out.println("A sequência \"" + texto + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + texto + "\" não é um palíndromo.");
            }
        }
    }
}