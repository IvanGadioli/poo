public class PalindromeChecker {

    // Verifica se a entrada é válida
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Verifica se é palíndromo
    public static boolean isPalindrome(String input) {
        String processed = input.toLowerCase().trim();

        int start = 0;
        int end = processed.length() - 1;

        while (start < end) {
            if (processed.charAt(start) != processed.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}