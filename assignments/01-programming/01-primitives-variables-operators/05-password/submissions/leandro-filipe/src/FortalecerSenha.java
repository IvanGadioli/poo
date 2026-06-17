import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String senha = "";

            // Requisito 5: Garantir que o tamanho da senha esteja entre 1 e 10
            while (true) {
                System.out.print("Digite a senha: ");
                senha = scanner.nextLine();

                if (senha.length() >= 1 && senha.length() <= 10) {
                    break;
                } else {
                    System.out.println("Tamanho inválido. A senha deve ter entre 1 e 10 caracteres.");
                }
            }

            // Chama o método para encontrar a melhor senha e imprime
            String novaSenha = fortalecerSenha(senha);
            System.out.println("Senha fortalecida: " + novaSenha);
        }
    }

    // Requisito 3: Método que testa as combinações e retorna a senha fortalecida
    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;

        // Loop para testar inserção em todas as posições possíveis (do início até o final da string)
        for (int i = 0; i <= s.length(); i++) {
            
            // Loop para testar todas as letras minúsculas do alfabeto ('a' até 'z')
            for (char c = 'a'; c <= 'z'; c++) {
                
                // Constrói a nova senha inserindo o caractere 'c' na posição 'i'
                String senhaTestada = s.substring(0, i) + c + s.substring(i);
                
                // Calcula o tempo dessa nova combinação
                int tempoAtual = calcularTempoDigitacao(senhaTestada);
                
                // Se for o maior tempo encontrado até agora, salva essa senha
                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = senhaTestada;
                }
            }
        }

        return melhorSenha;
    }

    // Requisito 4: Método para calcular o tempo de digitação da senha
    public static int calcularTempoDigitacao(String senha) {
        if (senha == null || senha.isEmpty()) {
            return 0;
        }

        // O primeiro caractere leva 2 segundos
        int tempo = 2;

        // Avalia do segundo caractere em diante
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempo += 1; // 1 segundo se for igual ao anterior
            } else {
                tempo += 2; // 2 segundos se for diferente do anterior
            }
        }

        return tempo;
    }
}