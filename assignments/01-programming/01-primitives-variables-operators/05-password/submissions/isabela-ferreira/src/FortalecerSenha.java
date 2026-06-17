import java.util.Scanner;

public class FortalecerSenha {

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

    
    public static String fortalecerSenha(String s) {
        if (s == null || s.isEmpty()) {
            
            return "a";
        }

        String melhorSenha = null;
        int melhorTempo = -1;

        
        for (int pos = 0; pos <= s.length(); pos++) {
            
            
            for (char c = 'a'; c <= 'z'; c++) {
                
              
                StringBuilder nova = new StringBuilder(s);
                nova.insert(pos, c);
                String candidato = nova.toString();
                
               
                int tempo = calcularTempoDigitacao(candidato);
                
                
                if (tempo > melhorTempo) {
                    melhorTempo = tempo;
                    melhorSenha = candidato;
                }
            }
        }

        return melhorSenha;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine().trim();
        
        
        if (senhaOriginal.length() < 1 || senhaOriginal.length() > 10) {
            System.out.println("Erro: a senha deve ter entre 1 e 10 caracteres.");
            return;
        }
        
        
        if (!senhaOriginal.matches("[a-z]+")) {
            System.out.println("Erro: a senha deve conter apenas letras minúsculas (a-z).");
            return;
        }
        
        String senhaFortalecida = fortalecerSenha(senhaOriginal);
        
        System.out.println("Senha fortalecida: " + senhaFortalecida);
        
        
        int tempo = calcularTempoDigitacao(senhaFortalecida);
        System.out.println("(tempo de digitação: " + tempo + " segundos)");
        
        scanner.close();
    }
}