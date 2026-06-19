import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        int soma = 0;
        for (int nota : grades) {
            soma += nota;
        }
        return (double) soma / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int maior = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > maior) {
                maior = grades[i];
            }
        }
        return maior;
    }

    public static int findLowestGrade(int[] grades) {
        int menor = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] < menor) {
                menor = grades[i];
            }
        }
        return menor;
    }

    public static int countGradesAtOrAboveAverage(int[] grades) {
        double media = calculateAverage(grades);
        int quantidade = 0;
        for (int nota : grades) {
            if (nota >= media) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static int[] calculateFrequency(int[] grades) {
        int[] frequencia = new int[11];
        for (int nota : grades) {
            if (nota == 100) {
                frequencia[10]++;
            } else {
                frequencia[nota / 10]++;
            }
        }
        return frequencia;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return "100: " + frequency;
        }
        int inicio = index * 10;
        int fim = inicio + 9;
        return String.format("%02d-%02d: %d", inicio, fim, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantidadeEstudantes = 0;
        while (quantidadeEstudantes <= 0) {
            System.out.print("Digite a quantidade de estudantes: ");
            quantidadeEstudantes = scanner.nextInt();
            if (quantidadeEstudantes <= 0) {
                System.out.println("Quantidade inválida. Informe um valor maior que zero.");
            }
        }

        int[] notas = new int[quantidadeEstudantes];
        for (int i = 0; i < quantidadeEstudantes; i++) {
            int nota = -1;
            while (nota < 0 || nota > 100) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                nota = scanner.nextInt();
                if (nota < 0 || nota > 100) {
                    System.out.println("Nota inválida. Informe um valor entre 0 e 100.");
                }
            }
            notas[i] = nota;
        }

        scanner.close();

        double media = calculateAverage(notas);
        int maiorNota = findHighestGrade(notas);
        int menorNota = findLowestGrade(notas);
        int acimaDaMedia = countGradesAtOrAboveAverage(notas);
        int[] frequencia = calculateFrequency(notas);

        System.out.printf("Média da turma: %.2f%n", media);
        System.out.println("Maior nota: " + maiorNota);
        System.out.println("Menor nota: " + menorNota);
        System.out.println("Notas acima ou iguais à média: " + acimaDaMedia);

        System.out.println("\nDistribuição de notas:");
        for (int i = 0; i < frequencia.length; i++) {
            System.out.println(formatFrequencyLine(i, frequencia[i]));
        }
    }
}
