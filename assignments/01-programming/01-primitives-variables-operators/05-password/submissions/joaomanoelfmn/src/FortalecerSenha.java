import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String s = scanner.nextLine();
        scanner.close();

        String senhaFortalecida = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + senhaFortalecida);
    }

    public static String fortalecerSenha(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                char letraDiferente = (s.charAt(i) == 'a') ? 'b' : 'a';

                return s.substring(0, i + 1) + letraDiferente + s.substring(i + 1);
            }
        }

        char letraFinal = (s.charAt(s.length() - 1) == 'a') ? 'b' : 'a';
        return s + letraFinal;
    }

    public static int calcularTempoDigitacao(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int tempo = 2;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }
}