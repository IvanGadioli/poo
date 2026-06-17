import java.util.Scanner;

public class CalculadoraPoligono {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();

        double area = calcularArea(n, s);
        String resultado = formatarSaida(area);

        System.out.println(resultado);

        scanner.close();
    }

    public static double calcularArea(int n, double s) {
       
        return 0.25 * Math.pow(s, 2) * (n / Math.tan(Math.PI / n));
        
    }

    public static String formatarSaida(double area) {
        String areaFormatada = String.format("%.2f", area);
        return "A área do polígono é: " + areaFormatada + " metros quadrados";
    }
}