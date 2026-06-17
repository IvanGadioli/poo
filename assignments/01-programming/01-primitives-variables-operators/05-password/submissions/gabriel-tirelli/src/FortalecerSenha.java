import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (senha.length() < 1 || senha.length() > 10) {
            System.out.println("A senha deve ter entre 1 e 10 caracteres.");
        } else {
            String novaSenha = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + novaSenha);
        }

        scanner.close();
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maiorTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String tentativa = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(tentativa);
                if (tempo > maiorTempo) {
                    maiorTempo = tempo;
                    melhorSenha = tentativa;
                }
            }
        }

        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        int tempo = 0;
        if (senha.length() > 0) {
            tempo = 2;
        }

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo = tempo + 1;
            } else {
                tempo = tempo + 2;
            }
        }
        
        return tempo;
    }
}