import java.util.Scanner;

public class GradeAnalyzer {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numberOfStudents = 0;

    // Validação da quantidade de estudantes
    while (true) {
      System.out.print("Digite a quantidade de estudantes: ");
      numberOfStudents = scanner.nextInt();

      if (numberOfStudents > 0) {
        break; // Sai do laço se a entrada for válida
      }
      System.out.println("Quantidade inválida. Deve ser maior que zero.");
    }

    int[] grades = new int[numberOfStudents];

    for (int i = 0; i < numberOfStudents; i++) {
      while (true) {
        System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
        int grade = scanner.nextInt();

        if (grade >= 0 && grade <= 100) {
          grades[i] = grade;
          break; // Sai do laço de validação e avança para o próximo aluno
        }
        System.out.println("Nota inválida. Deve estar entre 0 e 100.");
      }
    }

    double average = calculateAverage(grades);
    int highest = findHighestGrade(grades);
    int lowest = findLowestGrade(grades);
    int aboveOrEqualAverage = countGradesAtOrAboveAverage(grades);
    int[] frequency = calculateFrequency(grades);

    // Impressão dos resultados no formato exigido
    System.out.println("\nMédia da turma: " + String.format(java.util.Locale.US, "%.2f", average));
    System.out.println("Maior nota: " + highest);
    System.out.println("Menor nota: " + lowest);
    System.out.println("Notas acima ou iguais à média: " + aboveOrEqualAverage);

    System.out.println("\nDistribuição de notas:");
    for (int i = 0; i < frequency.length; i++) {
      System.out.println(formatFrequencyLine(i, frequency[i]));
    }

    // Fechamento seguro do recurso de I/O
    scanner.close();
  }

  public static double calculateAverage(int[] grades) {
    double sum = 0;
    for (int grade : grades) {
      sum += grade;
    }
    return sum / grades.length;
  }

  public static int findHighestGrade(int[] grades) {
    int max = grades[0];
    for (int grade : grades) {
      if (grade > max) {
        max = grade;
      }
    }
    return max;
  }

  public static int findLowestGrade(int[] grades) {
    int min = grades[0];
    for (int grade : grades) {
      if (grade < min) {
        min = grade;
      }
    }
    return min;
  }

  public static int countGradesAtOrAboveAverage(int[] grades) {
    double average = calculateAverage(grades);
    int count = 0;
    for (int grade : grades) {
      if (grade >= average) {
        count++;
      }
    }
    return count;
  }

  public static int[] calculateFrequency(int[] grades) {
    int[] frequency = new int[11]; // Índices de 0 a 10
    for (int grade : grades) {
      int index = grade / 10;
      frequency[index]++;
    }
    return frequency;
  }

  public static String formatFrequencyLine(int index, int frequency) {
    if (index == 10) {
      return "100: " + frequency;
    } else {
      int start = index * 10;
      int end = start + 9;
      return String.format("%02d-%02d: %d", start, end, frequency);

    }
  }
}
