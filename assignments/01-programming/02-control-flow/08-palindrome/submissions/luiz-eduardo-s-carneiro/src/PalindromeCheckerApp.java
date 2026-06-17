import java.util.Scanner;

public class PalindromeCheckerApp{

    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            PalindromeChecker palindromeChecker = new PalindromeChecker();

            System.out.printf("Digite uma sequência: ");
            String palindrome = scanner.nextLine();
            
            palindromeChecker.setPalindrome(palindrome);
            
            boolean isValidInput = palindromeChecker.isValidInput(palindrome);
            boolean isPalindrome = palindromeChecker.isPalindrome(palindrome);


            if(isValidInput){
                if(isPalindrome){
                    System.out.println("A sequência " + palindromeChecker.getPalindrome() + " é um palíndromo.");
                } else{
                    System.out.println("A sequência " + palindromeChecker.getPalindrome() + " não é um palíndromo.");
                }
            } else{
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }
    }
}