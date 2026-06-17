import java.util.Scanner;

public class PalindromeChecker{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;

        // Entrada de dados do usuário até ser válida
        do {
            System.out.print("Digite uma sequência: ");
            text = scanner.nextLine();
            if (!isValidInput(text)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        } while (!isValidInput(text));

        // Utiliza os métodos
        if (isPalindrome(text)) {
            System.out.println("A sequência \"" + text + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + text + "\" não é um palíndromo.");
        }

        scanner.close();
    }

        // Verifica se a entrada é válida
    public static boolean isValidInput(String text) {
        if (text == null) return false;
        text = text.trim();
        return !text.isEmpty();
    }

    // Verifica se é palíndromo
    public static boolean isPalindrome(String text) {
        text = text.toLowerCase();
        text = text.replace(" ", "");
        int inicio = 0;
        int fim = text.length() - 1;

        // Analisa os dois lados do palindromo
        while (inicio < fim) {
            if (text.charAt(inicio) != text.charAt(fim)) {
                return false;
            }
            inicio++;
            fim--;
        }
        return true;
    }
}