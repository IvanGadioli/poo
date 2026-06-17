import java.util.Scanner;
import java.time.LocalDate;
import java.util.Locale;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, 
                         int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge(int currentYear) {
        int age = currentYear - yearOfBirth;
        LocalDate today = LocalDate.now();
        if (today.getMonthValue() < monthOfBirth || 
           (today.getMonthValue() == monthOfBirth && today.getDayOfMonth() < dayOfBirth)) {
            age--;
        }
        return age;
    }

    public int calculateMaxHeartRate() {
        int currentYear = 2025;
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate() {
        int maxHR = calculateMaxHeartRate();
        int minTarget = (int) (maxHR * 0.50);
        int maxTarget = (int) (maxHR * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public double getHeightInInches() { return heightInInches; }
    public void setHeightInInches(double heightInInches) { this.heightInInches = heightInInches; }
    public double getWeightInPounds() { return weightInPounds; }
    public void setWeightInPounds(double weightInPounds) { this.weightInPounds = weightInPounds; }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int currentYear = 2025;

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.next();
        System.out.print("Digite seu sobrenome: ");
        String lastName = input.next();
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

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        System.out.println("Nome: " + profile.getFirstName() + " " + profile.getLastName());
        String genderDisplay = (Character.toUpperCase(profile.getGender()) == 'M') ? "Masculino" : "Feminino";
        System.out.println("Gênero: " + genderDisplay);
        
        System.out.printf("Data de nascimento: %02d/%02d/%04d%n", profile.getDayOfBirth(), profile.getMonthOfBirth(), profile.getYearOfBirth());
        System.out.println("Idade: " + profile.calculateAge(currentYear) + " anos");
        System.out.printf("Altura: %.0f polegadas%n", profile.getHeightInInches());
        System.out.printf("Peso: %.0f libras%n", profile.getWeightInPounds());
        
        System.out.printf(Locale.US, "Índice de Massa Corporal (BMI): %.1f%n", profile.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + profile.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + profile.calculateTargetHeartRate());

        System.out.println("BMI           | Classificação");
        System.out.println("--------------|----------------");
        System.out.println("Menos de 18.5 | Abaixo do peso");
        System.out.println("18.5 - 24.9   | Peso normal");
        System.out.println("25.0 - 29.9   | Sobrepeso");
        System.out.println("30.0 ou mais  | Obesidade");

        input.close();
    }
}