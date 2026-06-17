import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String s = scanner.nextLine().trim();

        if (s.length() < 1 || s.length() > 10 || !s.matches("[a-z]+")) {
            System.out.println("Senha inválida. Deve ter 1-10 letras minúsculas.");
            scanner.close();
            return;
        }

        String fortalecida = fortalecerSenha(s);
        System.out.println("Senha fortalecida: " + fortalecida);

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhor = "";
        int maxTempo = -1;

        for (int pos = 0; pos <= s.length(); pos++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(pos, c);
                String nova = sb.toString();
                int tempo = calcularTempoDigitacao(nova);
                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhor = nova;
                }
            }
        }
        return melhor;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.length() == 0) return 0;
        int tempo = 2; // primeiro char
        for (int i = 1; i < senha.length(); i++) {
            tempo += (senha.charAt(i) == senha.charAt(i - 1)) ? 1 : 2;
        }
        return tempo;
    }
}