import java.util.Scanner;

public class FortalecerSenha {

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

    public static String fortalecerSenha(String s) {

        String melhorSenha = "";
        int maiorTempo = -1;

        for (int i = 0; i <= s.length(); i++) {

            for (char c = 'a'; c <= 'z'; c++) {

                String novaSenha = s.substring(0, i) + c + s.substring(i);

                int tempo = calcularTempoDigitacao(novaSenha);

                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = novaSenha;
                }
            }
        }

        return melhorSenha;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = teclado.nextLine();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("Senha inválida! O tamanho deve ser entre 1 e 10.");
            return;
        }

        String novaSenha = fortalecerSenha(senha);

        System.out.println("Senha fortalecida: " + novaSenha);

        teclado.close();
    }
}