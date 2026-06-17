import java.util.Scanner;

    
public class HeartRates {
    
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }


    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int age) {
        return 220 - age;
    }

    public double[] calculateTargetHeartRate(int maxHeartRate) {
        double min = maxHeartRate * 0.50;
        double max = maxHeartRate * 0.85;
        return new double[]{min, max};
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        int currentYear = 2026;

        int age = person.calculateAge(currentYear);
        int maxHeartRate = person.calculateMaxHeartRate(age);
        double[] targetRange = person.calculateTargetHeartRate(maxHeartRate);

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" 
                + person.getMonthOfBirth() + "/" + person.getYearOfBirth());

        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
        System.out.printf("Faixa de frequência cardíaca alvo: %.0f bpm - %.0f bpm\n",
                targetRange[0], targetRange[1]);

        scanner.close();
    }
}