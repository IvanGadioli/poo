
import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de lados do polígono: "); 
        int n = scanner.nextInt();
        System.out.print("Digite sua altura em metros: ");
        double s = scanner.nextDouble();

        double area = calcularArea(n, s);

        System.out.print(formatarSaida(area));

        scanner.close();
    }

    public static double calcularArea(int n, double s){

        return (0.25 * Math.pow(s, 2)) * (n /Math.tan(Math.PI / n));
    }

    public static String formatarSaida(double area){
        return String.format("A área do polígono é: %.2f metros quadrados",area);
    }
}
