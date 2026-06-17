import java.util.Scanner;

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        }
        if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo numero: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro numero: ");
        int num3 = scanner.nextInt();

        System.out.println("A mediana dos numeros e: " + findMedian(num1, num2, num3));
    }
}
