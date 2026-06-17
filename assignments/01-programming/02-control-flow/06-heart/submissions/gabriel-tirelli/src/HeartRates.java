import java.util.Scanner;

public class HeartRates {

    // Atributos da classe
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    public int currentYear = 2026;

    // Construct 
    public HeartRates(
        String firstName,
        String lastName,
        int dayOfBirth,
        int monthOfBirth,
        int yearOfBirth)
    {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);    
        
        // Recebe as entradas do usuário
        System.out.print("Digite seu primeiro nome: ");
        String primeiroNome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite a data de nascimento (dia, mes e ano separados por espaço): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();

        // Cria o objeto "pessoa"
        HeartRates pessoa = new HeartRates(primeiroNome, sobrenome, dia, mes, ano);

        int currentYear = 2026; 
        int age = pessoa.calculateAge(currentYear);
        int maxHeartRate = pessoa.calculateMaxHeartRate();
        String target = pessoa.calculateTargetHeartRate();

        System.out.println("Nome: "+ pessoa.getFirstName()+" "+pessoa.getLastName());
        System.out.println("Data de nascimento: "+ pessoa.getDayOfBirth()+"/"+pessoa.getMonthOfBirth()+"/"+pessoa.getYearOfBirth());
        System.out.println("Idade: "+age);
        System.out.println("Frequência cardíaca máxima: "+maxHeartRate+" bpm");
        System.out.println("Faixa de frequência cardíaca alvo: "+target);

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
        int maxTarget = (int) (maxHeartRate * 0.85);
        int minTarget = (int) (maxHeartRate * 0.5);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    //Getters e Setters
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
}



