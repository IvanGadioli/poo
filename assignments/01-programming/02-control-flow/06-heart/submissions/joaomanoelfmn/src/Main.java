import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        int currentYear = LocalDate.now().getYear();

        System.out.println("\n--- Resultado da Avaliação ---");
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        
        System.out.printf("Data de nascimento: %02d/%02d/%04d\n", 
                          person.getDayOfBirth(), 
                          person.getMonthOfBirth(), 
                          person.getYearOfBirth());
                          
        System.out.println("Idade: " + person.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        scanner.close();
    }
}