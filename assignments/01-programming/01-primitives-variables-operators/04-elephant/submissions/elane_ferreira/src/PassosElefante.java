import java.util.Scanner;

public class PassosElefante {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite a posição da casa do amigo: ");
        int x = entrada.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("Erro: A posição deve estar entre 1 e 1.000.000");
            return;
        }
        
        int passos = calcularPassosMinimos(x);
        String texto = formatarSaida(passos);
        
        System.out.println(texto);
        
        entrada.close();
    }
    
    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5;
    }
    
    public static String formatarSaida(int valor) {
        return String.format("O número mínimo de passos necessários é: %d", valor);
    }
}