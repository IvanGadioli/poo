public class CollatzSequence{

    private int n;

    public CollatzSequence(){
    }

    public CollatzSequence(int n){
        this.n = n;
    }

    public void setN(int n){
        if(n <= 0){ 
            System.out.printf("Erro: O número deve ser um inteiro positivo."); 
        } else{ 
            this.n = n; 
        }
    }

    public int getN(){
        return n;
    }

    public static int nextCollatz(int n){
        int next = 0;
        if(n % 2 == 0){
            next = n / 2;
        } else {
            next = (n * 3) + 1;
        }
        return next;
    }

    public static int calculateCollatzSum(int n){
        int soma = 0;
        while(n != 1){
            System.out.printf("%d --> ", n);
            soma += n;
            n = nextCollatz(n);
        }
        System.out.printf("%d", n);
        soma += n;
        return soma;
    }
}