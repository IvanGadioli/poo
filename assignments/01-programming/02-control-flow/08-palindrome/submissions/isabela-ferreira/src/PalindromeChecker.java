import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        return input != null && input.trim().length() > 0;
    }

    public static boolean isPalindrome(String input) {
        // Remove todos os espaços e converte para minúsculas
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = cleanInput.length() - 1;

        while (left < right) {
            if (cleanInput.charAt(left) != cleanInput.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        
        return true; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.print("Digite uma sequência: ");
            
            if (!scanner.hasNextLine()) {
                break;
            }
            
            input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                input = input.trim();
                break;
            }
        }

        if (isValidInput(input)) {
            if (isPalindrome(input)) {
                System.out.println("A sequência \"" + input + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
            }
        }

        scanner.close();
    }
}