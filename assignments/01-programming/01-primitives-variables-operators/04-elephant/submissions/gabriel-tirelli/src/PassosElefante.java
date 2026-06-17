import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("O valor deve estar entre 1 e 1.000.000.");
        } else {
            int passos = calcularPassosMinimos(x);
            String mensagem = formatarSaida(passos);
            System.out.println(mensagem);
        }

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        int passos;
        passos = x / 5;
        if (x % 5 != 0) {
            passos = passos + 1;
        }
        return passos;
    }

    public static String formatarSaida(int passos) {
        String texto;
        texto = "O número mínimo de passos necessários é: " + passos;
        return texto;
    }
}