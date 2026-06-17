import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        String senhaFortalecida = fortalecerSenha(senha);
        System.out.println("Senha fortalecida: " + senhaFortalecida);

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        if (s == null || s.length() < 1 || s.length() > 10) {
            throw new IllegalArgumentException("A senha deve ter entre 1 e 10 caracteres.");
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') {
                throw new IllegalArgumentException("A senha deve conter apenas letras minúsculas de a a z.");
            }
        }

        String melhorSenha = "";
        int maiorTempo = -1;

        for (int pos = 0; pos <= s.length(); pos++) {
            for (char letra = 'a'; letra <= 'z'; letra++) {
                String candidata = s.substring(0, pos) + letra + s.substring(pos);
                int tempo = calcularTempoDigitacao(candidata);

                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = candidata;
                }
            }
        }

        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }

        int tempo = 2;

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }

        return tempo;
    }
}