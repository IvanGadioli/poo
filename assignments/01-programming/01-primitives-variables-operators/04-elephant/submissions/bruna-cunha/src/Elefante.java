import java.util.Scanner;

public class Elefante {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = input.nextInt();

        if (x < 1 || x > 1000000) {
            System.out.println("Por favor, digite um valor entre 1 e 1.000.000.");
        } else {

            int passos = calcularPassosMinimos(x);
            String resultado = formatarSaida(passos);

            System.out.println(resultado);
        }

        input.close();
    }

    
    public static int calcularPassosMinimos(int x) {
        int passosDeCinco = x / 5;
        int resto = x % 5;

        if (resto > 0) {
            return passosDeCinco + 1;
        } else {
            return passosDeCinco;
        }
    }

    
    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}