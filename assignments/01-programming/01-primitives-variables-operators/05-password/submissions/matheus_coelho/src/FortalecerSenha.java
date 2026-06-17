
import java.util.Random;
import java.util.Scanner;
public class FortalecerSenha {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String s = scanner.nextLine();
        String fortalecida = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + fortalecida);
        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        char randomChar = (char) ('a' + RANDOM.nextInt(26));
        int bestTime = -1;
        String best = s + randomChar;
        for (int pos = 0; pos <= s.length(); pos++) {
            String candidate = s.substring(0, pos) + randomChar + s.substring(pos);
            int t = calcularTempoDigitacao(candidate);
            if (t > bestTime) {
                bestTime = t;
                best = candidate;
            }
        }
        return best;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.length() == 0) {
            return 0;
        }
        int time = 2; // first char
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                time += 1; 
            }else {
                time += 2;
            }
        }
        return time;
    }
}
