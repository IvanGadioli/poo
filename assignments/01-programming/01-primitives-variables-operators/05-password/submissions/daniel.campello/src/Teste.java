public class Teste {
    public static void main(String[] args) {
        String input = "aa";
        String fortalecida = FortalecerSenha.fortalecerSenha(input);
        System.out.println("Input: " + input);
        System.out.println("Fortalecida: " + fortalecida);
        int tempoOriginal = FortalecerSenha.calcularTempoDigitacao(input);
        int tempoFortalecido = FortalecerSenha.calcularTempoDigitacao(fortalecida);
        System.out.println("Tempo original: " + tempoOriginal);
        System.out.println("Tempo fortalecido: " + tempoFortalecido);
    }
}