import java.util.Scanner;

public class PassosElefante {

    public static int calcularPassosMinimos(int x) {
        int passos = x / 5;

        if (x % 5 != 0) {
            passos++;
        }

        return passos;
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = teclado.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("Valor inválido! Digite um número entre 1 e 1.000.000.");
            return;
        }

        int passos = calcularPassosMinimos(x);

        String saida = formatarSaida(passos);

        System.out.println(saida);

        teclado.close();
    }
}