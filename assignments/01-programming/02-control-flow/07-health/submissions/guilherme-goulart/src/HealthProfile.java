import java.util.Scanner; 

public class HealthProfile{
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public char getGender(){
        return gender;
    }
    public void setGender(char gender){
        this.gender = gender;
    }

    public int getDayOfBirth(){
        return dayOfBirth;
    }
    public void setDayOfBirth(int dayOfBirth){
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth(){
        return monthOfBirth;
    }
    public void setMonthOfBirth(int monthOfBirth){
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth(){
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }

    public double getHeightInInches(){
        return heightInInches;
    }
    public void setHeightInInches(double heightInInches){
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds(){
        return weightInPounds;
    }
    public void setWeightInPounds(double weightInPounds){
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge(int currentYear){
        return currentYear - yearOfBirth;
    }
    public int calculateAge() {
        return 2025 - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(2025);
    }

    public String calculateTargetHeartRate() {
    int maxHeartRate = calculateMaxHeartRate();
    int minTarget = (int) Math.round(maxHeartRate * 0.50);
    int maxTarget = (int) Math.round(maxHeartRate * 0.85);
    return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String fName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lName = sc.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char g = sc.next().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double altura = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double peso = sc.nextDouble();

        HealthProfile paciente = new HealthProfile(fName, lName, g, dia, mes, ano, altura, peso);

        // Impressão
        System.out.println("Nome: " + paciente.getFirstName() + " " + paciente.getLastName());
        
        String generoExtenso = (paciente.getGender() == 'M') ? "Masculino" : "Feminino";
        System.out.println("Gênero: " + generoExtenso);
        
        System.out.println("Data de nascimento: " + paciente.getDayOfBirth() + "/" + paciente.getMonthOfBirth() + "/" + paciente.getYearOfBirth());
        
        System.out.println("Idade: " + paciente.calculateAge(2025) + " anos");

        System.out.println("Altura: " + paciente.getHeightInInches() + " polegadas");

        System.out.println("Peso: " + paciente.getWeightInPounds() + " libras");

        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", paciente.calculateBMI());

        System.out.println("Frequência cardíaca máxima: " + paciente.calculateMaxHeartRate() + " bpm");

        System.out.println("Faixa de frequência cardíaca alvo: " + paciente.calculateTargetHeartRate());

        //Tabela BMI
        double imc = paciente.calculateBMI();

        if(imc < 18.5) {
            System.out.println("Abaixo do peso");
        } else if(imc >= 18.5 && imc <= 24.9) {
            System.out.println("Normal");
        } else if(imc >= 25 && imc <= 29.9) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Obeso");
        }
        sc.close();
    }
}
