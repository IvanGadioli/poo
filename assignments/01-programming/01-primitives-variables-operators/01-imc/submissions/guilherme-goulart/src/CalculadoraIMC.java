public class CalculadoraIMC {
    public static double calcularIMC(double peso, double altura) {
        double imc = peso / (altura * altura);
        return imc;
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.99) {
            return "Eutrófico";
        } else if (imc >= 25 && imc < 29.99) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.99) {
            return "Obesidade grau I"; 
        } else if (imc >= 35 && imc < 39.99) {
            return "Obesidade grau II"; 
        } else if (imc >= 35 && imc < 39.99) {
            return "Obesidade grau III"; 
        } else {
            return "Obesidade grau III";
        }
       
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();
        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(imc);

        System.out.printf("Seu IMC é: %.2f\n", imc);
        System.out.println("Classificação: " + classificacao);
    }

}