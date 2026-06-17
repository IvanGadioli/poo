import java.util.Scanner;

public class HealthProfile {
    
    // Atributos da classe
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;
    public int currentYear = 2026;

    // Constructor
    public HealthProfile(
         String firstName,
         String lastName, 
         char gender, 
         int dayOfBirth, 
         int monthOfBirth, 
         int yearOfBirth, 
         double heightInInches, 
         double weightInPounds)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int currentYear = 2026;

        // Entrada de dados do usuário
        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();
        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);
        System.out.print("Digite sua data de nascimento (dia, mes e ano separados por espaço): ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();
        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = scanner.nextInt();
        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextInt();

        // Cria o objeto "pessoa"
        HealthProfile pessoa = new HealthProfile(firstName, lastName, gender, dayOfBirth, monthOfBirth, yearOfBirth, heightInInches, weightInPounds);

        // Utiliza os métodos
        int age = pessoa.calculateAge(currentYear);
        int maxHeartRate = pessoa.calculateMaxHeartRate();
        String target = pessoa.calculateTargetHeartRate();

        // Apresenta os resultados para o usuário
        System.out.println("Nome: "+ pessoa.getFirstName()+" "+pessoa.getLastName());
        if (pessoa.getGender()=='M' || pessoa.getGender()=='m'){
            System.out.println("Gênero: Masculino");
        } else if (pessoa.getGender()=='M' || pessoa.getGender()=='m'){
            System.out.println("Gênero: Feminino"+pessoa.getGender());
        } else {
            System.out.println("Gênero: Não informado");
        }
        System.out.println("Data de nascimento: "+ pessoa.getDayOfBirth()+"/"+pessoa.getMonthOfBirth()+"/"+pessoa.getYearOfBirth());
        System.out.println("Idade: "+age);
        System.out.println("Altura: "+pessoa.getHeightInInches());
        System.out.println("Peso: "+pessoa.getWeightInPounds());
        System.out.println("Índice de massa corporal (BMI): "+pessoa.calculateBMI());
        System.out.println("Frequência cardíaca máxima: "+maxHeartRate+" bpm");
        System.out.println("Faixa de frequência cardíaca alvo: "+target);

        // Tabela de BMI
        System.out.println("--------------------");
        System.out.println("Classificação de BMI");
        System.out.println(" <18.5 = Abaixo do peso");
        System.out.println(" 18.5 - 24.9 = Peso normal");
        System.out.println(" 25.0 - 29.9 = Sobrepeso");
        System.out.println(" >30.0 = Obesidade");
        System.out.println("--------------------");

        scanner.close();
    }

    // Métodos Essênciais
    public int calculateAge(int currentYear){
        return (currentYear - yearOfBirth);
    }
    public int calculateMaxHeartRate(){
        int age = calculateAge(this.currentYear);
        return (220 - age);
    }
    public String calculateTargetHeartRate(){
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) (maxHeartRate * 0.5);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }
    public double calculateBMI(){
        return (weightInPounds*703)/(heightInInches*heightInInches);
    }

    // Getters e Setters
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
    public char getGender() {
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

}
