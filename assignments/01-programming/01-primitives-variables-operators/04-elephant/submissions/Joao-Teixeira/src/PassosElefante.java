
import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: "); 
        int x = scanner.nextInt();

        int passos = calcularPassosMinimos(x);

        System.out.print(formatarSaida(passos));

        scanner.close();
    }

    public static int calcularPassosMinimos(int x){

        if(x%5 == 0)return x/5;
        else{
            int passosDeCincoCasas = x/5;
            return passosDeCincoCasas + 1;
        }
    }

    public static String formatarSaida(int passos){
        return String.format("O número mínimo de passos necessários é: %d\n",passos);
    }
}
