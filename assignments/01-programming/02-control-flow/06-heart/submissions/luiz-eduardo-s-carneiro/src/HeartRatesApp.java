import java.util.Scanner;

public class HeartRatesApp{
    
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            HeartRates person = new HeartRates();

            int currentYear = 2024;

            System.out.printf("Digite o seu primeiro nome: ");
            String firstName = scanner.next();

            System.out.printf("Digite o seu sobrenome: ");
            String lastName = scanner.next();

            System.out.printf("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int dayOfBirth = scanner.nextInt();
            int monthOfBirth = scanner.nextInt();
            int yearOfBirth = scanner.nextInt();

            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setDayOfBirth(dayOfBirth);
            person.setMonthOfBirth(monthOfBirth);
            person.setYearOfBirth(yearOfBirth);

            System.out.printf("Nome: %s %s\n", person.getFirstName(), person.getLastName());
            System.out.printf("Data de nascimento: %d/%d/%d\n", person.getDayOfBirth(), 
                    person.getMonthOfBirth(), person.getYearOfBirth());
            System.out.printf("Idade: %d\n", person.calculateAge(currentYear));
            System.out.printf("Frequência cardíaca máxima: %d bpm\n", person.calculateMaxHeartRate());
            System.out.printf("Faixa de frequência cardíaca alvo: %s\n", person.calculateTargetHeartRate());
        }
    }
}