public class HeartRates {
    private static final int REFERENCE_YEAR = 2025;

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

    public int calculateAge(int currentYear) {
        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.LocalDate referenceDate = java.time.LocalDate.of(
                currentYear,
                today.getMonthValue(),
                Math.min(today.getDayOfMonth(), java.time.Month.of(today.getMonthValue()).length(java.time.Year.isLeap(currentYear)))
        );
        java.time.LocalDate birthDate = java.time.LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        return java.time.Period.between(birthDate, referenceDate).getYears();
    }

    public int calculateMaxHeartRate() {
        int age = calculateAge(REFERENCE_YEAR);
        return 220 - age;
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int min = (int) (maxHeartRate * 0.50);
        int max = (int) (maxHeartRate * 0.85);
        return min + " bpm - " + max + " bpm";
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia mes ano): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        int currentYear = REFERENCE_YEAR;
        int age = person.calculateAge(currentYear);
        int maxHR = person.calculateMaxHeartRate();
        String targetHR = person.calculateTargetHeartRate();

        System.out.println();
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: "
                + person.getDayOfBirth() + "/"
                + person.getMonthOfBirth() + "/"
                + person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequencia cardiaca maxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequencia cardiaca alvo: " + targetHR);
    }
}
