public class PalindromeChecker{

    private String palindrome;

    public PalindromeChecker(){
    }

    public PalindromeChecker(String palindrome){
        this.palindrome = palindrome;
    }

    public void setPalindrome(String palindrome){
        this.palindrome = palindrome;
    }

    public String getPalindrome(){
        String minusculo = palindrome.toLowerCase();
        return minusculo;
    }

    public static boolean isValidInput(String input){
        if(input == null || input.length() == 0) return false;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' ') return false;
        }
        return true;
    }

    public static boolean isPalindrome(String input){
        input = input.replace(" ", "");
        String inputMinusculo = input.toLowerCase();
        char[] array1 = inputMinusculo.toCharArray();
        int inicio = 0;
        int fim = input.length() - 1;

        while(inicio < fim){
            if(array1[inicio] != array1[fim]) return false;

            inicio++;
            fim--;
        }
        return true;
    }
}