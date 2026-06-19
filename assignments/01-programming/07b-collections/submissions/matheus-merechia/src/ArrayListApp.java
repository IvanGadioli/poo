import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ArrayListApp{
    public static void main(String[]args){
        //**Create and Print ArrayList**

        List cor = new ArrayList();
        cor.add("Verde");
        cor.add("Amarelo");
        cor.add("Azul");
        cor.add("Branco");
        System.out.println(cor);

        //**Iterate ArrayList Elements**

        for(int i = 0; i < cor.size(); i++){
            System.out.println(cor.get(i));
        }

        //**Insert at First Position**

        cor.add(0, "Vermelho");

        //**Retrieve Element by Index**

        if (2 < cor.size()) {
            Object elementoCorIndex = cor.get(2);
            System.out.println(elementoCorIndex);
        }

        //**Update ArrayList Element**

        cor.set(2, "Rosa");
        System.out.println( cor.get(2));

        //**Remove Third Element**

        cor.remove(2);
    
        //**Search Element in ArrayList**

        if(cor.contains("Rosa")){
            System.out.println("true");

        }else{
            System.out.println("false");
        }

        //**Sort ArrayList**

        Collections.sort(cor);
        
        //**Copy ArrayList**

        List corCopia = new ArrayList(cor);

        for(int i = 0; i < cor.size(); i++){
            corCopia.add(cor.get(i));
        }

        //**Shuffle ArrayList**

        Collections.shuffle(cor);

        //**Reverse ArrayList**

        Collections.reverse(cor);
        
        //**Extract Sublist from ArrayList**

        List subcor = cor.subList(1, 3);

        System.out.println(subcor);

        //**Compare Two ArrayLists**

        if (cor.equals(subcor)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }


        //**Swap ArrayList Elements**

        Collections.swap(cor, 0, 1);

        //**Join Two ArrayLists**

        List dupla = new ArrayList();
        dupla.addAll(cor);
        dupla.addAll(subcor);
        System.out.println(dupla);

        //**Clone ArrayList**
       
        List<String> duplaClone = new ArrayList<>(dupla);
        
        Object arrayClonado = ((ArrayList<String>) duplaClone).clone();

        System.out.println(duplaClone);
        
        //**Clear ArrayList**

        duplaClone.clear();
        System.out.println(duplaClone);

        //**Check if ArrayList is Empty**

        if (duplaClone.isEmpty()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        //**Trim ArrayList Capacity**

        ((ArrayList<String>) duplaClone).trimToSize();
        
        //**Increase ArrayList Capacity**

        ((ArrayList<String>) duplaClone).ensureCapacity(10);

        System.out.println(duplaClone.size());

        //**Replace Second Element**

        ((ArrayList<String>) duplaClone).set(1, "Preto");

        System.out.println(duplaClone);

        System.out.println(arrayClonado);

        //**Print Elements by Position**
        for(int i = 0; i < duplaClone.size(); i++){
            System.out.println(duplaClone.get(i));
        }
    }
}
