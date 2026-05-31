import java.util.Scanner;

public class CalculadoraIMC {
  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    System.out.print("Digite seu peso em quilogramas:");
    double peso = teclado.nextDouble();

    System.out.print("Digite sua altura em metros:");
    double altura = teclado.nextDouble();

    double imCalculado = calcularIMC(peso, altura);

    String classificacao = classificarIMC(imCalculado);

    System.out.printf("Seu IMC é: %.2f\n", imCalculado);
    System.out.println("Classificação: " + classificacao);

    teclado.close();
  }

  public static double calcularIMC(double peso, double altura) {
    double IMC = peso / (altura * altura);
    return IMC;
  }

  public static String classificarIMC(double imc) {
    if (imc < 18.50) {
      return "Abaixo do peso";
    } else if (imc <= 24.99) {
      return "Eutrófico";
    } else if (imc < 29.99) {
      return "Sobrepeso";
    } else if (imc < 34.99) {
      return "Obesidade grau I";
    } else if (imc < 39.99) {
      return "Obesidade grau II";
    } else {
      return "Obesidade grau III";
    }
  }
}
