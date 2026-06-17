import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = input.next();

        String senhaFortalecida = fortalecerSenha(senhaOriginal);

        
        System.out.println("Senha fortalecida: " + senhaFortalecida);

        input.close();
    }

    
    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;

        for (int i = 0; i <= s.length(); i++) {

            for (char c = 'a'; c <= 'z'; c++) {
                String candidata = s.substring(0, i) + c + s.substring(i);
                int tempo = calcularTempoDigitacao(candidata);

                if (tempo > maxTempo) {
                    maxTempo = tempo;
                    melhorSenha = candidata;
                }
                
                
            }
        }
        return melhorSenha;
    }

   
    public static int calcularTempoDigitacao(String s) {
        if (s.isEmpty()) return 0;
        
        int tempo = 2; 
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tempo += 1;
            } else {
                tempo += 2;
            }
        }
        return tempo;
    }
}