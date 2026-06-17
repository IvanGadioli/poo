import java.util.Scanner;

public class FortalecerSenha {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite a senha:");
        String senha = ler.nextLine();

        if (senha.length() >= 1 && senha.length() <= 10) {
            String senhaFortalecida = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + senhaFortalecida);
        } else {
            System.out.println("A senha deve conter entre 1 e 10 caracteres.");
        }
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maiorTempo = -1;
        
        for (int i = 0; i < s.length(); i++) {
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
        if (senha.isEmpty()) return 0;

        int tempoTotal = 2; // Tempo para digitar o primeiro caractere

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempoTotal += 1; // Tempo para digitar um caractere igual ao anterior
            } else {
                tempoTotal += 2; // Tempo para digitar um caractere diferente do anterior
            }
        }

        return tempoTotal;
    }
}
