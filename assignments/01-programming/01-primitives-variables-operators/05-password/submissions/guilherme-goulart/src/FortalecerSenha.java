public class FortalecerSenha {
    public static String fortalecerSenha(String s){
        StringBuilder senhaFortalecida = new StringBuilder();
        boolean inserido = false;

        if (s == null || s.isEmpty()) return "a";

        senhaFortalecida.append(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            if(!inserido && s.charAt(i) == s.charAt(i - 1)){
                char charParaInserir =(s.charAt(i) == 'a') ? 'b' : 'a';
                senhaFortalecida.append(charParaInserir);
                inserido = true;
            } 
            senhaFortalecida.append(s.charAt(i));
        }

        if(!inserido){
            char ultimoChar = s.charAt(s.length() - 1);
            char charParaInserir =(ultimoChar == 'a') ? 'b' : 'a';
            senhaFortalecida.append(charParaInserir);
        }
        return senhaFortalecida.toString();
    }
    
    public static int calcularTempoDigitacao(String s){

        if (s == null || s.isEmpty()) return 0;
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

    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        String novaSenha = fortalecerSenha(senhaOriginal);

        System.out.println("Senha fortalecida: " + novaSenha);
        System.out.println("Tempo de digitação: " + calcularTempoDigitacao(novaSenha) + " segundos");
        
        scanner.close();
    }
}
