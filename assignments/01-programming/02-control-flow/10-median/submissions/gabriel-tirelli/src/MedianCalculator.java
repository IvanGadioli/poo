import java.util.Scanner;

public class MedianCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();
        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        int mediana = findMedian(num1, num2, num3);
        System.out.println("A mediana dos números é: " + mediana);

        scanner.close();
    }

    public static int findMedian(int num1, int num2, int num3) {

        if ((num1 >= num2 && num1 <= num3) || (num1 >= num3 && num1 <= num2)) {
            return num1;
        } 
        else if ((num2 >= num1 && num2 <= num3) || (num2 >= num3 && num2 <= num1)) {
            return num2;
        } 
        else {
            return num3;
        }
    }

}