import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posicao da casa do amigo: ");
        int x = scanner.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("A posicao deve estar entre 1 e 1000000.");
        } else {
            int passos = calcularPassosMinimos(x);
            System.out.println(formatarSaida(passos));
        }

        scanner.close();
    }

    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5;
    }

    public static String formatarSaida(int passos) {
        return String.format("O numero minimo de passos necessarios e: %d", passos);
    }
}
