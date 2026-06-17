import java.util.Scanner;
import java.time.Year;

public class Main {

    static class HealthProfile {

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

        
        public int calculateAge(int currentYear) {
            return currentYear - yearOfBirth;
        }

        public int calculateMaxHeartRate(int currentYear) {
            int age = calculateAge(currentYear);
            return 220 - age;
        }

        public String calculateTargetHeartRate(int currentYear) {
            int max = calculateMaxHeartRate(currentYear);
            int minTarget = (int)(max * 0.50);
            int maxTarget = (int)(max * 0.85);
            return minTarget + " bpm - " + maxTarget + " bpm";
        }

        public double calculateBMI() {
            return (weightInPounds * 703) / (heightInInches * heightInInches);
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        
        System.out.print("Digite seu primeiro nome: ");
        String firstName = teclado.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = teclado.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = teclado.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = teclado.nextInt();
        int month = teclado.nextInt();
        int year = teclado.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = teclado.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = teclado.nextDouble();

        
        HealthProfile person = new HealthProfile(firstName, lastName, gender,
                day, month, year, height, weight);

        int currentYear = Year.now().getValue();

        
        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());

        String genderText = (Character.toUpperCase(person.getGender()) == 'M') ? "Masculino" : "Feminino";
        System.out.println("Gênero: " + genderText);

        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" +
                person.getMonthOfBirth() + "/" + person.getYearOfBirth());

        int age = person.calculateAge(currentYear);
        System.out.println("Idade: " + age + " anos");

        System.out.println("Altura: " + person.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + person.getWeightInPounds() + " libras");

        double bmi = person.calculateBMI();
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", bmi);

        int maxHR = person.calculateMaxHeartRate(currentYear);
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");

        System.out.println("Faixa de frequência cardíaca alvo: " +
                person.calculateTargetHeartRate(currentYear));

        
        System.out.println("\nTabela de referência do BMI:");
        System.out.println("BMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        teclado.close();
    }
}