import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = entrada.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = entrada.nextDouble();

        double area = calcularArea(n, s);
        String resultado = formatarSaida(area);

        System.out.println(resultado);
    }

    public static double calcularArea(int n, double s) {
        double A = (1.0 / 4) * (s * s) * n * (1.0 / Math.tan(Math.PI / n));
        return A;

}
public static String formatarSaida(double area) {
    return String.format("A área do polígono é: %.2f metros quadrados", area);
}
}