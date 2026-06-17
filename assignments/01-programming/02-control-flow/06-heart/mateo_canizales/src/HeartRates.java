import java.time.Year;
import java.util.Scanner;

public class HeartRates {

    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName,
                      int day, int month, int year) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int day) { this.dayOfBirth = day; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int month) { this.monthOfBirth = month; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int year) { this.yearOfBirth = year; }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate(int currentYear) {
        int max = calculateMaxHeartRate(currentYear);
        int min = (int)(max * 0.5);
        int maxTarget = (int)(max * 0.85);
        return min + " bpm - " + maxTarget + " bpm";
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia mes ano): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        int currentYear = Year.now().getValue();

        System.out.println("\n--- Dados ---");
        System.out.println("Nome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.println("Data de nascimento: " +
                pessoa.getDayOfBirth() + "/" +
                pessoa.getMonthOfBirth() + "/" +
                pessoa.getYearOfBirth());

        System.out.println("Idade: " + pessoa.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " +
                pessoa.calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " +
                pessoa.calculateTargetHeartRate(currentYear));

        input.close();
    }
}