import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean valid = false;

        // Loop para garantir que a entrada seja válida (Requisito 5)
        while (!valid) {
            System.out.print("Digite uma sequência: ");
            userInput = input.nextLine();

            if (isValidInput(userInput)) {
                valid = true;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        
        if (isPalindrome(userInput)) {
            System.out.printf("A sequência \"%s\" é um palíndromo.%n", userInput);
        } else {
            System.out.printf("A sequência \"%s\" não é um palíndromo.%n", userInput);
        }

        input.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        
        String cleanInput = input.toLowerCase();
        
        int length = cleanInput.length();
        
        for (int i = 0; i < length / 2; i++) {
           
            char charInicio = cleanInput.charAt(i);
            char charFim = cleanInput.charAt(length - 1 - i);
            
            if (charInicio != charFim) {
                return false; 
            }
        }
        
        return true; 
    }
}