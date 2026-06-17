
    import java.util.Scanner;
    import java.time.LocalDate;

public class HeartRateTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
  
        int currentYear = LocalDate.now().getYear();

        System.out.println("--- Monitoramento de Frequência Cardíaca ---");
        
        System.out.print("Digite seu primeiro nome: ");
        String name = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        
        HeartRates person = new HeartRates(name, lastName, day, month, year);

        System.out.println("\n-------------------------------------------");
        System.out.printf("Nome: %s %s%n", person.getFirstName(), person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", 
                person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        
        System.out.printf("Idade: %d anos%n", person.calculateAge(currentYear));
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", person.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", person.calculateTargetHeartRate());
        System.out.println("-------------------------------------------");
        
        input.close();
    }
}
    

