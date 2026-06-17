
import java.util.Random;
import java.util.Scanner;

public class FortalecerSenha {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Digite a senha: ");
      String s = scanner.nextLine();
      if(s.length() > 10 || s.length() < 1){
         System.out.print("\n erro! a senha deve ter entre 1 e 10 caracteres\n");
         System.exit(1);
      }
      
      int tempo = calcularTempoDigitacao(s);
      String sNovo = fortalecerSenha(s);
      int tempoNovo = calcularTempoDigitacao(sNovo);
      System.out.println("senha antiga: " + s + " tempo: " + tempo + 
      "\nsenha nova: " + sNovo + " tempo: " + tempoNovo);

      scanner.close();
   }

   public static String fortalecerSenha(String s) {
      Random random = new Random();
      String s_temp = s;
      String letras = "qwertyuiopasdfghjklzxcvbnm";
      int indexletras = random.nextInt(1,27);
      int tam = s.length();
               
      int indexrepetido = 0;

      for(byte i = 1;i<tam;i++){
         if(s.charAt(i) == s.charAt(i-1)){
            indexrepetido = i;
            break;
         }
      }
   
      if(indexrepetido != 0){

         while(letras.charAt(indexletras) == s.charAt(indexrepetido) || letras.charAt(indexletras) == s.charAt(indexrepetido-1)){
            indexletras = random.nextInt(1,27);
         }

         s_temp = s.substring(0,indexrepetido) + letras.charAt(indexletras) + s.substring(indexrepetido);
      }else{

         int indexAleatorio = random.nextInt(0,tam);

         if(tam == 1){
         while(letras.charAt(indexletras) == s.charAt(0)){
            indexletras = random.nextInt(1,27);
         }
         }
         
         s_temp = s.substring(0,indexAleatorio) + letras.charAt(indexletras) + s.substring(indexAleatorio);

      }

      return s_temp;
   }
   

   public static int calcularTempoDigitacao(String s) {
      int tempo = 2;

      if(s.length() == 1) return tempo;

      for(byte i = 1;i<s.length();i++){
         if(s.charAt(i-1) == s.charAt(i)){
            tempo+=1;
         }else{
            tempo+=2;
         }
      }
      return tempo;
   }
}
