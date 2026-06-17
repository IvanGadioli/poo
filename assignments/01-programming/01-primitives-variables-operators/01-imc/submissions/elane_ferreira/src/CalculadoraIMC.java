import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = entrada.nextDouble();

        System.out.print("Digite sua altura em metros: ");
        double altura = entrada.nextDouble();

        double meuImc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(meuImc);

        System.out.printf("Seu IMC é: %.2f\n", meuImc);
        System.out.println("Classificação: " + classificacao);
    }

    public static double calcularIMC(double peso, double altura) {
        double imc = peso / (altura * altura);
        return imc;
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        }
        else if (imc >= 18.5 && imc < 24.99) {   
            return "Eutrófico";
        }
        else if (imc >= 25.0 && imc < 29.99) {
            return "Sobrepeso";
        }
        else if (imc >= 30.0 && imc < 34.99) {
            return "Obesidade grau I";
        }
        else if (imc >= 35.0 && imc < 39.99) {
            return "Obesidade grau II";
        }    
        else {
            return "Obesidade grau III";
        }
    }
}
  