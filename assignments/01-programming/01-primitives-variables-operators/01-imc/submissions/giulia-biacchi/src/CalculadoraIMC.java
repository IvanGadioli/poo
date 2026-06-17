import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite seu peso:");
        double peso = input.nextDouble();

        System.out.println("Digite sua altura:");
        double altura = input.nextDouble();

        double imc = peso / (altura * altura);

        String resultado = classificarIMC(imc);

        System.out.println("Seu IMC é: " + imc);
        System.out.println(resultado);

        input.close();
    }

    public static String classificarIMC(double imc) {

        if (imc < 18.5) {
            return "Magreza";
        }
        else if (imc < 25) {
            return "Normal";
        }
        else if (imc < 30) {
            return "Sobrepeso";
        }
        else if (imc < 35) {
            return "Obesidade grau I";
        }
        else if (imc < 40) {
            return "Obesidade grau II";
        }
        else {
            return "Obesidade grau III";
        }
    }
}