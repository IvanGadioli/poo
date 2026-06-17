import java.util.Scanner;

public class CalculadoraIMC {

    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        System.out.printf("Digite seu peso(kg): ");
        double peso = scanner.nextDouble();
        System.out.printf("Digite sua altura(m): ");
        double altura = scanner.nextDouble();

        scanner.close();

        double IMC = calcularIMC(peso, altura);
        String classificacao = classificarIMC(IMC);

        System.out.printf("Seu IMC é: %.2f\nClassificação: %s\n", IMC, classificacao);
    }   

    public static double calcularIMC(double peso, double altura){
        return peso / (altura * altura);
    }

    public static String classificarIMC(double IMC) { 
        if( IMC < 18.50){
            return "Abaixo do peso";
        } else if( 18.5 <= IMC && IMC <= 24.99) {
            return "Eutrófico";
        }  else if( 25.0 <= IMC && IMC <= 29.99) {
            return "Sobrepeso";
        } else if( 30.0 <= IMC && IMC <= 34.99) {
            return "Obesidade grau I";
        } else if( 35.0 <= IMC && IMC <= 39.99) {
            return "Obesidade grau II";
        } else if(IMC >= 40.0) {
            return "Obesidade grau III";
        }

        return "Erro";

    }

}


