
import java.util.Scanner;

public class CalculadoraIMC{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        int peso = scan.nextInt();

        System.out.print("Digite sua altura em metros: ");
        double altura = scan.nextDouble();

        double imc = calcularIMC(peso, altura);

        System.out.printf("Seu IMC é: %.2f\n",imc);
        System.out.printf("Classificação: %s\n", classificarIMC(imc));

        scan.close();

    }

    public static double calcularIMC(double peso, double altura){
        return peso / (altura * altura);
    }

    public static String classificarIMC(double imc){
        if(imc < 18.5) return "Abaixo do peso";
        else if(imc < 25) return "Eutrófico";
        else if(imc < 30) return "Sobrepeso";
        else if(imc < 35) return "Obesidade grau I";
        else if(imc < 40) return "Obesidade grau II";
        else return "Obesidade grau III";
    }
}