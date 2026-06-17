import java.util.Scanner;

public class FortalecerSenha { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (c < 'a' || c > 'z') {
                System.out.println("Erro: A senha deve conter apenas letras minúsculas (a-z)");
                scanner.close();
                return;
            }
        }
        
        String senhaFortalecida = fortalecerSenha(senha);
        System.out.println("Senha fortalecida: " + senhaFortalecida);
        
        scanner.close();
    }
    
    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int melhorTempo = -1;
        
        for (int posicao = 0; posicao <= s.length(); posicao++) {
            for (char letra = 'a'; letra <= 'z'; letra++) {

                String novaSenha = s.substring(0, posicao) + letra + s.substring(posicao);
                
                int tempo = calcularTempoDigitacao(novaSenha);

                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
                    melhorSenha = novaSenha;
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
            char atual = senha.charAt(i);
            char anterior = senha.charAt(i - 1);
            
            if (atual == anterior) {
                tempo += 1;
            } else {
                tempo += 2; 
            }
        }
        
        return tempo;
    }
}