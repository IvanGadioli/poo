import java.util.Scanner;

public class CalculadoraIMC {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu peso em quilogramas:");
        double peso = entrada.nextDouble();

        System.out.println("Digite sua altura em metros:");
        double altura = entrada.nextDouble();

        double imc = calcularIMC(peso, altura);

        String classificacao = classificarIMC(imc);

        System.out.println("Seu IMC é: " + imc);
        System.out.println("Classificação: " + classificacao);

        entrada.close();
    }

    public static double calcularIMC(double peso, double altura) {
        double resultado = peso / (altura * altura);
        return resultado;
    }

    public static String classificarIMC(double imc) {

        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25.0) {
            return "Eutrófico";
        } else if (imc >= 25.0 && imc < 30.0) {
            return "Sobrepeso";
        } else if (imc >= 30.0 && imc < 35.0) {
            return "Obesidade grau I";
        } else if (imc >= 35.0 && imc < 40.0) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}