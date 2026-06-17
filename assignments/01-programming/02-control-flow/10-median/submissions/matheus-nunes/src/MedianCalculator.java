import java.util.Scanner;

public class Main {

    static class MedianCalculator {

        public static int findMedian(int a, int b, int c) {

            
            if ((a >= b && a <= c) || (a <= b && a >= c)) {
                return a;
            }
            
            else if ((b >= a && b <= c) || (b <= a && b >= c)) {
                return b;
            }
            
            else {
                return c;
            }
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = teclado.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = teclado.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = teclado.nextInt();

        int mediana = MedianCalculator.findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + mediana);

        teclado.close();
    }
}