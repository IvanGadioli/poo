import java.util.Scanner;
import java.time.Year;

public class Main {

    
    static class HeartRates {

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

        // Calcular idade
        public int calculateAge(int currentYear) {
            return currentYear - yearOfBirth;
        }

    
        public int calculateMaxHeartRate(int currentYear) {
            int age = calculateAge(currentYear);
            return 220 - age;
        }

        
        public String calculateTargetHeartRate(int currentYear) {
            int maxHeartRate = calculateMaxHeartRate(currentYear);
            int minTarget = (int) (maxHeartRate * 0.50);
            int maxTarget = (int) (maxHeartRate * 0.85);

            return minTarget + " bpm - " + maxTarget + " bpm";
        }
    }

    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Entrada
        System.out.print("Digite seu primeiro nome: ");
        String firstName = teclado.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = teclado.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = teclado.nextInt();
        int month = teclado.nextInt();
        int year = teclado.nextInt();

        
        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        int currentYear = Year.now().getValue();

        
        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" +
                person.getMonthOfBirth() + "/" + person.getYearOfBirth());

        int age = person.calculateAge(currentYear);
        System.out.println("Idade: " + age + " anos");

        int maxHeartRate = person.calculateMaxHeartRate(currentYear);
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");

        System.out.println("Faixa de frequência cardíaca alvo: " +
                person.calculateTargetHeartRate(currentYear));

        teclado.close();
    }
}