public class CalculadoraPoligono {
    public static double calcularArea(int n, double s) {
        double area = (n * (s * s)) / (4 * Math.tan(Math.PI / n));
        return area;
    }

    public static String formatarSaida(double area) {
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }


    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();
        double area = calcularArea(n, s);

        String resultado = formatarSaida(area);
        System.out.println(resultado);

        scanner.close();
    }
}
