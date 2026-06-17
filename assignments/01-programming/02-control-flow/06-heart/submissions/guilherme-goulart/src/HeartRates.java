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
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(2026);
    }

    public String calculateTargetHeartRate(){
        int maxHeartRate = calculateMaxHeartRate();
        int lower = (int) (maxHeartRate * 0.5);
        int upper = (int) (maxHeartRate * 0.85);
        return String.format("%d - %d bpm", lower, upper);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu primeiro nome: ");
        String fName = sc.nextLine();

        System.out.println("Digite seu sobrenome: ");
        String lName = sc.nextLine();

        System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        String[] birthData = sc.nextLine().split(" ");
        int dia = Integer.parseInt(birthData[0]);
        int mes = Integer.parseInt(birthData[1]);
        int ano = Integer.parseInt(birthData[2]);

        HeartRates person = new HeartRates(fName, lName, dia, mes, ano);

        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de Nascimento: " + person.getDayOfBirth() + "/" + person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge(2026) + " anos");
        System.out.println("Frequência Cardíaca Máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        sc.close();
    }
}
