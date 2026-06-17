import java.util.Scanner;

public class CalculadoraPoligono{

    public static double calcularArea(int n, double s){
        double area = (1.0 / 4) * (s * s) * n * (1 / Math.tan(Math.PI / n));
        return area;
    }

    public static String formatarSaida(double area){
        return "A área do polígono é: " + String.format("%.2f", area) + " metros quadrados";
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int n;
        double s;
        double area;

        System.out.print("Digite o número de lados do poligono: ");
        n = teclado.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        s = teclado.nextDouble();

        area = calcularArea(n, s);

        String resultado = formatarSaida(area);

        System.out.println(resultado);

        teclado.close();
    }
}