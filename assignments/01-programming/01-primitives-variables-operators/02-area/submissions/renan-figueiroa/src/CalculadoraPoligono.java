import java.util.Scanner;

public class CalculadoraPoligono{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(java.util.Locale.US);

        System.out.println("Digite o número de lados do poligono: ");
        int lados = scanner.nextInt();
        System.out.println();

        System.out.println("Digite o comprimento do lado em metros: ");
        double tamanho_lados = scanner.nextDouble();
        System.out.println();

        Double Area = calcularArea(lados,tamanho_lados);

        String Saida = formatarSaida(Area);

        System.out.println(Saida);


    }
    public static double calcularArea(int n,double s){

        double A =  (1.0/4.0) * (s*s) * n * (1/(Math.tan(Math.PI/n)));
    
        return A;
    }
    
    public static String formatarSaida(double A){

        String texto_exibicao = String.format("A área do polígono é: %.2f metros quadrados", A);

        return texto_exibicao;
    }
    
}