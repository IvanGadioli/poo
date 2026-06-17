import java.util.Scanner;

public class PassosElefante {
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite a posição da casa do amigo:");
        int posição = ler.nextInt();
        
        if (posição >= 0 && posição <= 1000000){
        int resposta = calcularPassosMinimos(posição);
        String tf = formatarSaida(resposta);
        System.out.println(tf);
        
        } else {
            System.out.println("O número deve está entre 0 e 1000000.");
        }
    }

    public static int calcularPassosMinimos(int x){
        int passosmin = 0;
        if(x % 5 != 0) {
            passosmin = (x/5) + 1;

        }else{
            passosmin = x/5;

        }
        
        return passosmin;
    }

    public static String formatarSaida(int passos) {
    return String.format("O número mínimo de passos necessários é: %d", passos);
}
}
