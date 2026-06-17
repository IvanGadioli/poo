import java.util.Scanner;

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {

        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            return a;
        }else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            return b;
        }else {
            return c;
        }
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Digite o primeiro número: ");
            int num1 = input.nextInt();

            System.out.print("Digite o segundo número: ");
            int num2 = input.nextInt();

            System.out.print("Digite o terceiro número: ");
            int num3 = input.nextInt();

            int mediana = findMedian(num1, num2, num3);

            System.out.println("A mediana dos números é: " + mediana);
        }
    }
}