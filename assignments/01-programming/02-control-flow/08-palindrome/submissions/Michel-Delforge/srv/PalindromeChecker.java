public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        if (input == null) return false;
        if (input.trim().isEmpty()) return false;
        return true;
    }

    public static boolean isPalindrome(String input) {
        if (!isValidInput(input)) return false;


        String clean = input.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}