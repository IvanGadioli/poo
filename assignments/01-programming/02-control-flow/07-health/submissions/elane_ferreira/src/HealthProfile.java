 import java.util.Scanner;

public class HealthProfile {
    
    private String firstName;
    private String lastName;
    private String gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, String gender, double heightInInches, double weightInPounds, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public double getHeightInInches() { return heightInInches; }
    public double getWeightInPounds() { return weightInPounds; }

    public int calculateAge(int currentYear) {
    return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int currentYear) {
    return 220 - calculateAge(currentYear);
    }
    public double[] calculateTargetHeartRate(int maxHeartRate) {
        double min = maxHeartRate * 0.50;
        double max = maxHeartRate * 0.85;
        return new double[]{min, max};
    }

    public double calculateBMI() {
    return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static String classificarIMC(double var0) {
      if (var0 < (double)18.5F) {
         return "Abaixo do peso";
      } else if (var0 >= (double)18.5F && var0 < 24.99) {
         return "Eutrófico";
      } else if (var0 >= (double)25.0F && var0 < 29.99) {
         return "Sobrepeso";
      } else if (var0 >= (double)30.0F && var0 < 34.99) {
         return "Obesidade grau I";
      } else {
         return var0 >= (double)35.0F && var0 < 39.99 ? "Obesidade grau II" : "Obesidade grau III";
      }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextDouble();

        HealthProfile person = new HealthProfile(
            firstName,
            lastName,
            String.valueOf(gender), 
            heightInInches,
            weightInPounds,
            day,
            month,
            year
        );

        int currentYear = 2026;

        int age = person.calculateAge(currentYear);
        int maxHeartRate = person.calculateMaxHeartRate(currentYear);
        double[] targetRange = person.calculateTargetHeartRate(maxHeartRate);
        double bmi = person.calculateBMI();

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" 
                + person.getMonthOfBirth() + "/" + person.getYearOfBirth());

        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.printf("Faixa de frequência cardíaca alvo: %.0f bpm - %.0f bpm\n",
                targetRange[0], targetRange[1]);

        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", bmi);
        System.out.println("Classificação: " + classificarIMC(bmi));

        scanner.close();
    }
}