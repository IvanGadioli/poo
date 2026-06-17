// Atividade variáveis e operadores primitivos. Tarefa: Calcular o Índice de Massa Corporal (IMC) de acordo com o peso em KG e peso em metros.
// A fórmula é: IMC = peso / altura^2
// A classificação é:
/**
 * Abaixo do peso: IMC < 18.50
 * Eutrófico: 18.5 <= IMC < 24.99
 * Sobrepeso: 25.0 <= IMC < 29.99
 * Obesidade grau 1: 30.0 <= IMC < 34.99
 * Obesidade grau 2: 35.0 <= IMC < 39.99
 * Obesidade grau 3: IMC >= 40.0
 */
import java.io.Console;




public class CalculadoraIMC
{
     

    

    public static double calcularIMC (double peso, double altura){
        
       double imc = peso / (altura * altura);
        
        return imc;
    }

    public static String classificarIMC(double imc){


        String classificacaoIMC = "";
        if (imc < 18.50){

             classificacaoIMC = "Abaixo do peso ";
        }
        else if (18.50 <= imc && imc < 24.99){

            classificacaoIMC = "Eutrófico ";
        } else if (25.0 <= imc && imc <29.99){

            classificacaoIMC ="Sobrepeso ";
        } else if (30 <= imc && imc < 34.99){

            classificacaoIMC = "Obesidade grau 1 ";
        } else if (35 <= imc && imc < 39.99){

            classificacaoIMC = "Obesidade grau 2 ";
        } else if (imc >= 40){

            classificacaoIMC = "Obesidade grau 3 ";
        } else {
            System.out.println("Valor inválido! ");
        }

       return classificacaoIMC;
    }
   public static void main(String[] args) {


    Console console = System.console();
    double imc = 0.0;
    String classificacaoIMC = "";
    
    
    String pesoStr = console.readLine("Digite o seu peso em quilogramas: ");
    double peso = Double.parseDouble(pesoStr);

    String alturaStr = console.readLine("Digite a sua altura em metros: ");
    double altura = Double.parseDouble(alturaStr);

    imc = calcularIMC(peso, altura);
    classificacaoIMC = classificarIMC(imc);

    System.out.printf("Seu IMC é: %.2f%n", imc);
    System.out.printf("Classificação: %s%n", classificacaoIMC);
    
    
   }
   
}