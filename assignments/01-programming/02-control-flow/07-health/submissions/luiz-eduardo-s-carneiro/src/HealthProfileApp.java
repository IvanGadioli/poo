import java.util.Scanner;

public class HealthProfileApp{
    
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)){
            HealthProfile person = new HealthProfile();

            int currentYear = 2024;

            System.out.printf("Digite o seu primeiro nome: ");
            String firstName = scanner.next();

            System.out.printf("Digite o seu sobrenome: ");
            String lastName = scanner.next();
            
            System.out.printf("Digite seu gênero (M/F): ");
            char gender = scanner.next().charAt(0);

            System.out.printf("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int dayOfBirth = scanner.nextInt();
            int monthOfBirth = scanner.nextInt();
            int yearOfBirth = scanner.nextInt();
            
            System.out.printf("Digite sua altura em polegadas: ");
            double heighInInches = scanner.nextDouble();

            System.out.printf("Digite seu peso em libras: ");
            double weightInPounds = scanner.nextDouble();

            
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setDayOfBirth(dayOfBirth);
            person.setMonthOfBirth(monthOfBirth);
            person.setYearOfBirth(yearOfBirth);            
            person.setHeighInInches(heighInInches);
            person.setWeightInPounds(weightInPounds);
            person.setGender(gender);

            System.out.printf("\nNome: %s %s\n", person.getFirstName(), person.getLastName());
            System.out.printf("Gênero: %s\n", person.getGender());
            System.out.printf("Data de nascimento: %d/%d/%d\n", person.getDayOfBirth(), 
                    person.getMonthOfBirth(), person.getYearOfBirth());
            System.out.printf("Idade: %d anos\n", person.calculateAge(currentYear));
            System.out.printf("Altura: %.0f polegadas\n", person.getHeighInInches());
            System.out.printf("Peso: %.0f libras\n", person.getWeightInPounds());
            System.out.printf("Índice de Massa Corporal (BMI): %.0f\n", person.calculateBMI());
            System.out.printf("Frequência cardíaca máxima: %d bpm\n", person.calculateMaxHeartRate());
            System.out.printf("Faixa de frequência cardíaca alvo: %s\n", person.calculateTargetHeartRate());
            System.out.println("-------------------------------------------------");
            System.out.println("|           BMI            |    Classificação   |");
            System.out.println("|-----------------------------------------------|");
            System.out.println("|      Menos de 18.5       |   Abaixo do peso   |");
            System.out.println("|       18.5 – 24.9        |     Peso normal    |");
            System.out.println("|       25.0 – 29.9        |      Sobrepeso     |");
            System.out.println("|       30.0 ou mais       |      Obesidade     |");
            System.out.println("-------------------------------------------------");
        }
    }
}