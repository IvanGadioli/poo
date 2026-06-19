import java.util.Scanner;

public class GradeAnalyzer {

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static int findLowestGrade(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
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
        int[] frequency = new int[11];
        for (int grade : grades) {
            if (grade == 100) {
                frequency[10]++;
            } else {
                frequency[grade / 10]++;
            }
        }
        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency) {
        if (index == 10) {
            return String.format("100: %d", frequency);
        }
        int start = index * 10;
        int end = start + 9;
        return String.format("%02d-%02d: %d", start, end, frequency);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = 0;
        while (numStudents <= 0) {
            System.out.print("Digite a quantidade de estudantes: ");
            numStudents = scanner.nextInt();
            if (numStudents <= 0) {
                System.out.println("Quantidade inválida. Digite um valor maior que zero.");
            }
        }

        int[] grades = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            int grade = -1;
            while (grade < 0 || grade > 100) {
                System.out.print("Digite a nota do estudante " + (i + 1) + ": ");
                grade = scanner.nextInt();
                if (grade < 0 || grade > 100) {
                    System.out.println("Nota inválida. Digite um valor entre 0 e 100.");
                }
            }
            grades[i] = grade;
        }

        double average = calculateAverage(grades);
        int highest = findHighestGrade(grades);
        int lowest = findLowestGrade(grades);
        int aboveAverage = countGradesAtOrAboveAverage(grades);
        int[] frequency = calculateFrequency(grades);

        System.out.printf("%nMédia da turma: %.2f%n", average);
        System.out.println("Maior nota: " + highest);
        System.out.println("Menor nota: " + lowest);
        System.out.println("Notas acima ou iguais à média: " + aboveAverage);

        System.out.println("\nDistribuição de notas:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(formatFrequencyLine(i, frequency[i]));
        }

        scanner.close();
    }
}