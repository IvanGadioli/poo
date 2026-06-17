import java.util.Scanner;
import java.time.Year;

public class HealthProfile {

    // Atributos
    String nome;
    String sobrenome;
    char genero;
    int dia, mes, ano;
    double altura, peso;

    public PerfilSaude(String nome, String sobrenome, char genero,
                       int dia, int mes, int ano,
                       double altura, double peso) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularIdade(int anoAtual) {
        return anoAtual - ano;
    }

    public int calcularFrequenciaMaxima(int anoAtual) {
        return 220 - calcularIdade(anoAtual);
    }

    public String calcularFrequenciaAlvo(int anoAtual) {
        int max = calcularFrequenciaMaxima(anoAtual);
        int min = (int)(max * 0.5);
        int maxAlvo = (int)(max * 0.85);
        return min + " - " + maxAlvo + " bpm";
    }

    public double calcularIMC() {
        return (peso * 703) / (altura * altura);
    }

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public String getGeneroTexto() {
        return (genero == 'M' || genero == 'm') ? "Masculino" : "Feminino";
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Sobrenome: ");
        String sobrenome = input.nextLine();

        System.out.print("Gênero (M/F): ");
        char genero = input.next().charAt(0);

        System.out.print("Data de nascimento (dia mes ano): ");
        int dia = input.nextInt();
        int mes = input.nextInt();
        int ano = input.nextInt();

        System.out.print("Altura (polegadas): ");
        double altura = input.nextDouble();

        System.out.print("Peso (libras): ");
        double peso = input.nextDouble();

        PerfilSaude pessoa = new PerfilSaude(
                nome, sobrenome, genero,
                dia, mes, ano,
                altura, peso
        );

        int anoAtual = Year.now().getValue();

        System.out.println("\n--- Dados ---");
        System.out.println("Nome: " + pessoa.getNomeCompleto());
        System.out.println("Gênero: " + pessoa.getGeneroTexto());
        System.out.println("Nascimento: " + dia + "/" + mes + "/" + ano);
        System.out.println("Idade: " + pessoa.calcularIdade(anoAtual));
        System.out.printf("IMC: %.1f\n", pessoa.calcularIMC());
        System.out.println("Frequência Máxima: " + pessoa.calcularFrequenciaMaxima(anoAtual) + " bpm");
        System.out.println("Frequência Alvo: " + pessoa.calcularFrequenciaAlvo(anoAtual));

        System.out.println("\nTabela IMC:");
        System.out.println("<18.5 -> Abaixo do peso");
        System.out.println("18.5–24.9 -> Normal");
        System.out.println("25–29.9 -> Sobrepeso");
        System.out.println("30+ -> Obesidade");

        input.close();
    }
}