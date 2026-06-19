import java.util.Collections;
import java.util.TreeSet;

public class TreeSetApp {

    public static void main(String[] args) {

        // **Criar e Imprimir TreeSet**
        System.out.println("1. Criar e Imprimir TreeSet");
        TreeSet<String> cores = new TreeSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo");
        cores.add("Roxo");
        cores.add("Laranja");
        cores.add("Rosa");
        System.out.println("TreeSet (ordenado): " + cores);

        // **Iterar Elementos do TreeSet**
        System.out.println("\n2. Iterar Elementos do TreeSet");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // **Adicionar Elementos a Outro TreeSet**
        System.out.println("\n3. Adicionar Elementos a Outro TreeSet");
        TreeSet<String> outrasCores = new TreeSet<>();
        outrasCores.add("Ciano");
        outrasCores.add("Magenta");
        outrasCores.addAll(cores);
        System.out.println("Novo TreeSet com todos os elementos: " + outrasCores);

        // **TreeSet em Ordem Reversa**
        System.out.println("\n4. TreeSet em Ordem Reversa");
        TreeSet<String> coresReversas = new TreeSet<>(Collections.reverseOrder());
        coresReversas.addAll(cores);
        System.out.println("TreeSet em ordem reversa: " + coresReversas);

        // **Obter Primeiro e Último Elemento**
        System.out.println("\n5. Obter Primeiro e Último Elemento");
        System.out.println("Primeiro elemento: " + cores.first());
        System.out.println("Último elemento:   " + cores.last());

        // **Clonar TreeSet**
        System.out.println("\n6. Clonar TreeSet");
        @SuppressWarnings("unchecked")
        TreeSet<String> coresClonadas = (TreeSet<String>) cores.clone();
        System.out.println("TreeSet original: " + cores);
        System.out.println("TreeSet clonado:  " + coresClonadas);

        // **Tamanho do TreeSet**
        System.out.println("\n7. Tamanho do TreeSet");
        System.out.println("Tamanho do TreeSet: " + cores.size());

        // **Comparar TreeSets**
        System.out.println("\n8. Comparar TreeSets");
        TreeSet<String> conjuntoIgual = new TreeSet<>(cores);
        TreeSet<String> conjuntoDiferente = new TreeSet<>();
        conjuntoDiferente.add("Índigo");
        conjuntoDiferente.add("Violeta");
        System.out.println("cores igual a conjuntoIgual (iguais):       " + cores.equals(conjuntoIgual));
        System.out.println("cores igual a conjuntoDiferente (diferentes): " + cores.equals(conjuntoDiferente));

        // **Elementos Menores que 7**
        System.out.println("\n9. Elementos Menores que 7");
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(1);
        numeros.add(3);
        numeros.add(5);
        numeros.add(7);
        numeros.add(9);
        numeros.add(2);
        numeros.add(4);
        numeros.add(6);
        numeros.add(8);
        numeros.add(10);
        System.out.println("TreeSet de números: " + numeros);
        System.out.println("Elementos menores que 7: " + numeros.headSet(7));

        // **Elemento Teto (Ceiling)**
        System.out.println("\n10. Elemento Teto (Ceiling)");
        System.out.println("TreeSet de números: " + numeros);
        System.out.println("Teto de 5 (>= 5): " + numeros.ceiling(5));
        System.out.println("Teto de 6 (>= 6): " + numeros.ceiling(6));

        // **Elemento Piso (Floor)**
        System.out.println("\n11. Elemento Piso (Floor)");
        System.out.println("Piso de 7 (<= 7): " + numeros.floor(7));
        System.out.println("Piso de 6 (<= 6): " + numeros.floor(6));

        // **Elemento Estritamente Maior (Higher)**
        System.out.println("\n12. Elemento Estritamente Maior (Higher)");
        System.out.println("Estritamente maior que 5 (> 5): " + numeros.higher(5));
        System.out.println("Estritamente maior que 6 (> 6): " + numeros.higher(6));

        // **Elemento Estritamente Menor (Lower)**
        System.out.println("\n13. Elemento Estritamente Menor (Lower)");
        System.out.println("Estritamente menor que 7 (< 7): " + numeros.lower(7));
        System.out.println("Estritamente menor que 6 (< 6): " + numeros.lower(6));

        // **Remover e Retornar o Primeiro Elemento**
        System.out.println("\n14. Remover e Retornar o Primeiro Elemento");
        System.out.println("Números antes do pollFirst: " + numeros);
        Integer primeiroRemovido = numeros.pollFirst();
        System.out.println("Primeiro elemento removido: " + primeiroRemovido);
        System.out.println("Números após o pollFirst: " + numeros);

        // **Remover e Retornar o Último Elemento**
        System.out.println("\n15. Remover e Retornar o Último Elemento");
        System.out.println("Números antes do pollLast: " + numeros);
        Integer ultimoRemovido = numeros.pollLast();
        System.out.println("Último elemento removido: " + ultimoRemovido);
        System.out.println("Números após o pollLast: " + numeros);

        // **Remover Elemento**
        System.out.println("\n16. Remover Elemento");
        System.out.println("Cores antes da remoção: " + cores);
        cores.remove("Roxo");
        System.out.println("Cores após remover 'Roxo': " + cores);
    }
}