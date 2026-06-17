import java.util.Scanner;

public class PassosElefante{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");

        int n = scan.nextInt();

        if(n < 1 || n > 1000000){ 
            System.out.println("Número inválido! Finalizando o programa!!!");
            System.exit(1); 
        }

        System.out.println(formatarSaida(calcularPassosMinimos(n)));
    
        scan.close();

    }

    public static int calcularPassosMinimos(int x){
        if (x % 5 == 0) return x/5;
        else return(x/5 + 1);
    }

    public static String formatarSaida(int passos){
        return String.format("\nO número mínimo de passos necessários é: %d", passos);
    }
}