import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: ");
        int n = scan.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scan.nextDouble();

        double area = calcularArea(n, s);

        System.out.println(formatarSaida(area));

        scan.close();
    }

    public static double calcularArea(int n, double s){
        return (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double area){
        return String.format("A área do polígono é: %.2f metros quadrados",area);
    }

}
