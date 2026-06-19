import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListApp {

    public static void main(String[] args) {

        // **Adicionar Elemento ao Final**
        System.out.println("1. Adicionar Elemento ao Final");
        LinkedList<String> cores = new LinkedList<>();
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");
        cores.add("Amarelo");
        cores.add("Roxo");
        System.out.println("Lista após adicionar elementos: " + cores);

        // **Iterar Elementos da Lista Encadeada**
        System.out.println("\n2. Iterar Elementos da Lista Encadeada");
        for (String cor : cores) {
            System.out.println(cor);
        }

        // **Iterar a Partir de uma Posição**
        System.out.println("\n3. Iterar a Partir de uma Posição");
        int posicaoInicial = 2;
        System.out.println("Iterando a partir da posição " + posicaoInicial + ":");
        for (int i = posicaoInicial; i < cores.size(); i++) {
            System.out.println(cores.get(i));
        }

        // **Iterar em Ordem Inversa**
        System.out.println("\n4. Iterar em Ordem Inversa");
        for (int i = cores.size() - 1; i >= 0; i--) {
            System.out.println(cores.get(i));
        }

        // **Inserir em uma Posição**
        System.out.println("\n5. Inserir em uma Posição");
        cores.add(2, "Laranja");
        System.out.println("Lista após inserir 'Laranja' na posição 2: " + cores);

        // **Inserir no Início e no Final**
        System.out.println("\n6. Inserir no Início e no Final");
        cores.addFirst("Rosa");
        cores.addLast("Marrom");
        System.out.println("Lista após inserir 'Rosa' no início e 'Marrom' no final: " + cores);

        // **Inserir no Início**
        System.out.println("\n7. Inserir no Início");
        cores.addFirst("Branco");
        System.out.println("Lista após inserir 'Branco' no início: " + cores);

        // **Inserir no Final**
        System.out.println("\n8. Inserir no Final");
        cores.addLast("Preto");
        System.out.println("Lista após inserir 'Preto' no final: " + cores);

        // **Inserir Vários Elementos em uma Posição**
        System.out.println("\n9. Inserir Vários Elementos em uma Posição");
        LinkedList<String> novasCores = new LinkedList<>();
        novasCores.add("Ciano");
        novasCores.add("Magenta");
        cores.addAll(3, novasCores);
        System.out.println("Lista após inserir ['Ciano', 'Magenta'] na posição 3: " + cores);

        // **Primeira e Última Ocorrência**
        System.out.println("\n10. Primeira e Última Ocorrência");
        cores.add(5, "Vermelho");
        String alvo = "Vermelho";
        int primeiraOcorrencia = cores.indexOf(alvo);
        int ultimaOcorrencia = cores.lastIndexOf(alvo);
        System.out.println("Primeira ocorrência de '" + alvo + "': índice " + primeiraOcorrencia);
        System.out.println("Última ocorrência de '" + alvo + "': índice " + ultimaOcorrencia);

        // **Imprimir Elementos com Posições**
        System.out.println("\n11. Imprimir Elementos com Posições");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }

        // **Remover Elemento**
        System.out.println("\n12. Remover Elemento");
        cores.remove("Ciano");
        System.out.println("Lista após remover 'Ciano': " + cores);

        // **Remover Primeiro e Último**
        System.out.println("\n13. Remover Primeiro e Último");
        String primeiroRemovido = cores.removeFirst();
        String ultimoRemovido = cores.removeLast();
        System.out.println("Primeiro removido: " + primeiroRemovido);
        System.out.println("Último removido: " + ultimoRemovido);
        System.out.println("Lista após remover primeiro e último: " + cores);

        // **Limpar Lista Encadeada**
        System.out.println("\n14. Limpar Lista Encadeada");
        LinkedList<String> listaTemp = new LinkedList<>(cores);
        listaTemp.clear();
        System.out.println("Lista após limpar: " + listaTemp);
        System.out.println("(Lista de trabalho preservada: " + cores + ")");

        // **Trocar Elementos**
        System.out.println("\n15. Trocar Elementos");
        int posA = 1, posB = 3;
        System.out.println("Antes da troca (posições " + posA + " e " + posB + "): " + cores);
        String elementoA = cores.get(posA);
        String elementoB = cores.get(posB);
        cores.set(posA, elementoB);
        cores.set(posB, elementoA);
        System.out.println("Após a troca: " + cores);

        // **Embaralhar Lista Encadeada**
        System.out.println("\n16. Embaralhar Lista Encadeada");
        System.out.println("Antes de embaralhar: " + cores);
        Collections.shuffle(cores);
        System.out.println("Após embaralhar: " + cores);

        // **Unir Listas Encadeadas**
        System.out.println("\n17. Unir Listas Encadeadas");
        LinkedList<String> listaA = new LinkedList<>();
        listaA.add("Vermelho");
        listaA.add("Verde");
        LinkedList<String> listaB = new LinkedList<>();
        listaB.add("Azul");
        listaB.add("Amarelo");
        LinkedList<String> listaUnida = new LinkedList<>();
        listaUnida.addAll(listaA);
        listaUnida.addAll(listaB);
        System.out.println("Lista A: " + listaA);
        System.out.println("Lista B: " + listaB);
        System.out.println("Lista unida: " + listaUnida);

        // **Copiar Lista Encadeada**
        System.out.println("\n18. Copiar Lista Encadeada");
        LinkedList<String> listaCopida = new LinkedList<>(cores);
        System.out.println("Lista original: " + cores);
        System.out.println("Lista copiada:  " + listaCopida);

        // **Remover e Retornar o Primeiro Elemento**
        System.out.println("\n19. Remover e Retornar o Primeiro Elemento");
        String primeiroExtraido = cores.pollFirst();
        System.out.println("Primeiro elemento extraído: " + primeiroExtraido);
        System.out.println("Lista após extração: " + cores);

        // **Consultar Primeiro Elemento sem Remover**
        System.out.println("\n20. Consultar Primeiro Elemento sem Remover");
        String consultaPrimeiro = cores.peekFirst();
        System.out.println("Primeiro elemento (sem remover): " + consultaPrimeiro);
        System.out.println("Lista inalterada: " + cores);

        // **Consultar Último Elemento sem Remover**
        System.out.println("\n21. Consultar Último Elemento sem Remover");
        String consultaUltimo = cores.peekLast();
        System.out.println("Último elemento (sem remover): " + consultaUltimo);
        System.out.println("Lista inalterada: " + cores);

        // **Verificar se Contém Elemento**
        System.out.println("\n22. Verificar se Contém Elemento");
        String corBuscada = "Verde";
        System.out.println("Contém '" + corBuscada + "': " + cores.contains(corBuscada));
        System.out.println("Contém 'Violeta': " + cores.contains("Violeta"));

        // **Converter para ArrayList**
        System.out.println("\n23. Converter para ArrayList");
        ArrayList<String> arrayList = new ArrayList<>(cores);
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Tipo: " + arrayList.getClass().getSimpleName());

        // **Comparar Listas Encadeadas**
        System.out.println("\n24. Comparar Listas Encadeadas");
        LinkedList<String> listaIgual = new LinkedList<>(cores);
        LinkedList<String> listaDiferente = new LinkedList<>();
        listaDiferente.add("Índigo");
        listaDiferente.add("Violeta");
        System.out.println("cores igual a listaIgual (iguais):       " + cores.equals(listaIgual));
        System.out.println("cores igual a listaDiferente (diferentes): " + cores.equals(listaDiferente));

        // **Verificar se está Vazia**
        System.out.println("\n25. Verificar se está Vazia");
        System.out.println("'cores' está vazia? " + cores.isEmpty());
        LinkedList<String> listaVazia = new LinkedList<>();
        System.out.println("'listaVazia' está vazia? " + listaVazia.isEmpty());

        // **Substituir Elemento**
        System.out.println("\n26. Substituir Elemento");
        int indiceSubstituicao = 0;
        System.out.println("Antes da substituição na posição " + indiceSubstituicao + ": " + cores);
        cores.set(indiceSubstituicao, "Turquesa");
        System.out.println("Após substituir posição " + indiceSubstituicao + " por 'Turquesa': " + cores);
    }
}