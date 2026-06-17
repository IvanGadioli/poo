import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;

        // Requisito 7: Garantir que x esteja dentro do intervalo (1 <= x <= 1.000.000)
        while (true) {
            System.out.print("Digite a posição da casa do amigo: ");
            x = scanner.nextInt();

            if (x >= 1 && x <= 1000000) {
                break; // Sai do loop se o valor for válido
            } else {
                System.out.println("Valor inválido. Por favor, insira um número entre 1 e 1.000.000.");
            }
        }

        // Calcula os passos e formata a saída
        int passosMinimos = calcularPassosMinimos(x);
        String mensagemFinal = formatarSaida(passosMinimos);

        // Imprime o resultado no console
        System.out.println(mensagemFinal);

        scanner.close();
    }

    // Requisito 4: Método para calcular a quantidade mínima de passos
    public static int calcularPassosMinimos(int x) {
        // Como o elefante quer chegar o mais rápido possível, 
        // ele deve dar o maior número possível de passos de tamanho 5.
        int passos = x / 5;
        
        // Se houver algum resto (1, 2, 3 ou 4), ele precisará de apenas mais 1 passo
        // para cobrir essa distância restante.
        if (x % 5 != 0) {
            passos++;
        }
        
        return passos;
    }

    // Requisito 5: Método para formatar a string de saída
    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}