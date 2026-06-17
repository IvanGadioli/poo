public class PassosElefante {
    public static int calcularPassosMinimos(int x){
        if (x>= 1 && x<= 1000000){
            int passos = 0;
            while(x > 0){
                if(x >= 5){
                    x -= 5;
                } else if(x >= 4){
                    x -= 4;
                } else if(x >= 3){
                    x -= 3;
                } else if(x >= 2){
                    x -= 2;
                } else {
                    x -= 1;
                }
                passos++;
            }
            return passos;
        } else {
            throw new IllegalArgumentException("A posição deve ser entre 1 e 1.000.000.");
        }
    
    }

    public static String formatarSaida(int passos){
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }

    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        int passos = calcularPassosMinimos(x);
        String saida = formatarSaida(passos);
        System.out.println(saida);

        scanner.close();
    }
}
