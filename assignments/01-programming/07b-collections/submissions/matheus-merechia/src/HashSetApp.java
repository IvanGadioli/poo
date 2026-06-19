import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetApp {

    public static void main(String[] args) {

        // **Adicionar Elemento ao HashSet**
        System.out.println("1. Adicionar Elemento ao HashSet");
        HashSet<String> cores = new HashSet<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo");
        cores.add("Roxo");
        cores.add("Laranja");
        System.out.println("HashSet após adicionar elementos: " + cores);

        // **Iterar Elementos do HashSet**
        System.out.println("\n2. Iterar Elementos do HashSet");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // **Obter Tamanho do HashSet**
        System.out.println("\n3. Obter Tamanho do HashSet");
        System.out.println("Tamanho do HashSet: " + cores.size());

        // **Limpar HashSet**
        System.out.println("\n4. Limpar HashSet");
        HashSet<String> conjuntoTemp = new HashSet<>(cores);
        conjuntoTemp.clear();
        System.out.println("HashSet após limpar: " + conjuntoTemp);
        System.out.println("(Conjunto de trabalho preservado: " + cores + ")");

        // **Verificar se o HashSet está Vazio**
        System.out.println("\n5. Verificar se o HashSet está Vazio");
        System.out.println("'cores' está vazio? " + cores.isEmpty());
        System.out.println("'conjuntoTemp' está vazio? " + conjuntoTemp.isEmpty());

        // **Clonar HashSet**
        System.out.println("\n6. Clonar HashSet");
        @SuppressWarnings("unchecked")
        HashSet<String> conjuntoClonado = (HashSet<String>) cores.clone();
        System.out.println("Conjunto original: " + cores);
        System.out.println("Conjunto clonado:  " + conjuntoClonado);

        // **Converter HashSet para Array**
        System.out.println("\n7. Converter HashSet para Array");
        Object[] arrayCores = cores.toArray();
        System.out.println("Array: " + Arrays.toString(arrayCores));

        // **Converter HashSet para TreeSet**
        System.out.println("\n8. Converter HashSet para TreeSet");
        TreeSet<String> coresTreeSet = new TreeSet<>(cores);
        System.out.println("TreeSet (ordenado): " + coresTreeSet);

        // **Encontrar Elementos Menores que 7**
        System.out.println("\n9. Encontrar Elementos Menores que 7");
        TreeSet<Integer> numeros = new TreeSet<>(Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8, 10));
        System.out.println("TreeSet de números: " + numeros);
        System.out.println("Elementos menores que 7: " + numeros.headSet(7));

        // **Comparar Dois HashSets**
        System.out.println("\n10. Comparar Dois HashSets");
        HashSet<String> outroConjunto = new HashSet<>(cores);
        HashSet<String> conjuntoDiferente = new HashSet<>();
        conjuntoDiferente.add("Ciano");
        conjuntoDiferente.add("Magenta");
        System.out.println("cores igual a outroConjunto (iguais):     " + cores.equals(outroConjunto));
        System.out.println("cores igual a conjuntoDiferente (diferentes): " + cores.equals(conjuntoDiferente));

        // **Manter Elementos em Comum**
        System.out.println("\n11. Manter Elementos em Comum");
        HashSet<String> conjuntoRetencao = new HashSet<>(cores);
        HashSet<String> coresComuns = new HashSet<>();
        coresComuns.add("Vermelho");
        coresComuns.add("Azul");
        coresComuns.add("Ciano");
        System.out.println("Antes do retainAll: " + conjuntoRetencao);
        System.out.println("Mantendo elementos de: " + coresComuns);
        conjuntoRetencao.retainAll(coresComuns);
        System.out.println("Após o retainAll: " + conjuntoRetencao);

        // **Remover Todos do HashSet**
        System.out.println("\n12. Remover Todos do HashSet");
        HashSet<String> conjuntoRemocao = new HashSet<>(cores);
        HashSet<String> aRemover = new HashSet<>();
        aRemover.add("Vermelho");
        aRemover.add("Verde");
        aRemover.add("Azul");
        System.out.println("Antes do removeAll: " + conjuntoRemocao);
        System.out.println("Removendo elementos: " + aRemover);
        conjuntoRemocao.removeAll(aRemover);
        System.out.println("Após o removeAll: " + conjuntoRemocao);
    }
}