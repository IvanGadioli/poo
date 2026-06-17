import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("Valor inválido.");
        } else {
            int passos = calcularPassosMinimos(x);
            String mensagem = formatarSaida(passos);

            System.out.println(mensagem);
        }

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        int passos = x / 5; 
        int resto = x % 5;  

        if (resto > 0) {
            passos = passos + 1;
        }

        return passos;
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}