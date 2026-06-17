import java.util.Random;
import java.util.Scanner;

public class FortalecerSenha{

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    static String caracteresPossiveis = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        System.out.print("Digite a senha: ");
        String senha = scan.nextLine().trim();

        if(senha.length() < 1 || senha.length() > 10 || senha.isEmpty() || senha != senha.toLowerCase()){
            System.out.println("Forma inválida de senha!");
            System.exit(1);
        }

        System.out.println("Sua senha: " + senha + "\n> " + calcularTempoDigitacao(senha) + "s");

        String novaSenha = fortalecerSenha(senha);
        System.out.println("Nova senha: " + novaSenha + "\n> " + calcularTempoDigitacao(novaSenha) + "s");

        scan.close();

    }

    public static String fortalecerSenha(String s){
        int tempoAtual = 0;
        String novaString = s;

        if(s.length() == 10){

            System.out.println("\nSenha de tamanho máximo!");

            for(int i = 1; i < 10; i++){
                if(s.charAt(i-1) == s.charAt(i)){
                    novaString = s.substring(0,i) + caracteresPossiveis.charAt(random.nextInt(0,26)) + s.substring(i);
                    return novaString;
                }

                if(i == 9){ 
                    novaString = s.substring(0,i) + caracteresPossiveis.charAt(random.nextInt(0,26)) + s.substring(i);
                    return novaString;
                }
            }
        }

        for(int i = 0; i < s.length(); i++){

            novaString = s.substring(0,i) + caracteresPossiveis.charAt(random.nextInt(0,26)) + s.substring(i);
            tempoAtual = calcularTempoDigitacao(novaString);

            if(i > 1 && s.charAt(i) == s.charAt(i-1)){
                novaString = s.substring(0,i) + caracteresPossiveis.charAt(random.nextInt(0,26)) + s.substring(i);
                return novaString;
            }
        
            if(tempoAtual < calcularTempoDigitacao(s)){
                break;
            }
        }

        return novaString;
    }

    public static int calcularTempoDigitacao(String s){

        int tempo = 2;

        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                tempo++;
            } else {
                tempo += 2;
            }
        }   

        return tempo;
    }
}