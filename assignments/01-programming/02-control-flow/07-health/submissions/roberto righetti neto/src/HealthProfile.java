import java.time.LocalDate;
import java.util.Scanner;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(LocalDate.now().getYear());
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        HealthProfile patient = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        System.out.printf("\nNome: %s %s\n", patient.getFirstName(), patient.getLastName());
        System.out.printf("Gênero: %s\n", (patient.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %d/%d/%d\n", patient.getDayOfBirth(), patient.getMonthOfBirth(), patient.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", patient.calculateAge(LocalDate.now().getYear()));
        System.out.printf("Altura: %.0f polegadas\n", patient.getHeightInInches());
        System.out.printf("Peso: %.0f libras\n", patient.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", patient.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", patient.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n", patient.calculateTargetHeartRate());

        System.out.println("\nBMI Classificação:");
        System.out.println("| BMI             | Classificação            |");
        System.out.println("|-----------------|--------------------------|");
        System.out.println("| Menos de 18.5   | Abaixo do peso           |");
        System.out.println("| 18.5 – 24.9     | Peso normal              |");
        System.out.println("| 25.0 – 29.9     | Sobrepeso                |");
        System.out.println("| 30.0 ou mais    | Obesidade                |");

        input.close();
    }
}
