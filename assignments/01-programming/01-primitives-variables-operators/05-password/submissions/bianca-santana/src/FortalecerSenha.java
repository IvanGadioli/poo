import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        System.out.print("Digite a senha: ");
        String senhaOriginal = ler.next();
     
        String senha = fortalecerSenha(senhaOriginal);
        
        System.out.println("Senha fortalecida: " + senha);
     
    }

    public static String fortalecerSenha(String s) {
        int n = s.length();
  
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
          
                char letraInserir = (s.charAt(i) == 'a') ? 'b' : 'a';
                
                return s.substring(0, i + 1) + letraInserir + s.substring(i + 1);
            }
        }
        
        char letraInicio = (s.charAt(0) == 'a') ? 'b' : 'a';
        return letraInicio + s;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) return 0;

        int tempoTotal = 2; 
        
        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempoTotal += 1;
            } else {
                tempoTotal += 2;
            }
        }
        
        return tempoTotal;
    }
}