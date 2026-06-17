import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("Erro: a senha deve ter entre 1 e 10 caracteres.");
            return;
        }

        String novaSenha = fortalecerSenha(senha);
        System.out.println("Senha fortalecida: " + novaSenha);

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maiorTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String candidata = s.substring(0, i) + c + s.substring(i);
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
        int tempo = 2; // primeiro caractere

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
