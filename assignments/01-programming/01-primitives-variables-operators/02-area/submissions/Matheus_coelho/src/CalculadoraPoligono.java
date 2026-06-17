import java.util.Scanner;

public class CalculadoraPoligono {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o número de lados do polígono: ");
        int n = sc.nextInt();
        System.out.print("Digite o comprimento do lado em metros: ");
        double s = sc.nextDouble();
        double area = calcularArea(n, s);
        System.out.println(formatarSaida(area));
    }

    public static double calcularArea(int n, double s) {
        return (1.0 / 4.0) * s * s * n * (1.0 / Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}
