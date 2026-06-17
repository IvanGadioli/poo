import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o numero de lados do poligono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double area = calcularArea(n, s);
        System.out.println(formatarSaida(area));

        scanner.close();
    }

    public static double calcularArea(int n, double s) {
        return 0.25 * s * s * n * (1.0 / Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}
