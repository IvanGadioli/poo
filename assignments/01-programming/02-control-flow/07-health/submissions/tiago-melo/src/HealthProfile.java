public class HealthProfile {
    private static final int REFERENCE_YEAR = 2025;

    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender,
                         int dayOfBirth, int monthOfBirth, int yearOfBirth,
                         double heightInInches, double weightInPounds) {
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

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public String getGenderFull() {
        if (gender == 'M' || gender == 'm') {
            return "Masculino";
        }
        if (gender == 'F' || gender == 'f') {
            return "Feminino";
        }
        return "Nao informado";
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu genero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mes e ano separados por espaco): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        HealthProfile person = new HealthProfile(
                firstName, lastName, gender, day, month, year, height, weight
        );

        int currentYear = REFERENCE_YEAR;
        int age = person.calculateAge(currentYear);
        int maxHeartRate = person.calculateMaxHeartRate();
        String targetHeartRate = person.calculateTargetHeartRate();
        double bmi = person.calculateBMI();

        System.out.println();
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Genero: " + person.getGenderFull());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n",
                person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + person.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + person.getWeightInPounds() + " libras");
        System.out.printf("Indice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.println("Frequencia cardiaca maxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequencia cardiaca alvo: " + targetHeartRate);

        System.out.println();
        System.out.println("Tabela de referencia do BMI:");
        System.out.println("Menos de 18.5      -> Abaixo do peso");
        System.out.println("18.5 - 24.9        -> Peso normal");
        System.out.println("25.0 - 29.9        -> Sobrepeso");
        System.out.println("30.0 ou mais       -> Obesidade");
    }
}
