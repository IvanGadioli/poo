import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int lados = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double comprimento = scanner.nextDouble();

        double area = calcularArea(lados, comprimento);
        String saida = formatarSaida(area);
        System.out.println(saida);
    }

    public static double calcularArea(int lados, double lado) {
        return (1.0 / 4) * lados * Math.pow(lado, 2) / Math.tan(Math.PI / lados);
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}
