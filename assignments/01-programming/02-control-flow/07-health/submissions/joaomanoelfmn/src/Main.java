import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);
        int currentYear = LocalDate.now().getYear();

        String genderDisplay = (profile.getGender() == 'M') ? "Masculino" : "Feminino";

        System.out.println("\n--- Registro de Saúde Digital ---");
        System.out.println("Nome: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Gênero: " + genderDisplay);
        System.out.printf("Data de nascimento: %02d/%02d/%04d\n", 
                          profile.getDayOfBirth(), profile.getMonthOfBirth(), profile.getYearOfBirth());
        System.out.println("Idade: " + profile.calculateAge(currentYear) + " anos");
        System.out.println("Altura: " + profile.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + profile.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", profile.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + profile.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + profile.calculateTargetHeartRate());

        System.out.println("\n--- Tabela de Referência do BMI ---");
        System.out.println("| BMI              | Classificação               |");
        System.out.println("|------------------|-----------------------------|");
        System.out.println("| Menos de 18.5    | Abaixo do peso              |");
        System.out.println("| 18.5 – 24.9      | Peso normal                 |");
        System.out.println("| 25.0 – 29.9      | Sobrepeso                   |");
        System.out.println("| 30.0 ou mais     | Obesidade                   |");

        scanner.close();
    }
}