// Atividade variáveis e operadores primitivos. Tarefa: Calcular a área de um polígono regular, tendo como entradas o numero (n) de lados e o comprimento do lado (s)
// A fórmula é: area = 1 / 4 * s^2 * n * 1 /  tan(pi)
// pi = Math.PI


// Importando as bibliotecas usadas
import java.util.Scanner;
import java.util.Locale;

// criação da classe
public class CalculadoraPoligono
{

    // método que calcula a área
    public static double calcularArea (int n, double s){

        double area = (1.0/4.0) * (s * s) * n * (1/ Math.tan(Math.PI/ n));
        return area;
    }

    // método que formata a saída
    public static String formatarSaida(double area){

        return String.format("A área do polígono é: %.2f metros quadrados.", area);
    }


    // main
    public static void main (String[] args){


        // criando o objeto do Scanner para ler os dados
        Scanner leitor = new Scanner(System.in).useLocale(Locale.US);
        
        double area = 0.0;

        
        System.out.print("Digite o número de lados do polígono: ");
        int n = leitor.nextInt();

        System.out.print("Digite o comprimento do lado em metros: ");
        double s = leitor.nextDouble();

        area = calcularArea(n, s);
        System.out.println(formatarSaida(area));




        leitor.close();

    }
}