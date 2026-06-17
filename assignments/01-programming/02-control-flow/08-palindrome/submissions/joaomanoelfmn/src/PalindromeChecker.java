import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {

        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String cleanInput = input.replace(" ", "").toLowerCase();
        
        int leftIndex = 0;
        int rightIndex = cleanInput.length() - 1;

        while (leftIndex < rightIndex) {
            if (cleanInput.charAt(leftIndex) != cleanInput.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (isValidInput(input)) {
                break;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        String displayInput = input.trim();

        if (isPalindrome(displayInput)) {
            System.out.println("A sequência \"" + displayInput + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + displayInput + "\" não é um palíndromo.");
        }

        scanner.close();
    }
}