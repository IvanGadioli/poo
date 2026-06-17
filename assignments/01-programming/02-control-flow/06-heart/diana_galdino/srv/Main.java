import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite dia mês e ano de nascimento: ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" +
                person.getMonthOfBirth() + "/" + person.getYearOfBirth());

        int age = person.calculateAge(2025);
        System.out.println("Idade: " + age + " anos");

        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");

        System.out.println("Faixa de frequência cardíaca alvo: " +
                person.calculateTargetHeartRate());

        input.close();
    }
}