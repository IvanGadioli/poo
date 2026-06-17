import java.util.Scanner;

public class MedianCalculatorApp{
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            MedianCalculator medianCalculator = new MedianCalculator();

            System.out.print("Digite o primeiro número: ");
            int n1 = scanner.nextInt();
            System.out.print("Digite o segundo número: ");
            int n2 = scanner.nextInt();
            System.out.print("Digite o terceiro número: ");
            int n3 = scanner.nextInt();

            medianCalculator.setN1(n1);
            medianCalculator.setN2(n2);
            medianCalculator.setN3(n3);

            int a = medianCalculator.getN1();
            int b = medianCalculator.getN2();
            int c = medianCalculator.getN3();
            
            int median = medianCalculator.findMedian(a, b, c);

            System.out.println("A mediana dos números é: " + median);
        }
    }
}