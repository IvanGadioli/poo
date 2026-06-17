public class Fibonacci {
    
    public static long calcularFibonacci(int n){
        long resultado = 0;
        if(n == 0){
            resultado = 0;
        } else if(n == 1){
            resultado = 1;
        } else {
            resultado = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }

        return resultado;
    }
    
    public static String formatarSaida(long resultado, int n){
        return String.format("O %dº número de Fibonacci é: %d", n, resultado);
    }
    
    public static void main(String[] arg){
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();

        long resultado = calcularFibonacci(n);
        
        String saida = formatarSaida(resultado, n);
        System.out.println(saida);

        scanner.close();
    }
}
