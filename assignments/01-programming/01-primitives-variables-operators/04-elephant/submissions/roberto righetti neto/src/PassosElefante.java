import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = input.nextInt();

        // Validação do intervalo (1 ≤ x ≤ 1.000.000)
        if (x < 1 || x > 1000000) {
            System.out.println("Erro: A posição deve estar entre 1 e 1.000.000.");
        } else {
            // Calcula o mínimo de passos
            int passos = calcularPassosMinimos(x);

            // Formata e exibe a saída
            String resultado = formatarSaida(passos);
            System.out.println(resultado);
        }

        input.close();
    }

    public static int calcularPassosMinimos(int x) {
        /* * Lógica: Dividimos a distância por 5 (o maior passo).
         * Se houver resto, significa que precisamos de mais um passo 
         * (de tamanho 1, 2, 3 ou 4) para cobrir a sobra.
         */
        int passosDeCinco = x / 5;
        int resto = x % 5;

        if (resto == 0) {
            return passosDeCinco;
        } else {
            return passosDeCinco + 1;
        }
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}