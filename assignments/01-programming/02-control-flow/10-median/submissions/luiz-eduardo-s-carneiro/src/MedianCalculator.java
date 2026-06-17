public class MedianCalculator{
    private int n1;
    private int n2;
    private int n3;

    public MedianCalculator(){
    }

    public MedianCalculator(int n1, int n2, int n3){
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public void setN1(int n1){
        if(n1 <= 0){ 
            System.out.printf("Erro: O número deve ser um inteiro positivo."); 
        } else{ 
            this.n1 = n1; 
        }
    }

    public int getN1(){
        return n1;
    }

    public void setN2(int n2){
        if(n2 <= 0){ 
            System.out.printf("Erro: O número deve ser um inteiro positivo."); 
        } else{ 
            this.n2 = n2; 
        }
    }

    public int getN2(){
        return n2;
    }

    public void setN3(int n3){
        if(n3 <= 0){ 
            System.out.printf("Erro: O número deve ser um inteiro positivo."); 
        } else{ 
            this.n3 = n3; 
        }
    }

    public int getN3(){
        return n3;
    }

    public static int findMedian(int a, int b, int c){
        if((a <= b && b <= c) || (c <= b && b <= a)){
            return b;
        } 
        else if((a <= c && c <= b) || (b <= c && c <= a)){ 
            return c;
        }
        else{
            return a;
        }
    }
}