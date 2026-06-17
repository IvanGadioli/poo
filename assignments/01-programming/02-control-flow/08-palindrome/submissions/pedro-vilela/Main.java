import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text;

        while (true) {
            System.out.print("Digite uma sequência: ");
            text = input.nextLine();

            if (PalindromeChecker.isValidInput(text)) {
                break;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        if (PalindromeChecker.isPalindrome(text)) {
            System.out.println("A sequência \"" + text + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + text + "\" não é um palíndromo.");
        }

        input.close();
    }
}